// Empty Interface is a Core Concept in Go
// Any Go type satisfies the empty interface and that means it can represent any value.
// An empty interface may hold values of any type.

package main

import (
	"fmt"
	"reflect"
)

// declaring a empty interface
type emptyInterface interface {
}

// declaring a new struct type which has one field of type empty interface
type person struct {
	info interface{}
}

//func snaklp(i interface{}) {
//	fmt.Println(len(i.([]int)))
//}

func main() {
	var empty interface{}

	// an empty interface may hold values of any type
	// storing an int in the empty interface
	empty = 5

	//snaklp(empty)

	v := empty.(int)

	fmt.Println(v)

	v++

	fmt.Println(reflect.ValueOf(empty).Kind().String())

	fmt.Println(empty) // => 5

	// storing a string in the empty interface
	empty = "Go"
	fmt.Println(empty) // => Go

	// storing a slice in the empty interface
	empty = []int{2, 34, 4}
	fmt.Println(empty) // => [2 34 4]

	// fmt.Println(len(empty)) -> error, and it doesn't work!

	// retrieving the dynamic value using an assertion
	fmt.Println(len(empty.([]int))) // => 3

	// declaring person value
	you := person{}

	// assigning any value to empty interface field
	you.info = "You name"
	you.info = 40
	you.info = []float64{4.5, 6., 8.1}

	fmt.Println(you.info)
}
