package main

import "fmt"

type friends struct {
	string
	int
}

func main() {

	f1 := friends{"Sankalp", 31}

	_ = f1

	fmt.Printf("%+v", f1)

}
