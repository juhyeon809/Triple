package com.project.triple.model.entity.Lodging;

import com.project.triple.model.enumclass.LodgingRoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
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
    private Long id;
    private String roomNum;
    private String roomType;
    @Enumerated(EnumType.STRING)
    private LodgingRoomStatus revStatus;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private String width;
    private Integer roomCapacity;
    private String roomPolicy;
    private Integer price;
    private Integer lodgingId;

}
