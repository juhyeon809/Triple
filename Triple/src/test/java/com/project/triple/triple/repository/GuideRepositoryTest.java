package com.project.triple.triple.repository;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.enumclass.GuideType;
import com.project.triple.repository.GuideRepository;
import com.project.triple.triple.TripleApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class GuideRepositoryTest extends TripleApplicationTests {

    @Autowired
    private GuideRepository guideRepository;

//    @Test
//    public void create() {
//        Guide guide = Guide.builder().type(GuideType.AIRPORT).guideNum(1).adminuserId(Long.valueOf(3)).country("공항나라").city("공항도시").adminuserName("김사과").title("인천 국제공항 가는 길")
//                .content("여행의 시작은 집을 나서는 순간부터! 인천 국제공항 가는 방법").uploadPath(null).fileName(null)
//                .fileType(null).build();
//        guideRepository.save(guide);
//    }

}
