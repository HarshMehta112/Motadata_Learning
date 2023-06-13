package main

import (
	"MotadataPugins/Discovery"
	"MotadataPugins/Polling"
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

			_ = bytes

			//fmt.Println(string(bytes))

		}

	}()

	encoded := os.Args[1]

	var errorList []string

	jsonStr, err := base64.StdEncoding.DecodeString(encoded)

	if err != nil {

		errorList = append(errorList, err.Error())

	}

	var batchData []map[string]interface{}

	err = json.Unmarshal([]byte(jsonStr), &batchData)

	if err != nil {

		errorList = append(errorList, err.Error())

	}

	if len(errorList) == 0 {

		if batchData[0]["type"] == "ssh" || batchData[0]["TYPE"] == "ssh" {

			if batchData[0]["category"] == "discovery" {

				var answer = SSHDiscovery.Discovery(batchData[0])

				bytes, _ := json.Marshal(answer)

				fmt.Println(string(bytes))

			} else if batchData[0]["category"] == "polling" {

				var answer []map[string]interface{}

				for index, _ := range batchData {

					var resultTemp = Polling.PollingSSH(batchData[index])

					answer = append(answer, resultTemp)
				}

				bytes, _ := json.Marshal(answer)

				fmt.Println(string(bytes))

			} else {

				result := make(map[string]interface{})

				result["error"] = "Invalid category"

				bytes, _ := json.Marshal(result)

				fmt.Println(string(bytes))
			}
		} else {

			var result = make(map[string]interface{})

			result["status"] = "fail"

			result["error"] = err.Error()

		}
	}

}
