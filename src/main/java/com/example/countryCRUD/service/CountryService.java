package com.example.countryCRUD.service;

import com.example.countryCRUD.exception.UserNotFoundException;
import com.example.countryCRUD.model.Country;
import com.example.countryCRUD.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addCountry(Country country){
        return  countryRepository.save(country);
    }

    public List<Country> findAllCountry(){
        return countryRepository.findAll();
    }

    public Country findCountryById(Long id){
        return countryRepository.findCountryById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
    }

    public Country updateCountry(Country country){
        return countryRepository.save(country);
    }

    public void deleteCountry(Long id){
        countryRepository.deleteCountryById(id);
    }
}
