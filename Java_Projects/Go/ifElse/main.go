package main

import (
	"fmt"
)

func ageValidation() {
	var age int

	fmt.Println("Enter your age")

	fmt.Scanf("%d", &age)

	fmt.Println(age)

	if age > 18 {
		fmt.Println("You are eligible for voting")
	} else {
		fmt.Println("You are not eligible for voting")
	}
}

func main() {
	ageValidation()
}
