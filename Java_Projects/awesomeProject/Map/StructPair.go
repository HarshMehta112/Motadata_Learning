package main

import (
	"bufio"
	"fmt"
	"os"
)

type pair struct {
	key string
	val int
}

func main() {
	words := make(map[string]int)
	scanner := bufio.NewScanner(os.Stdin)
	//scan words and not entire line
	scanner.Split(bufio.ScanWords)
	for scanner.Scan() {
		words[scanner.Text()]++
	}
	fmt.Println(words)

	var mapPairs []pair

	for key, vlaue := range words {
		mapPairs = append(mapPairs, pair{key: key, val: vlaue})
	}
	fmt.Println("Array of pairs: ", mapPairs)

}
