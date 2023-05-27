package main

import "fmt"

func main() {
	var numbers [4]int

	fmt.Printf("%T\n %v\n %#v\n", numbers, numbers, numbers)

	var a1 [4]float64

	fmt.Printf("%#v\n", a1)

	_ = a1

	a2 := [...]int{10, 20, 30, 40, 50} //this is called ellipsis operator
	// the ellipsis operator (...) finds out automatically the length of the array

	fmt.Printf("%#v\n", a2)

	a3 := [...]string{
		"Harsh",
		"Sankalp",
		"Anshu",
		"Manas",
		"Pavan", //this is compulsory
	}

	fmt.Printf("%#v\n", a3)

}
