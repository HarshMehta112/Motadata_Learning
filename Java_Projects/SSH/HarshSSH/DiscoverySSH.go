package HarshSSH

import (
	"encoding/json"
	"fmt"
	"golang.org/x/crypto/ssh"
	"time"
)

func Discovery(data map[string]interface{}) {

	const command = "hostname"

	defer func() {

		if r := recover(); r != nil {

			res := make(map[string]interface{})

			res["error"] = r

			errorDisplay(res)

		}
	}()

	sshUser := (data["username"]).(string)

	sshPassword := (data["password"]).(string)

	sshHost := (data["ip"]).(string)

	config := &ssh.ClientConfig{

		Timeout: 10 * time.Second,

		User: sshUser,

		HostKeyCallback: ssh.InsecureIgnoreHostKey(),

		Config: ssh.Config{Ciphers: []string{

			"aes128-ctr", "aes192-ctr", "aes256-ctr",
		}},
	}

	config.Auth = []ssh.AuthMethod{ssh.Password(sshPassword)}

	address := fmt.Sprintf("%s:%d", sshHost, 22)

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

	commandOutputCpu, _ := session.CombinedOutput(command)

	result := make(map[string]interface{})

	output := string(commandOutputCpu)

	if output == "" {
		result["status"] = "success"
	} else {
		result["status"] = "fail"
	}

	bytes, err := json.Marshal(result)

	if err != nil {

		response := make(map[string]interface{})

		response["error"] = err.Error()

		errorDisplay(response)

	} else {

		fmt.Println(string(bytes))

	}
}
