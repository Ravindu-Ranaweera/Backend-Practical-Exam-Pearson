package com.example.countryCRUD;

import com.example.countryCRUD.model.Country;
import com.example.countryCRUD.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class CountryController {

    private  final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountry (){
//        System.out.println("Success");
        List<Country> countries = countryService.findAllCountry();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Country> getCountryById (@PathVariable("id") Long id){
        Country country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<?> updateCountry(@RequestBody Country country, @PathVariable("id") Long id){
        System.out.println(id);
        Integer updateCountry = countryService.updateCountry(country, id);
        return new ResponseEntity<>(updateCountry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
        System.out.println("Success");
        Integer deleteCountry = countryService.deleteCountry(id);
        return new ResponseEntity<>(deleteCountry, HttpStatus.OK);
    }

}
