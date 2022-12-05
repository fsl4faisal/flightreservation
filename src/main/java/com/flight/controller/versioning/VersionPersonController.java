package com.flight.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionPersonController {

    //path_param

    @GetMapping("/person/v1")
    public PersonV1 getPersonV1PathParam() {
        return new PersonV1("faisal");
    }

    @GetMapping("/person/v2")
    public PersonV2 getPersonV2PathParam() {
        return new PersonV2(new Name("md", "faisal"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonV1RequestParam() {
        return new PersonV1("faisal");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2RequestParam() {
        return new PersonV2(new Name("md", "faisal"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header() {
        return new PersonV1("faisal");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Name("md", "faisal"));
    }

    @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonV1MediaVersion() {
        return new PersonV1("faisal");
    }

    @GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonV2MediaVersion() {
        return new PersonV2(new Name("md", "faisal"));
    }


}


record PersonV1(String name) {
}

record PersonV2(Name name) {
}

record Name(String firstName, String lastName) {
}