package main

import "fmt"

// Go converts switch statements into if statements behind the scenes automatically.

// The purpose of a switch statement is to make very long if statements more readable.

// Constant case labels cannot be duplicated but dynamic or conditional case statements duplicate are allowed

func main() {

	language := "Python"

	const constant = "HARSH"

	switch language {

	case "Python": //values must be comparable (compare string_basics to string_basics)
		fmt.Println("You are learning Python! You don't use { } but indentation !! ")
		// an implicit break is added here
	case "Go", "golang": //compare language with "Go" OR "golang"
		fmt.Println("Good, Go for Go!. You are using {}!")
	case constant:
		fmt.Println("You are in constant")

	default:
		// the default clause the equivalent of the else clause of an if statement
		// and gets executed if no testing condition is true.
		fmt.Println("Any other programming language is a good start!")
	}

	n := 5
	// comparing the result of an expression which is bool to another bool value
	switch true {
	case n%2 == 0:
		fmt.Println("Even!")
	case n%2 != 0:
		fmt.Println("Odd!")
	default:
		fmt.Println("Never here!")
	}

	//** Switch simple statement **//

	/**
	Syntax: statement (n:=10), semicolon and a switch condition
	(true in this case, we are comparing boolean expressions that return true)
	we can remove the word "true" because it's the default
	*/

	switch n := -10; true {
	case n > 0:
		fmt.Println("Positive")
	case n < 0:
		fmt.Println("Negative")
	default:
		fmt.Println("Zero")
	}

	java := "java"

	switch java {
	case "java":
		fallthrough
	case "Java":
		fmt.Println("Ignored Case!")
	}
}
