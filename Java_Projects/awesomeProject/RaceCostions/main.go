package main

import (
	"fmt"
	"sync"
	"time"
)

// This is called the data race problem
/**
the value of any changes depending on the order in which goroutines finish
So if we want to check where the race condtion occurred we need to run the program with -race flag
Command : = go run -race main.go
*/

func main() {
	const goRoutines = 100

	var wg sync.WaitGroup

	wg.Add(2 * goRoutines)

	var n int = 0

	for i := 0; i < goRoutines; i++ {
		go func() {
			time.Sleep(time.Second * 10)
			n++
			wg.Done() // Basically it have internally counter and .Done() called decrement operation occurred
		}()

		go func() {
			time.Sleep(time.Second * 10)
			n--
			wg.Done()
		}()
	}
	wg.Wait()

	fmt.Println("Final value of n is ", n)
}
