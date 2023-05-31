package main

import (
	"fmt"
	"runtime"
)

func main() {

	fmt.Println("main execution started ")

	fmt.Println("No of CPU core in PC : ", runtime.NumCPU())

	fmt.Println("No of GoRoutines running : ", runtime.NumGoroutine())

	fmt.Println("OS : ", runtime.GOOS)

	fmt.Println("Arch : ", runtime.GOARCH)

	fmt.Println("GOMAXPROCS : ", runtime.GOMAXPROCS(0))
}
