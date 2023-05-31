package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func bufftask1(channel chan int) {
	time.Sleep(time.Second * 4)

	channel <- 10
	channel <- 20
	channel <- 30

	close(channel)
}

func bufftask2(channel chan int) {
	defer wg.Done()
	time.Sleep(8 * time.Second)

	channel <- 40
	channel <- 50
	channel <- 60

}

func main() {
	wg.Add(1)
	channel := make(chan int, 5)

	go bufftask1(channel)

	go bufftask2(channel)

	fmt.Println(<-channel)
	fmt.Println(<-channel)
	fmt.Println(<-channel)
	wg.Wait()
	fmt.Println(<-channel)
	fmt.Println(<-channel)
	fmt.Println(<-channel)
	fmt.Println(<-channel)
}
