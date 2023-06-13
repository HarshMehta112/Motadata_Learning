package main

import "fmt"

func main() {

	var n []int

	fmt.Printf("%#v\n", n)

	var m []int

	fmt.Printf("%#v\n", m)

	//fmt.Println(m == n)  // gives error slice only compared to nil

	// to compare the slice we have to iterate over the both slices

	a, b := []int{1, 2, 3}, []int{1, 2, 3}

	_, _ = a, b

	var equal bool

	if len(a) == len(b) {
		equal = true
		for index, value := range a {
			if value != b[index] {
				equal = false
				break
			}
		}
	}

	if equal {
		fmt.Println("Slice are equal")
	} else {
		fmt.Println("Slice are not equal")
	}

}
