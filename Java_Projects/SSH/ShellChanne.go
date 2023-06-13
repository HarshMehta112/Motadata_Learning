package main

//
//import (
//	"encoding/json"
//	"fmt"
//	"golang.org/x/crypto/ssh"
//	"strconv"
//	"strings"
//	"sync"
//	"time"
//)
//
//func SshPolling(credentials map[string]interface{}, wait *sync.WaitGroup) {
//
//	var errors []string
//
//	var commands []string
//
//	var resultArray []map[string]interface{}
//
//	if credentials["category"] == "polling" {
//
//		commands = append(commands, PollCommands...)
//
//	} else {
//
//		commands = append(commands, ProvisionCommands...)
//	}
//
//	result := make(map[string]interface{})
//
//	address, config := configMaker(credentials)
//
//	sshClient, eror := ssh.Dial("tcp", address, config)
//
//	if eror != nil {
//
//		errors = append(errors, eror.Error())
//
//	} else {
//
//		defer sshClient.Close()
//
//		for _, command := range commands {
//
//			session, eror := sshClient.NewSession()
//
//			if eror != nil {
//
//				errors = append(errors, eror.Error())
//			}
//			commandOut, eror := session.CombinedOutput(command)
//
//			if eror != nil {
//
//				errors = append(errors, eror.Error())
//			}
//			output := string(commandOut)
//
//			if len(output) == 0 {
//
//				errors = append(errors, "unable to gather hostname")
//
//			} else {
//
//				result[command[0:2]] = output
//			}
//
//			session.Close()
//
//		}
//
//		if credentials["category"] == "polling" {
//
//			disk := strings.Split(result["df"].(string), "%")
//
//			memory := strings.Split(result["fr"].(string), " ")
//
//			cpu := strings.Split(result["mp"].(string), " ")
//
//			idle, _ := strconv.Atoi(cpu[2])
//
//			diskused, _ := strconv.Atoi(disk[0])
//
//			currentTime := time.Now()
//
//			cpuUser := map[string]interface{}{
//
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "cpu.percent.user",
//				"value":      cpu[0],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			cpuSystem := map[string]interface{}{
//
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "cpu.percent.system",
//				"value":      cpu[1],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			cpuIdle := map[string]interface{}{
//
//				"ip":        credentials["ip"],
//				"type":      "ssh",
//				"metricTpe": "cpu.percent.idle",
//				"value":     cpu[2],
//				"timestamp": currentTime.Format("2023-01-02 03:04:05"),
//			}
//			cpuTotal := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "cpu.percent.total",
//				"value":      100 - idle,
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			memoryTotal := map[string]interface{}{
//
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "memory.bytes.total",
//				"value":      memory[0],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			memoryUsed := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "memory.percent.used",
//				"value":      memory[1],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			memoryFree := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "memory.percent.free",
//				"value":      memory[2],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			memoryAvailable := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "memory.percent.available",
//				"value":      memory[3],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			diskUsed := map[string]interface{}{
//
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "disk.percent.used",
//				"value":      diskused,
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			diskAvailable := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "disk.percent.available",
//				"value":      100 - diskused,
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//
//			resultArray = append(resultArray, cpuIdle, cpuSystem, cpuUser, cpuTotal, memoryTotal, memoryUsed, memoryAvailable, memoryFree, diskUsed, diskAvailable)
//
//		} else {
//
//			systemInfo := strings.Split(result["un"].(string), " ")
//			uptime := strings.Split(result["up"].(string), "up")
//
//			up := strings.Split(uptime[1], "\n")
//
//			currentTime := time.Now()
//
//			systemName := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "system.info.name",
//				"value":      systemInfo[1],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//
//			systemOsName := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "system.info.osName",
//				"value":      systemInfo[0],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			systemOsVersion := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "system.info.osVersion",
//				"value":      systemInfo[1],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//			systemUpTime := map[string]interface{}{
//				"ip":         credentials["ip"],
//				"type":       "ssh",
//				"metricType": "system.info.uptime",
//				"value":      up[0],
//				"timestamp":  currentTime.Format("2023-01-02 03:04:05"),
//			}
//
//			resultArray = append(resultArray, systemName, systemOsName, systemOsVersion, systemUpTime)
//
//		}
//	}
//
//	jsonstring, _ := json.Marshal(resultArray)
//
//	fmt.Println(string(jsonstring))
//
//	wait.Done()
//}
