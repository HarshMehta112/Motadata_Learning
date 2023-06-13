package main

import (
	"fmt"
	"strconv"
	"sync"
)

func worker(wg *sync.WaitGroup, channel chan string, i int) {

	defer wg.Done()
	channel <- "worker " + strconv.Itoa(i)
}

func monitorWroker(wg *sync.WaitGroup, channel chan string) {
	defer wg.Done()
	for i := range channel {
		fmt.Println(i)
	}
}

func main() {

	wg := &sync.WaitGroup{}

	channel := make(chan string)

	go monitorWroker(wg, channel)

	for i := 0; i < 10; i++ {
		wg.Add(1)
		go worker(wg, channel, i)
	}
	wg.Wait()
	close(channel)

}
