package main

import (
	"SSH/HarshSSH"
	"encoding/base64"
	"encoding/json"
	"fmt"
	"os"
)

func main() {

	defer func() {

		if r := recover(); r != nil {

			res := make(map[string]interface{})

			res["error"] = fmt.Sprint(r)

			bytes, _ := json.Marshal(res)

			fmt.Println(string(bytes))

		}

	}()

	encoded := os.Args[1]

	var errorList []string

	jsonStr, err := base64.StdEncoding.DecodeString(encoded)

	if err != nil {

		errorList = append(errorList, err.Error())

	}

	var data []map[string]interface{}

	err = json.Unmarshal([]byte(jsonStr), &data)

	fmt.Println(data)

	if err != nil {

		errorList = append(errorList, err.Error())

	}

	var resultarray []map[string]interface{}

	resultarray = append(resultarray, HarshSSH.MemoryData(data[0]), HarshSSH.MemoryData(data[1]))

}
