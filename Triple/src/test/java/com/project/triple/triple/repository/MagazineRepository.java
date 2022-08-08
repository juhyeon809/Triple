package com.project.triple.triple.repository;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.enumclass.MagazineType;
import com.project.triple.triple.TripleApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MagazineRepository extends TripleApplicationTests {

    @Autowired
    private com.project.triple.repository.MagazineRepository magazineRepository;

//    @Test
//    public void create(){
//        Magazine magazine = Magazine.builder().adminuserId(3).adminuserName("반하나").magazineNum(3456).magazineType(MagazineType.RECOMMEND)
//                .title("안녕하세요").content("반하나의 매거진").uploadPath(null).fileName(null).fileType(null).build() ;
//        Magazine newMagazine = magazineRepository.save(magazine);
//    }
}
