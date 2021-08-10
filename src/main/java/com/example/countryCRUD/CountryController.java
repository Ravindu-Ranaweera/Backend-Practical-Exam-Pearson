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
        System.out.println("gdgsgsd");
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

    @PutMapping ("/update")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country){
        Country updateCountry = countryService.updateCountry(country);
        return new ResponseEntity<>(updateCountry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }






}
