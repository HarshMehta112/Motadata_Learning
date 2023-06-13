package main

import (
	"fmt"
	"math"
)

// declaring an interface type called shape
// an interface contains only the signatures of the methods, but not their implementation
type shape interface {
	area() float64
}

type rectangle struct {
	width, height float64
}

type circle struct {
	radius float64
}

func (c circle) area() float64 {
	return math.Pi * c.radius * c.radius
}

func (r rectangle) area() float64 {
	return r.height * r.width
}

func (r rectangle) whoAmI() {
	fmt.Println(" I am in whoAmI method")
}

// any type that implements the interface is also of type of the interface
// rectangle and circle values are also of type shape

func print(s shape) {
	fmt.Printf("Shape %#v\n", s)
	fmt.Printf("Area : %v\n", s.area())
}

func main() {

	c1 := circle{radius: 32.2}

	r1 := rectangle{height: 8.2, width: 9.98}

	print(c1)

	print(r1)

	//############ Using A Variable Type Of Interface ###############

	var s shape
	fmt.Printf("%T.....%#v\n", s, s) //<nil>.....<nil>

	//values can be thought of as a pair of concrete value and dynamic type
	s = circle{radius: 10.2}
	fmt.Printf("%T.....%#v\n", s, s) //main.circle.....main.circle{radius:10.2}
	print(s)

	s = rectangle{
		width:  10,
		height: 20,
	}
	fmt.Printf("%T.....%#v\n", s, s) //main.rectangle.....main.rectangle{width:10, height:20}
	print(s)

	s1 := r1
	fmt.Printf("%T.....%#v\n", s1, s1)
	s1.area()

	//############ Type Assertion ###############

	//s.whoAmI() // this will raise an error bcz whoAmI() is not defined in the interface so somehow we have to extract the dynamic value hold by that variable

	//s = c1
	//fmt.Println(s.(rectangle).whoAmI()) //this a valid way but what if the asserted type is not the actual type hold by that variable?
	//Can give panic interface conversion: main.shape is main.circle, not main.rectangle

	//This is recommended!
	s = c1
	rect, ok := s.(rectangle) //this is called the assertion
	if ok {
		rect.whoAmI()
	} else {
		fmt.Printf("Wrong Type Assertion\n")
	}

	//############ Type Switch ###############
	switch val := s.(type) {
	case circle:
		fmt.Printf("This is a type of circle\n")
		fmt.Println(val.area())
	case rectangle:
		fmt.Printf("This is a rectangle type of value")
		val.whoAmI()
		//case shape: what is the use if this particular thing???
	}

}
