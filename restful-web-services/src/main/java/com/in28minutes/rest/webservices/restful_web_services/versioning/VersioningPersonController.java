package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class VersioningPersonController {
    
    @GetMapping("/v1/person")
    public ResponseEntity<PersonV1> getPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(new PersonV1("Bob Charlie"));
    }

    @GetMapping("/v2/person")
    public ResponseEntity<PersonV2> getPersonV2() {
        Name name = new Name("Bob", "Charlie");
        return ResponseEntity.status(HttpStatus.OK).body(new PersonV2(name));
    }
    
    @GetMapping(path = "/person")
    public ResponseEntity<?> getPersonParameter(@PathParam("version") String version) {

        if(version.equalsIgnoreCase("1")) {
            return ResponseEntity.status(HttpStatus.OK).body(new PersonV1("Bob Charlie"));
        }

        if(version.equalsIgnoreCase("2")) {
            return ResponseEntity.status(HttpStatus.OK).body(new PersonV2(new Name("Bob", "Charlie")));
            
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Version Is Not Exist!");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public ResponseEntity<?> getPersonVersion1Header() {
        PersonV1 person = new PersonV1("Bobs Charlie");
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public ResponseEntity<?> getPersonVersion2Header() {
        PersonV2 person = new PersonV2(new Name("Bobs", "charlie"));
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public ResponseEntity<?> getPersonVersion1AcceptHeader() {
        PersonV1 person = new PersonV1("bobs charlie");
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public ResponseEntity<?> getPersonVersion2AcceptHeader() {
        PersonV2 person = new PersonV2(new Name("bobs", "charlie"));
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }


}
