package main

import "fmt"

type contact struct {
	mobile string
	email  string
}

type Employee struct {
	name        string
	age         int
	contactInfo contact
}

//** EMBEDDED STRUCTS **//
// An embedded struct is just a struct that acts like a field inside another struct.

func main() {

	empInfo := Employee{
		name: "Harsh Mehta",
		age:  21,
		contactInfo: contact{
			mobile: "8866573033",
			email:  "harshmehta010102@gmail.com"}}

	_ = empInfo

	fmt.Printf("%s\n", empInfo.contactInfo.mobile)

	fmt.Printf("%+v\n", empInfo)

}
