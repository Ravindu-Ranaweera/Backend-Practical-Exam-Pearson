package com.example.countryCRUD;

import com.example.countryCRUD.model.Country;
import com.example.countryCRUD.repo.CountryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

@Configuration
public class StudentConfigaration {
    @Bean
    CommandLineRunner commandLineRunner(CountryRepository countryRepository){

        return args->{
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("json/countryList.json");
//
//            try {
//              List<Country> countryList = mapper.readValue(inputStream,typeReference);
//                countryRepository.saveAll(countryList);
//                System.out.println("Users Saved!");
//            } catch (IOException e){
//                System.out.println("Unable to save users: " + e.getMessage());
//            }

        };
    }
}
