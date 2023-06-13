package main

import "fmt"

func main() {
	val := make([]interface{}, 10)

	for index := 0; index < len(val); index++ {
		//val[index] += val[index]
	}
	fmt.Println(val)
}
