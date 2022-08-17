package com.project.triple.model.entity.Lodging;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_lodging",
        sequenceName = "seq_lodging",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_lodging")
    private Long idx;
    private String type;
    private String country;
    private String city;
    private Integer rank;
    private String name;
    private String uploadPath;
    private String fileName;
    private String info;
    private String introducing;
    private String address;
    private String checkIn;
    private String checkOut;
    private String policy;
    private String cf;
    private String moreInfo;
    private Integer reviewCount;
    private Integer totalStar;
    private Double starCount;
    private Integer cheapestPrice;


}
