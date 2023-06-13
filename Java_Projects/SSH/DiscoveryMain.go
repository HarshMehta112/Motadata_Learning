package main

import (
	"SSH/HarshSSH"
)

func main() {
	datas := map[string]interface{}{}

	datas["username"] = "harsh"

	datas["password"] = "code@112"

	datas["port"] = 22

	datas["ip"] = "10.20.40.199"

	HarshSSH.Discovery(datas)

}
