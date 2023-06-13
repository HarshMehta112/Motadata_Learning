package main

import "fmt"

type SmartPhone struct {
	brand, os    string
	model, price int
}

func main() {
	//var iPhone SmartPhone
	//
	//var iPhone = SmartPhone{}
	//
	//var iPhone = new(SmartPhone)

	iPhone := SmartPhone{brand: "Apple", os: "IOS", model: 11, price: 49_000}
	//fmt.Println(iPhone)
	fmt.Printf("%+v\n", iPhone) //it prints both field name and value

	iPhone12 := &SmartPhone{brand: "Apple", os: "IOS", model: 12}
	setPrice(iPhone12)
	//fmt.Println("test", iPhone12)
	fmt.Printf("%+v\n", iPhone12) //it prints both field name and value
}

func setPrice(obj *SmartPhone) {
	obj.price = 72_000
} //It's pass by reference bcz it expects the address of struct SmartPhone.

/*func setPrice(obj SmartPhone) {
	obj.price = 72_000
}
*/
/*this function will expect SmartPhone struct as a parameter so while calling the function we have to pass the
actual value using setPrice(*iPhone12) bcz iPhone12 holds is the address of the struct so we have to de-reference
that using "*" and any modification performed to this obj will not modify the actual value so it's kind of pass
by value! */
