package main

import "fmt"

func main() {

	x := 101
	y := 101

	ptr1 := &x
	ptr2 := &y
	ptr3 := &x

	fmt.Println(ptr2 == ptr1)
	fmt.Println(ptr3 == ptr1)

	fmt.Println(*ptr2 == *ptr1)
}
