package com.flight.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/filterbycountry")
public class FilterByCountryController {

    @Autowired
    private RestTemplate restTemplate;

    private final String COUNTRY = """
            {
            "alpha_two_code": "US",
            "name": "Marywood University",
            "country": "United States",
            "web_pages": [
            "http://www.marywood.edu"
            ],
            "state-province": null,
            "domains": [
            "marywood.edu"
            ]
            }
            """;
    private final String COUNTRIES = """
            [
            {
            "alpha_two_code": "US",
            "name": "Marywood University",
            "country": "United States",
            "web_pages": [
            "http://www.marywood.edu"
            ],
            "state-province": null,
            "domains": [
            "marywood.edu"
            ]
            },
            {
            "alpha_two_code": "US",
            "name": "Lindenwood University",
            "country": "United States",
            "web_pages": [
            "http://www.lindenwood.edu/"
            ],
            "state-province": null,
            "domains": [
            "lindenwood.edu"
            ]
            }]
                        
            """;

    //Original
    @GetMapping
    public List<Country> getFilteredCountryInfo(@RequestParam String country) {
        var response = restTemplate.getForEntity("http://universities.hipolabs.com/search?country=" + country, Country[].class);

        List<Country> countries = Arrays.asList(response.getBody());
        System.out.println(countries);
        return countries;
    }

    @GetMapping("/country-filter")
    public Country getCountryFilter() {
        Country country = restTemplate.getForObject("http://localhost:8080/api/filterbycountry/country", Country.class);
        System.out.println(country);
        return country;
    }

    @GetMapping("/countries-filter")
    public List<Country> getCountriesFilter() {
        var response = restTemplate.getForEntity("http://localhost:8080/api/filterbycountry/countries", Country[].class);

        //List<Country> countries = response.getBody();
        System.out.println(response.getBody());
        return Arrays.asList(response.getBody());
    }

    @GetMapping("/countries")
    public String getList() {
        return COUNTRIES;
    }

    @GetMapping("/country")
    public String getCountry() {
        return COUNTRY;
    }
}

record CountryList(List<Country> countries) {

}

record Country(@JsonAlias("alpha_two_code") String alphaTwoCode,
               @JsonAlias("name") String name,
               @JsonAlias("country") String country,
               @JsonAlias("web_pages") List<String> webPages,
               @JsonAlias("state-province") String stateProvince,
               @JsonAlias("domains") List<String> domains) {
}
