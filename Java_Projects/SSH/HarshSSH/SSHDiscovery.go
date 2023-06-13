package HarshSSH

import (
	"fmt"
	"golang.org/x/crypto/ssh"
	"strings"
	"time"
)

func discovery(data map[string]interface{}) map[string]interface{} {

	defer func() {
		if r := recover(); r != nil {

			res := make(map[string]interface{})

			res["status"] = "fail"

			res["error"] = r

			errorDisplay(res)

		}
	}()

	sshHost := (data["ip"]).(string)

	sshPassword := (data["password"]).(string)

	sshUser := (data["username"]).(string)

	config := &ssh.ClientConfig{

		Timeout: 5 * time.Second,

		User: sshUser,

		HostKeyCallback: ssh.InsecureIgnoreHostKey(),

		Config: ssh.Config{Ciphers: []string{

			"aes128-ctr", "aes192-ctr", "aes256-ctr",
		}},
	}

	var result = make(map[string]interface{})

	config.Auth = []ssh.AuthMethod{ssh.Password(sshPassword)}

	addr := fmt.Sprintf("%s:%v", sshHost, 22)

	sshClient, clientErr := ssh.Dial("tcp", addr, config)

	if clientErr != nil {

		result["status"] = "fail"

		result["error"] = clientErr.Error()

		return result

	}

	defer sshClient.Close()

	session, err := sshClient.NewSession()

	if err != nil {

		result["status"] = "fail"

		result["error"] = clientErr.Error()

		return result

	}

	res, err := session.CombinedOutput("hostname") // available

	if err != nil {

		result["status"] = "fail"

		result["error"] = clientErr.Error()

		return result

	}

	ans := string(res)

	result["hostname"] = strings.Trim(ans, "\n")

	result["status"] = "success"

	//fmt.Println(result)

	return result

}
