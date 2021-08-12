package com.example.countryCRUD.service;

import com.example.countryCRUD.exception.UserNotFoundException;
import com.example.countryCRUD.model.Country;
import com.example.countryCRUD.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    public int updateCountry(Country country, Long id) {
        String countryName = country.getName();
        return countryRepository.updateById(countryName,id);
    }

    public int deleteCountry(Long id){
        return countryRepository.deleteCountryById(id);
    }
}
