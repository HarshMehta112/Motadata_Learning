package main

//
//import (
//	"fmt"
//	"os/exec"
//	"strings"
//)
//
//func main() {
//	// Get the IP addresses from the user
//	Data := []string{"10.20.40.199", "10.20.40.24", "10.20.40.156"}
//
//	args := append([]string{"-c3", "-q", "-t1000"}, Data...)
//
//	// Execute the fping command
//	cmd := exec.Command("fping", args...)
//	stdout, err := cmd.CombinedOutput()
//	if err != nil {
//		fmt.Println(err)
//		return
//	}
//
//	// Print the output of the fping command
//	fmt.Println(string(stdout))
//
//	value := strings.Split(string(stdout), "\n")
//
//	for i := 0; i < len(value); i++ {
//		fmt.Println(value)
//		splitebycolun := strings.Split(value[i], ":")
//		fmt.Println(splitebycolun[1])
//		if(spl)
//		splitebyequal := strings.Split(splitebycolun[1], "=")
//		fmt.Println(splitebyequal)
//		//splitebyslash := strings.Split()
//	}
//
//}
