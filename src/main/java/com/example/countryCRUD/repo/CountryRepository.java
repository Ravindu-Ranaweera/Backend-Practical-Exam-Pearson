package com.example.countryCRUD.repo;

import com.example.countryCRUD.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Country a WHERE a.id=:id")
    int deleteCountryById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Country a SET a.name =:countryName WHERE a.id = :id ")
    int updateById(@Param("countryName") String countryName, @Param("id") Long id);

    Optional<Country> findCountryById(Long id);



}
