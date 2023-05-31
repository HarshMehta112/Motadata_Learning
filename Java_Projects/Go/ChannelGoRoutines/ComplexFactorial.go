package main

import (
	"fmt"
	"runtime"
	"sync"
)

func fact(n int, channel chan int) {
	result := 1

	defer func() {
		channel <- result
	}()

	for i := n; i > 1; i-- {
		result *= i
	}
}

func main() {

	var wg sync.WaitGroup
	//defer wg.Wait() //Writing wait in defer will never work as it executes after return!!

	wg.Add(2)

	channel := make(chan int, 100)

	defer close(channel)

	go func() {
		go fact(10, channel)

		fmt.Println("In first", <-channel)

		wg.Done()
	}()

	go func() {

		go fact(1000000, channel)

		fmt.Println("In Second", <-channel)

		wg.Done()
	}()

	fmt.Println(runtime.NumGoroutine())
	wg.Wait()
}
