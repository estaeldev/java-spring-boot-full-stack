package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SayHelloController {

    @GetMapping("say-hello")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello! What are you learning today?");
    }

    @GetMapping("say-hello-html")
    public ResponseEntity<?> sayHelloHtml() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title> My first HTML page </title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("My first html page with body");
        stringBuffer.append("</body>");
        stringBuffer.append("</html>");

        return ResponseEntity.status(HttpStatus.OK).body(stringBuffer.toString());
    }

    @GetMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
    
}
