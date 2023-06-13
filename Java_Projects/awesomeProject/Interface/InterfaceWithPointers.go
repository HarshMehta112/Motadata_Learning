package main

import (
	"fmt"
	"time"
)

type Integer interface {
	increment() harshInt
}

type harshInt int

func (c *harshInt) increment() harshInt {
	*c += 1
	return *c
}

func main() {
	cInt := harshInt(1)

	cInt.increment()
	fmt.Println(cInt)

	//newInt := Integer.increment(&cInt)
	//fmt.Println(newInt)
	//fmt.Println(cInt)

	time.Sleep(10_000 * time.Millisecond)
}
