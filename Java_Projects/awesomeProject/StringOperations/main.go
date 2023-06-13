package main

import (
	"fmt"
	"strings"
)

func main() {

	// declaring a variable of type func to call the Println function easier.
	print := fmt.Println

	// it returns true whether a substr is within a string
	result := strings.Contains("I love Go Programming !", "love")

	print(result) // true

	// it returns true whether any Unicode code points are within our string, and false otherwise.
	result = strings.ContainsAny("success", "ss")
	print(result) // => true

	// it reports whether a rune is within a string.
	result = strings.ContainsRune("Harsh", 'h')

	print("Rune : ", result) // => true

	n := strings.Count("harsh", "h")
	// it returns the number of instances of a substring in a string

	print("Count : ", n)

	// if the substr is an empty string Count() returns 1 + the number of runes in the string
	n = strings.Count("harsh", "")

	print(n) // => 1+count() 5 =====> 6

	// ToUpper() and ToLower() return a new string with all the letters
	// of the original string converted to uppercase or lowercase.
	print(strings.ToLower("Go Python Java")) // -> go python java

	print(strings.ToUpper("Go Python Java")) // -> GO PYTHON JAVA

	// comparing strings (case matters)
	print("go" == "go") // true
	print("GO" == "Go") //false

	// comparing strings (case doesn't matter) -> it is not efficient
	print(strings.ToLower("Go") == strings.ToUpper("go")) //false

	// EqualFold() compares strings (case doesn't matter) -> it's efficient
	print(strings.EqualFold("Go", "gO")) // -> true

	// it returns a new string consisting of n copies of the string that is passed as the first argument
	myStr := strings.Repeat("ab", 10)
	print(myStr) // => abababababababababab

	// it returns a copy of a string by replacing a substring (old) by another substring (new)
	myStr1 := strings.Replace("10.20.40.199", ".", ":", 2) // replace only two occurances

	print(myStr1)

	// if the last argument is -1 it replaces all occurrences of old by new
	myStr = strings.Replace("192.168.0.1", ".", ":", -1)
	print(myStr) // -> 192:168:0:1

	// ReplaceAll() returns a copy of the string s with all non-overlapping instances of old replaced by new.
	myStr = strings.ReplaceAll("192.168.0.1", ".", ":")
	print(myStr) // -> 192:168:0:1

	//it slices a string into all substrings separated by separator and returns a slice of the substrings between those separators.
	s := strings.Split("h,a,r,s,h", ",")

	fmt.Printf("%T\n", s)

	fmt.Printf("\nstrings.Split() result : %#v\n", s) // => strings.Split():[]string{"a", "b", "c"}

	// if the seperator is empty Split function splits aftereach UTF 8 rune literal
	s = strings.Split("Go for GO !", "")

	fmt.Printf("Result of empty seperator : %#v\n", s) // -> []string{"G", "o", " ", "f", "o", "r", " ", "G", "o", "!"}

	// Join() concatenates the elements of a slice of strings to create a single string.
	// The separator string is placed between elements in the resulting string.
	s = []string{"I", "learn", "Golang"}
	j := strings.Join(s, " ")
	fmt.Printf("%T\n", j) // -> string
	print(j)              // -> I learn Golang

	// splitting a string by whitespaces and newlines.
	myStr = "Orange Green \n Blue Yellow"
	fields := strings.Fields(myStr) // it returns a slice of strings
	fmt.Printf("%T\n", fields)      // -> []string
	fmt.Printf("%#v\n", fields)     // -> []string{"Orange", "Green", "Blue", "Yellow"}

	// TrimSpace() removes leading and trailing whitespaces and tabs.
	s1 := strings.TrimSpace("\t Goodbye Windows, Welcome Linux!\n ")
	fmt.Printf("%s\n", s1) // "Goodbye Windows, Welcome Linux!"

	// To remove other leading and trailing characters, use Trim()
	s2 := strings.Trim("...Hello, Gophers!!!?", ".!?")
	fmt.Printf("%q\n", s2) // "Hello, Gophers

}
