package main

import (
	"fmt"
)

type User struct {
	Name  string
	Email string
}

func (user User) String() string {
	return fmt.Sprintf("%s <%s>", user.Name, user.Email)
}

func main() {

	u := User{
		Name:  "Harsh",
		Email: "harshmehta010102@gmail.com",
	}

	fmt.Println(u)

}
