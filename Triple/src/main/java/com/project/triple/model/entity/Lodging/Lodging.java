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
    private String companyNum;
    private String lodgingType;
    private String companyName;
    private String introducing;
    private String country;
    private String city;
    private String address;
    private String contactHp;
    private String representative;
    private String email;
    private Integer likeCount;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lodging")
//    private List<LodgingRoom> lodgingRoomList;
}
