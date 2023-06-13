package main

func main() {

	//defer func() {
	//
	//	if r := recover(); r != nil {
	//
	//		res := make(map[string]interface{})
	//
	//		res["error"] = r
	//
	//		bytes, _ := json.Marshal(res)
	//
	//		fmt.Println(bytes)
	//
	//	}
	//
	//}()
	//
	//encoded := os.Args[1]
	//
	//var errorList []string
	//
	//jsonStr, err := base64.StdEncoding.DecodeString(encoded)
	//
	//if err != nil {
	//
	//	errorList = append(errorList, err.Error())
	//
	//}
	//
	//data := make(map[string]interface{})
	//
	//err = json.Unmarshal(jsonStr, &data)
	//
	//if err != nil {
	//
	//	errorList = append(errorList, err.Error())
	//
	//}
	//if len(errorList) == 0 {
	//
	//	if data["type"] == "linux" {
	//
	//		if data["category"] == "discovery" {
	//
	//			// Fire Discovery command or method
	//			//var ans = SSH.Discovery(data)
	//
	//			//bytes, _ := json.Marshal(ans)
	//
	//			//fmt.Println(string(bytes))
	//
	//		} else if data["category"] == "polling" {
	//
	//			// Fire All SSH commands
	//
	//			//SSH.Disk(data)
	//
	//		}
	//	} else {
	//
	//		res := make(map[string]interface{})
	//
	//		res["error"] = "Invalid type"
	//
	//		bytes, _ := json.Marshal(res)
	//
	//		fmt.Println(string(bytes))
	//
	//	} else {
	//
	//		var res = make(map[string]interface{})
	//
	//		res["status"] = "fail"
	//
	//		res["error"] = err.Error()
	//
	//	}
	//
	//}
}
