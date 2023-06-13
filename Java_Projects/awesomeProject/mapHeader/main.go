package main

import "fmt"

func main() {

	//when declaring a map variable go creates a map header in the memory
	//the map references this internal data structure, the map header
	//the map contains only the address of map header the key value paris of the map are not directly stored into the map
	//they are stored in the memory address referenced by the map header

	//so when you copy a map to a new map internal data structure is not copied, just referenced.

	friends := map[string]string{
		"Name": "Harsh",
		"Age":  "21",
	}

	_ = friends

	fmt.Printf("%s", friends)

	friends2 := friends

	_ = friends2

	friends2["Name"] = "HarshKumar"

	fmt.Println("\nfriends map : ", friends)

	fmt.Println("friends2 map : ", friends2)

	newMapTest := make(map[string]string)

	for key, value := range friends {
		newMapTest[key] = value
	}

	fmt.Println(newMapTest)

	newMapTest["Name"] = "Sankalp"

	fmt.Println(newMapTest)
	fmt.Println(friends)
	fmt.Println(friends2)
}
