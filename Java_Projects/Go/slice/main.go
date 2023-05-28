package main

import "fmt"

func main() {
	var cities []string

	fmt.Println(cities == nil)

	fmt.Printf("%#v", cities)

	fmt.Printf("\n%d", len(cities))

	nums := make([]int, 1)
	nums = append(nums, 11, 12, 31, 14, 15)

	fmt.Println("------------------------------------------------")

	for _, value := range nums {
		fmt.Println(value)
	}

	fmt.Printf("\nnums = %#v", nums)

}
