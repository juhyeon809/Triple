package com.project.triple.model.entity.Air;

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
        name="seq_airline",
        sequenceName = "seq_airline",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_airline")
    private Long idx;
    private String krName;
    private String enName;
    private String route;
    private String repNum;
    private String supportNum;
    private String uploadPath;
    private String fileName;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")
//    private List<Aircraft> aircraftList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airline")
//    private List<AirTicket> airTicketList;

}
