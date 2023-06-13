package main

import (
	"bytes"
	"golang.org/x/crypto/ssh"
	"log"
)

func executeCmd(cmd []string, hostname string, config *ssh.ClientConfig) string {
	conn, err := ssh.Dial("tcp", hostname+":8022", config)

	if err != nil {
		log.Fatal(err)
	}
	defer conn.Close()

	var stdoutBuf bytes.Buffer

	for _, command := range cmd {

		session, err := conn.NewSession()

		if err != nil {
			log.Fatal(err)
		}
		defer session.Close()

		session.Stdout = &stdoutBuf
		session.Run(command)
	}

	return hostname + ": " + stdoutBuf.String()
}

func main() {

}

//
//import (
//	"encoding/json"
//	"fmt"
//	"golang.org/x/crypto/ssh"
//	"strings"
//	"time"
//)
//
//func errorDisplay(res map[string]interface{}) {
//
//	bytes, _ := json.Marshal(res)
//
//	fmt.Println(string(bytes))
//
//}
//
//func CPUData(data map[string]interface{}) {
//
//	const cmdForCPU = "mpstat |awk  '{if ($4 != \"CPU\") print $5 \" \" $7 \" \" $8 \" \" $14}'"
//
//	const cmdForMemory = "free -m | awk 'NR==2 {print ($2 \" \" $3 \" \" $4 \" \"$7)}' && free -m | grep \"Mem\" | awk '{print $3/$2*100}'"
//
//	const cmdForUptime = "uptime -a"
//
//	const cmdForDisk = "df . -m | awk 'NR==2 {print ($5)}'"
//
//	defer func() {
//
//		if r := recover(); r != nil {
//
//			res := make(map[string]interface{})
//
//			res["error"] = r
//
//			errorDisplay(res)
//
//		}
//	}()
//
//	sshUser := (data["username"]).(string)
//
//	sshPassword := (data["password"]).(string)
//
//	sshHost := (data["ip"]).(string)
//
//	config := &ssh.ClientConfig{
//
//		Timeout: 10 * time.Second,
//
//		User: sshUser,
//
//		HostKeyCallback: ssh.InsecureIgnoreHostKey(),
//
//		Config: ssh.Config{Ciphers: []string{
//
//			"aes128-ctr", "aes192-ctr", "aes256-ctr",
//		}},
//	}
//
//	config.Auth = []ssh.AuthMethod{ssh.Password(sshPassword)}
//
//	address := fmt.Sprintf("%s:%d", sshHost, 22)
//
//	sshClient, err := ssh.Dial("tcp", address, config)
//
//	var errorList []string
//
//	if err != nil {
//
//		errorList = append(errorList, err.Error())
//	}
//
//	defer sshClient.Close()
//
//	session, err := sshClient.NewSession()
//
//	if err != nil {
//
//		errorList = append(errorList, err.Error())
//	}
//
//	/*Command Output Manuplation for CPU Data*/
//
//	commandOutputCpu, _ := session.CombinedOutput(cmdForCPU)
//
//	result := make(map[string]interface{})
//
//	output := string(commandOutputCpu)
//
//	res := strings.Split(output, "\n")
//
//	system := strings.Split(res[2], " ")
//
//	result["system.cpu.user.percent"] = system[0]
//
//	result["system.cpu.system.percent"] = system[1]
//
//	result["system.cpu.io.percent"] = system[2]
//
//	result["system.cpu.idle.percent"] = system[3]
//
//	/*CPU Data Ended*/
//
//	/*Memory Data Output*/
//
//	commandOutputMem, _ := session.CombinedOutput(cmdForMemory)
//
//	output1 := string(commandOutputMem)
//
//	system1 := strings.Split(output1, "\n")
//
//	res1 := strings.Split(system1[0], " ")
//
//	result["memory.total.megabytes"] = res1[0]
//
//	result["memory.used.megabytes"] = res1[1]
//
//	result["system.free.megabytes"] = res1[2]
//
//	result["system.available.megabytes"] = res1[3]
//
//	result["memory.used.percentage"] = system1[1]
//
//	/*Memory Ended*/
//
//	/*Uptime data gathering*/
//
//	commandOutputUptime, _ := session.CombinedOutput(cmdForUptime)
//
//	result["system.uptime"] = string(commandOutputUptime)
//
//	/*Uptime Ended*/
//
//	/*Disk Data gathering*/
//
//	commandOutputDisk, _ := session.CombinedOutput(cmdForDisk)
//
//	result["system.used.disk.percentage"] = string(commandOutputDisk)
//
//	fmt.Println(result)
//
//	/*Disk Ended*/
//
//	bytes, err := json.Marshal(result)
//
//	if err != nil {
//
//		response := make(map[string]interface{})
//
//		response["error"] = err.Error()
//
//		errorDisplay(response)
//
//	} else {
//
//		fmt.Println(string(bytes))
//
//	}
//}
