package main

import (
	"encoding/json"
	"fmt"
	"golang.org/x/crypto/ssh"
	"strings"
	"time"
)

func MemoryData(data map[string]interface{}) {
	const cmd = "free -m | awk 'NR==2 {print ($2 \" \" $3 \" \" $4 \" \"$7)}'"

	sshUser := (data["username"]).(string)

	sshPassword := (data["password"]).(string)

	sshHost := (data["ip"]).(string)

	sshPort := (data["port"]).(int)

	//fmt.Println(sshPort)

	config := &ssh.ClientConfig{

		Timeout: 10 * time.Second,

		User: sshUser,

		HostKeyCallback: ssh.InsecureIgnoreHostKey(),

		Config: ssh.Config{Ciphers: []string{

			"aes128-ctr", "aes192-ctr", "aes256-ctr",
		}},
	}

	config.Auth = []ssh.AuthMethod{ssh.Password(sshPassword)}

	address := fmt.Sprintf("%s:%d", sshHost, sshPort)

	sshClient, err := ssh.Dial("tcp", address, config)

	var errorList []string

	if err != nil {

		errorList = append(errorList, err.Error())
	}

	defer sshClient.Close()

	session, err := sshClient.NewSession()

	if err != nil {

		errorList = append(errorList, err.Error())
	}

	commandOutput, _ := session.CombinedOutput(cmd)

	result := make(map[string]interface{})

	output := string(commandOutput)

	//fmt.Println(output)

	system := strings.Split(output, " ")

	result["memory.total.megabytes"] = system[0]

	result["memory.used.megabytes"] = system[1]

	result["system.free.megabytes"] = system[2]

	result["system.available.megabytes"] = system[3]

	fmt.Println("Final Res", result)

	bytes, err := json.Marshal(result)

	if err != nil {

		response := make(map[string]interface{})

		response["error"] = err.Error()

	} else {

		fmt.Println(string(bytes))

	}

}

func main() {

	datas := map[string]interface{}{}

	datas["username"] = "harsh"

	datas["password"] = "code@112"

	datas["port"] = 22

	datas["ip"] = "10.20.40.199"

	MemoryData(datas)
	MemoryData(datas)
	MemoryData(datas)

}
