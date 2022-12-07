package com.flight.controller.staticfiltering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StaticFilteringController {

    @GetMapping("/somebean")
    public SomeBean getSomeBean() {
        return new SomeBean("this", "is", "faisal");
    }

    @GetMapping("/somebeanv2")
    public SomeBeanV2 getSomeBeanv2() {
        return new SomeBeanV2("this", "is", "faisal");
    }

    @GetMapping("/somebeanlist")
    public List<SomeBean> getSomeBeanList() {
        return List.of(new SomeBean("this", "is", "faisal"), new SomeBean("This", "is", "Ankit"));
    }

}

@JsonIgnoreProperties("value2")
record SomeBean(String value1, String value2, String value3) {
}

record SomeBeanV2(String value1, @JsonIgnore String value2, String value3) {
}
