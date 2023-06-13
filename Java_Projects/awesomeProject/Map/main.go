package main

import "fmt"

func main() {
	// declaring a map with keys of type string and values of type string

	var employee map[string]string
	//the zero value of a map is nil

	fmt.Printf("%#v", employee)

	fmt.Printf("\nNo. of elements: %d\n", len(employee)) // => No. of elements: 0

	// getting the corresponding value of a key
	// if the key doesn't exist or the map is not initialized it returns the zero value for the value type
	fmt.Printf("The value for key %q is %q \n", "Dan", employee["Dan"]) // => The value for key "Dan" i

	// key must be of comparable types
	// var m1 map[[]int]string // error -> invalid map key type []int (slices are not comparable)

	// inserting a key:value pair in a nil map
	// employees["Dan"] = "Programmer" // error -> panic: assignment to entry in nil map

	// declaring and initializing a map using a map literal
	people := map[string]float64{} // empty map

	// inserting key:value pairs in a map
	people["harsh"] = 10.2
	people["Nikunj"] = 31.2

	fmt.Printf("%v\n", people)

	//declaring and initializing he map using map literal

	map1 := make(map[string]int)

	fmt.Printf("%#v\n", map1)

	map1["harsh"] = 21
	map1["mehta"] = 100

	fmt.Printf("%#v", map1)

	// declaring and initializing a map using a map literal
	balances := map[string]interface{}{
		"USD": 233.11,
		"EUR": 555.11,
		//50: "ABC"  //illegal, all keys have the same type which is string and all values have the same type which is float64
		"CHF": 600, //this last comma (,) is mandatory when declaring the map on multiple lines
	}
	fmt.Println("CHbbbbbbbbbbbbbbbbbbbbbbbbbbbbbF", balances["CHFh"]) // => map[CHF:600 EUR:555.11 USD:233.11]

	//If we declare and initialize a map on a single line, it's not mandatory to use a comma after the last element
	m := map[int]int{1: 3, 4: 5, 6: 8}
	_ = m

	// initializing a map with duplicate keys
	// n := map[int]int{1: 3, 4: 5, 6: 8, 1: 4} // error -> duplicate key 1 in map literal

	// if the key exists it updates its value and if the key doesn't exist it adds the key: value pair
	balances["USD"] = 500.5
	balances["GBP"] = 800.8
	fmt.Println(balances) // => map[CHF:600 EUR:555.11 GBP:800.8 USD:500.5]

	value, ok := balances["RON"]

	/*
		go gets default value if key
		is not present in map, so we can't be
		sure if key was present or not
		To deal with this, go provides
		another lookup function which returns key value
		and bool value, where bool indicating
		whether key was present or not
	*/

	if ok {
		fmt.Println("The RON Balance is: ", value)
	} else {
		fmt.Println("The RON key doesn't exist in the map!")
	}

	// iterating over a map
	for k, v := range balances {
		fmt.Printf("Key: %#v, Value: %#v\n", k, v)
	}

	delete(balances, "USD")

	fmt.Println("-------------After deleting of key---------------")

	for k, v := range balances {
		fmt.Printf("Key: %#v, Value: %#v\n", k, v)
	}

	// COMPARING MAPS

	// Maps cannot be compared using == operator. A map can be compared only to nil.
	a := map[string]string{"A": "X"}
	b := map[string]string{"B": "X"}

	// fmt.Println(a == b) // error -> invalid operation: a == b (map can only be compared to nil)

	// to compare 2 maps that have the keys and values of type string
	// we get a string representation of the maps and compare those strings.

	// getting a string representation of maps called a and b
	s1 := fmt.Sprintf("%s", a)
	s2 := fmt.Sprintf("%s", b)

	if s1 == s2 {
		fmt.Println("Maps are equal")
	} else {
		fmt.Println("Maps are not equal")
	}

	// CLONING THE MAP

	// When creating a map variable Go creates a pointer to a map header value in memory.
	// The key: value pairs of the map are not stored directly into the map.
	// They are stored in memory at the address referenced by the map header.

	friends := map[string]int{"Dan": 40, "Maria": 35}

	// neighbors is not a copy of friends.
	// both maps reference the same data structure in memory
	neighbors := friends

	// modifying friends AND neighbors
	friends["Dan"] = 30

	fmt.Println(neighbors) // -> map[Dan:30 Maria:35]

	// How to clone a map?
	// 1. initialize a new map
	colleagues := make(map[string]int)

	// colleagues = friends // -> ERROR, illegal with maps!

	// 2. use a for loop to copy each element into the new map
	for k, v := range friends {
		colleagues[k] = v
	}

	// Normally we have use third party package called reflect.deepcopy()
	// colleagues and friends are different maps in memory!

}
