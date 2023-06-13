package main

import "fmt"

func main() {
	var ch chan int
	//this is nil channel so send and receive operations on this channel will always blocks.

	//ch := make(chan int)  this is recommended !
	go func() {
		fmt.Println(<-ch)
	}()

	ch <- 10
}
