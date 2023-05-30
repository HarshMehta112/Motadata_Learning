package main

import "fmt"

type car struct {
	brand string
	price int
}

// declaring a method for car type
// it changes the value it works on
func (c car) changeFunc(newBrand string, newPrice int) {
	c.brand = newBrand
	c.price = newPrice
}

func (c *car) changeFuncPointer(newBrand string, newPrice int) {
	c.brand = newBrand
	c.price = newPrice
}

func main() {

	//declaring car value
	myCar := car{"BMW", 10}

	fmt.Println(myCar)

	// calling the method with a value receiver
	myCar.changeFunc("AUDI", 20)

	// no change due to the same pass by value mechanism  !!!
	fmt.Println("Result of without pointer funtion ", myCar)

	(myCar).changeFuncPointer("AUDI", 40)

	//value changed bcz it is passed by reference !!!
	fmt.Println("Result after with pointer function", myCar)

}
