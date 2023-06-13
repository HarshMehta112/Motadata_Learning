package main

import (
	"fmt"
	"unicode/utf8"
)

func main() {
	// characters or rune literals are expressed in Go by enclosing them in single quotes
	// declaring a variable of type rune (alias to int32)

	var1 := 'a'

	fmt.Printf("Type : %T\t Value : %d\n", var1, var1) //value is 97 and type = int32

	// declaring a string value that contains non-ascii characters
	str := "ţară" // ţară means country in Romanian
	// 't', 'a' ,'r' and 'a' are runes and each rune occupies beetween 1 and 4 bytes.

	fmt.Println(len(str)) //-> 6,  4 runes in the string but the length is 6

	//return the number of count of rune in the string

	m := utf8.RuneCountInString(str)

	fmt.Println("No of count of Rune ", m) // => 4

	// by using indexes we get the byte at that positioin, not rune.
	fmt.Println("Byte (not rune) at position 1:", str[1]) // -> 163

	//decoding the string byte by byte
	for i := 0; i < len(str); i++ {
		fmt.Printf("%c", str[i]) // =>Å£arÄ
	}

	//decoding the string rune by rune manually

	//for i := 0; i < len(str); i++ {
	//	r, size := utf8.DecodeRuneInString(str[i:]) //it returns the rune in string in variable r
	//
	//	//and its size in bytes in variable size
	//
	//	// printing out each rune
	//	fmt.Printf("%c", r) // -> ţară
	//	i += size           // incrementing i by the size of the rune in bytes
	//}

	// decoding a string rune by rune automatically:
	for i, r := range str { //the first value returned by range is the index of the byte in string where rune starts
		fmt.Printf("\n%d -> %c", i, r) // => ţară
	}

}
