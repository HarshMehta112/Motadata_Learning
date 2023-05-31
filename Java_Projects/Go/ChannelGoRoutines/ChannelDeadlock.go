package main

func main() {

	channel := make(chan int, 2)

	channel <- 3

	channel <- 4

	channel <- 8

}
