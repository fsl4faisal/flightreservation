package com.flight.controller.staticfiltering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DynamicFilteringController {

    @GetMapping("/somebean-dynamic-filtering") //Filtering Field2
    public MappingJacksonValue getSomeBean() {
        var bean = new SomeBeanWithDynamicFiltering("This", "is", "faisal");
        var mappingJacksonValue = new MappingJacksonValue(bean);
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("beanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


    @GetMapping("/somebeanlist-dynamic-filtering")
    public MappingJacksonValue getSomeBeanList() {
        var list = List.of(new SomeBeanWithDynamicFiltering("this ", "is", "faisal"), new SomeBeanWithDynamicFiltering("This", "is", "Ankit"));
        var mappingJacksonValue = new MappingJacksonValue(list);
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2");

        var filters = new SimpleFilterProvider().addFilter("beanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}

@JsonFilter("beanFilter")
record SomeBeanWithDynamicFiltering(String value1, String value2, String value3) {
}
