package com.example.countryCRUD.repo;

import com.example.countryCRUD.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    void deleteCountryById(Long id);

    Optional<Country> findCountryById(Long id);
}
