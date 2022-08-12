package com.project.triple.repository;

import com.project.triple.model.entity.Package;
import com.project.triple.model.entity.User.Users;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {

    List<Package> findAllByCountry(String country);

    List<Package> findAllByKeyword(String keyword);

    List<Package> findAllByCountryOrCountry(String country1, String country2);
    List<Package> findAllByOrderByIdxDesc();
}
