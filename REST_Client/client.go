package main

import (
	"net/http"
	"log"
	"io"
	"os"
	"strings"
	"fmt"
)

func main() {
	resp, err := http.Get("http://localhost:8080/REST_Server_Web_exploded/dj")
	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()

	io.Copy(os.Stdout, resp.Body)

	fmt.Println()
	resp, err = http.Post("http://localhost:8080/REST_Server_Web_exploded/dj", "text/plain", strings.NewReader("Naz"))
	if err != nil {
		log.Fatal(err)
	}
	defer resp.Body.Close()

	io.Copy(os.Stdout, resp.Body)
}