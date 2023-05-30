package main

import (
	"fmt"
	"strings"
)

type Friends []string

type myInt int

func (m myInt) increment() myInt {
	m += 1
	return m
}

func (f Friends) getFriends() {
	for key, value := range f {
		fmt.Println(key, value)
	}
}

func main() {

	myFri := Friends{"HarshKumar", "Sankalp", "Anshu", "Tiwari"}

	myFri.getFriends()

	fmt.Println(strings.Repeat("*", 20))

	Friends.getFriends(myFri)

	var x myInt = 100
	a := x.increment()

	fmt.Println(a)
}
