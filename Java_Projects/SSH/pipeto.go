package main

import (
	"bytes"
	"fmt"
	"golang.org/x/crypto/ssh"
	"log"
	// Uncomment to store output in variable
	//"bytes"
)

func main() {

	username := "sankalp"
	password := "Geek@003"
	hostname := "10.20.40.24"
	port := "22"

	// SSH client config
	config := &ssh.ClientConfig{
		User: username,
		Auth: []ssh.AuthMethod{
			ssh.Password(password),
		},
		// Non-production only
		HostKeyCallback: ssh.InsecureIgnoreHostKey(),
	}

	// Connect to host
	client, err := ssh.Dial("tcp", hostname+":"+port, config)
	if err != nil {
		log.Fatal(err)
	}
	defer client.Close()

	// Create sesssion
	sess, err := client.NewSession()
	if err != nil {
		log.Fatal("Failed to create session: ", err)
	}
	defer sess.Close()

	// StdinPipe for commands
	stdin, err := sess.StdinPipe()
	if err != nil {
		log.Fatal(err)
	}

	// Uncomment to store output in variable
	var b bytes.Buffer
	sess.Stdout = &b
	sess.Stderr = &b

	// Enable system stdout
	// Comment these if you uncomment to store in variable
	//sess.Stdout = os.Stdout
	//sess.Stderr = os.Stderr

	// Start remote shell
	err = sess.Shell()
	if err != nil {
		log.Fatal(err)
	}

	// send the commands
	commands := []string{
		"free -m",
		"uname -a",
		"hostname is now",
		"echo 'bye'",
		"exit",
	}
	for _, cmd := range commands {
		_, err = fmt.Fprintf(stdin, "%s\n", cmd)
		if err != nil {
			log.Fatal(err)
		}
	}

	// Wait for sess to finish
	err = sess.Wait()
	if err != nil {
		log.Fatal(err)
	}

	//out := strings.Split(b.String(), "")

	// Uncomment to store in variable
	fmt.Println("Output ", b.String())

}
