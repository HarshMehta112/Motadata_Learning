package main

import (
	"fmt"
	"net/http"
	_ "net/http/pprof"
	"time"
)

func ageValidation() {
	var age int

	//fmt.Println("Enter your age")
	//
	//fmt.Scanf("%d", &age)
	//
	//fmt.Println(age)

	time.Sleep(time.Second * 30)

	if age > 18 {
		fmt.Println("You are eligible for voting")
	} else {
		fmt.Println("You are not eligible for voting")
	}
}

func main() {
	ageValidation()
	go func() {
		fmt.Println(http.ListenAndServe("localhost:6000", nil))
	}()
}
