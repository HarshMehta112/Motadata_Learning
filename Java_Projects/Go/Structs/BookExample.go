package main

import "fmt"

func main() {

	// creating a struct type
	type book struct {
		title  string //the fields of the book struct
		author string //each field must be unique inside a struct
		year   int
	}

	// declaring, initializing and assigning a new book value, all in one step
	lastBook := book{"The Divine Comedy", "Dante Aligheri", 1320} //this is a struct literal and order matters
	fmt.Println(lastBook)

	// Declaring a new book value by specifying field: value (order doesn't matter)
	bestBook := book{title: "Animal Farm", year: 1945, author: "George Orwell"}
	_ = bestBook

	//if we create a new struct value by omitting some fields they will be zero-valued according to their type
	aBook := book{title: "Just a random book"}
	fmt.Printf("%#v\n", aBook) // => main.book{title:"Just a random book", author:"", year:0}

	// retrieving the value of a struct field
	fmt.Println(lastBook.title) // => The Divine Comedy

	// selecting a field that doesn't exist raises an error
	// pages := lastBook.pages // error -> lastBook.pages undefined (type book has no field or method pages)

	// updating a field
	lastBook.author = "The Best"
	lastBook.year = 2020
	fmt.Printf("lastBook: %+v\n", lastBook) // => lastBook: {title:The Divine Comedy author:The Best year:2020}
	// + modifier with %+v  printed out both the field names and their values

	// comparing struct values
	// two struct values are equal if their corresponding fields are equal.
	randomBook := book{title: "Random Title", author: "John Doe", year: 100}
	fmt.Println(randomBook == lastBook) // => false

	// = creates a copy of a struct
	myBook := randomBook
	myBook.year = 2020              // modifying only myBook
	fmt.Println(myBook, randomBook) // => {Random Title John Doe 2020} {Random Title John Doe 100}

	myNewBook := &randomBook            //it will not create a new copy but it will pass the address of the existing struct
	myNewBook.year = 2020               // modifying only myBook
	fmt.Println(*myNewBook, randomBook) // => {Random Title John Doe 2020} {Random Title John Doe 2020}

	fmt.Printf("%T..............%T\n\n", myNewBook, myBook)

	myNewSpringBook := myNewBook
	myNewSpringBook.author = "Harsh"

	fmt.Printf("%T %p\n", myNewSpringBook, &myNewSpringBook.year)
	fmt.Printf("%T %p\n", myNewBook, &myNewBook.year)
	fmt.Printf("%T %p\n", randomBook, &randomBook.year)
	fmt.Printf("%T %p\n", myBook, &myBook.year)

	//(*myBook).title = "XYZ" //wrong syntax bcz myBook is struct not pointer
	(*myNewBook).title = "1023" //correct bcz myNewBook is pointer

	fmt.Println(myNewSpringBook)
	fmt.Println(myNewBook, randomBook, myBook)
}
