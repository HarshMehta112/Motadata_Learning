package HarshSSH

import (
	"encoding/json"
	"fmt"
	"golang.org/x/crypto/ssh"
	"strings"
	"time"
)

func errorDisplay(res map[string]interface{}) {

	bytes, _ := json.Marshal(res)

	fmt.Println(string(bytes))

}

func CPUData(data map[string]interface{}) {

	const cmdForCPU = "mpstat |awk  '{if ($4 != \"CPU\") print $5 \" \" $7 \" \" $8 \" \" $14}'"

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

	/*Command Output Manuplation for CPU Data*/

	commandOutputCpu, _ := session.CombinedOutput(cmdForCPU)

	result := make(map[string]interface{})

	output := string(commandOutputCpu)

	res := strings.Split(output, "\n")

	system := strings.Split(res[2], " ")

	result["system.cpu.user.percent"] = system[0]

	result["system.cpu.system.percent"] = system[1]

	result["system.cpu.io.percent"] = system[2]

	result["system.cpu.idle.percent"] = system[3]

	/*CPU Data Ended*/

	bytes, err := json.Marshal(result)

	if err != nil {

		response := make(map[string]interface{})

		response["error"] = err.Error()

		errorDisplay(response)

	} else {

		fmt.Println(string(bytes))

	}
}
