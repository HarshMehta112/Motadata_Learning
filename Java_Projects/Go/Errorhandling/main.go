package main

import (
	"fmt"
	"math"
)

/*The above program works well but wouldn't
it be nice if we print the actual radius which caused the error.
This is where the Errorf function of the fmt package comes in handy
*/

func circleArea(radius float64) (float64, error) {
	if radius < 0 {
		//return 0, errors.New("area calculation failed, radius is less than zero")
		return 0, fmt.Errorf("Failed due to radius %0.2f", radius)
	}
	return math.Pi * radius * radius, nil
}

func main() {
	radius := -20.0
	area, err := circleArea(radius)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Printf("Area of circle %0.2f", area)
}
