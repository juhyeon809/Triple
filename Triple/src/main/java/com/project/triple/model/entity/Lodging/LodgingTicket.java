package com.project.triple.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_lodging_ticket",
        sequenceName = "seq_lodging_ticket",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LodgingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lodging_ticket")
    private Long id;
    private String ticketType;
    private String ticketNum;
    private String roomNum;
    @CreatedDate
    private LocalDateTime regDate;
}
