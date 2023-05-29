package main

import "fmt"

func f1(x ...int) {
	fmt.Printf("%T_________%#v\n", x, x)
}

func f2(y ...int) {
	y[0] = 100
}

func f3(x int, y ...int) (sum int) {
	sum = x

	for _, y := range y {
		sum += y
	}
	return
}

func main() {
	f1(1, 2, 3, 4, 5)

	var s1 []int = []int{1, 2, 3}
	s1 = append(s1, 5, 6, 7, 8) //example of built in variadic function.

	f1(s1...) //we can directly pass slice like this

	f2(s1...)

	fmt.Printf("%T_________%#v\n", s1, s1)

	fmt.Printf("%d", f3(4, 5, 67, 89))
}
