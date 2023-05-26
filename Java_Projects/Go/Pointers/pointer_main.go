package main

import (
	"fmt"
	"strings"
)

func main1() {

	name := "Harsh"

	fmt.Println(name)

	ptr := &name

	fmt.Printf("ptr is type of %T and holds value %v\n", ptr, ptr)

	fmt.Printf("address of name variable is %p\n", &name)

	var ptr1 *float64
	fmt.Printf("ptr 1 is type of %T and holds value %v\n", ptr1, ptr1)

	p := new(int)
	fmt.Printf("p 1 is type of %T and holds value %v\n", p, p)

	x := p

	fmt.Println(*x)
	*x = 100
	fmt.Println("Value of *x = ", *x)
	fmt.Println("Value of *p = ", *p)

	y := *p
	fmt.Println(y)
	y = 300
	fmt.Println(y)
	fmt.Println(*p)

	ptr2 := new(int)
	ptr22 := &ptr2
	//ptr22 := &ptr22 //this is invalid!

	fmt.Println(">>>>>>>", **ptr22)
	fmt.Println(">>>>>>>", *ptr22)

	**ptr22 = 100
	fmt.Println(">>>>>>>", **ptr22)
	fmt.Println(">>>>>>>", *ptr22)

	fmt.Printf("%s\n", strings.Repeat("*", 20))

	fmt.Println(">>>>>>>Address of ptr22", &ptr22)
	fmt.Println(">>>>>>>Value of ptr22", ptr22)
	fmt.Println(">>>>>>>Address of ptr2", &ptr2)
	fmt.Println(">>>>>>>Value of ptr2", ptr2)
}
