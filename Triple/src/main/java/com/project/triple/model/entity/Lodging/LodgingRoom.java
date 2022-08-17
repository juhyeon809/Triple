package com.project.triple.model.entity.Lodging;

import com.project.triple.model.enumclass.LodgingRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_lodging_room",
        sequenceName = "seq_lodging_room",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LodgingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lodging_room")
    private Long idx;
    private Long companyId;
    private String name;
    private String roomNum;
    private String uploadPath;
    private String fileName;
    private String roomCapacity;
    private String smoking;
    private String roomView;
    private String width;
    private String bed;
    private String introducing;
    private Integer price;
    private Integer likeCount;
    @Enumerated(EnumType.STRING)
    private LodgingRoomStatus status;

//    @ManyToOne
//    private Lodging lodging;
}
