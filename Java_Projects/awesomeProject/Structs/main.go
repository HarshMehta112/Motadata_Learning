package main

import "fmt"

type employee struct {
	firstname string
	lastname  string
	age       int
}

func main() {

	emp1 := employee{firstname: "Harsh", lastname: "Mehta", age: 21}

	emp2 := employee{"Sankalp", "Singh", 221}

	fmt.Println("Employee 2", emp2.age)

	fmt.Printf("%+v\n", emp1)

	fmt.Println("Employee 1", emp1.lastname)
}
