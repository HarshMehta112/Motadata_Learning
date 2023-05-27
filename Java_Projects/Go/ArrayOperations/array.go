package main

import (
	"fmt"
	"strings"
)

func main() {
	numbers := [3]int{10, 20, 30}

	_ = numbers

	fmt.Printf("%#v\n", numbers)

	numbers[2] = 60

	fmt.Printf("%#v\n", numbers)

	//range is just a language keyword not a function
	for index, value := range numbers {
		fmt.Println(index, value)
	}

	fmt.Println(strings.Repeat("#", 10))

	for i := 0; i < len(numbers); i++ {
		fmt.Println(i, numbers[i])
	}

}
