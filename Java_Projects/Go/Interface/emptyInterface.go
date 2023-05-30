package main

import "fmt"

func main() {
	s := map[string]any{}

	fmt.Println(s["HarshMehta"]) //<nil>
	s["HarshMehta"] = 40

	fmt.Println(s["HarshMehta"]) //40
	a := s["HarshMehta"]

	a = a.(int) + 10 //we must do type assertion inorder to perform any int specific operations or methods

	fmt.Printf("%T......%#v\n", s["HarshMehta"], s["HarshMehta"])
	fmt.Printf("%T......%#v\n", a, a)
}
