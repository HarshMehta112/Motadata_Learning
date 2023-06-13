package main

import (
	"fmt"
)

type student interface {
	getRollNo() int
}

type faculty interface {
	getSalary() int
}

type collage interface {
	student
	faculty
	getName() string
}

func printInfo(c collage) {
	fmt.Println(c.getName(), c.getSalary(), c.getRollNo())
}

type studentinfo struct {
	name           string
	rollno, salary int
}

func (s studentinfo) getSalary() int {
	return s.salary
}

func (s studentinfo) getName() string {

	return s.name
}

func (s studentinfo) getRollNo() int {
	return s.rollno
}

func main() {
	myCol := studentinfo{
		name:   "Harsh",
		rollno: 83,
		salary: 211,
	}

	printInfo(myCol)
}
