package HarshSSH

import (
	"encoding/json"
	"fmt"
	"golang.org/x/crypto/ssh"
	"strings"
	"time"
)

func MemoryData(data map[string]interface{}) map[string]interface{} {
	const cmd = "free -m | awk 'NR==2 {print ($2 \" \" $3 \" \" $4 \" \"$7)}' && free -m | grep \"Mem\" | awk '{print $3/$2*100}'"

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

	commandOutput, _ := session.CombinedOutput(cmd)

	result := make(map[string]interface{})

	final := make(map[string]map[string]interface{})

	output := string(commandOutput)

	system := strings.Split(output, "\n")

	res := strings.Split(system[0], " ")

	result["memory.total.megabytes"] = res[0]

	result["memory.used.megabytes"] = res[1]

	result["system.free.megabytes"] = res[2]

	result["system.available.megabytes"] = res[3]

	result["memory.used.percentage"] = system[1]

	fmt.Println("Final Res", result)

	final[sshHost] = result

	bytes, err := json.Marshal(final)

	if err != nil {

		response := make(map[string]interface{})

		response["error"] = err.Error()

	} else {

		fmt.Println(string(bytes))

	}

	return result

}
