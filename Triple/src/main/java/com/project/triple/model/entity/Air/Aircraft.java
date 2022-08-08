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
        name="seq_aircraft",
        sequenceName = "seq_aircraft",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_aircraft")
    private Long idx;
    private String aircraftName;
    private String madeBy;
    private Integer aircraftCapacity;
    private Integer premiumSeat;
    private Integer firstSeat;
    private Integer businessSeat;
    private Integer economySeat;
    private String airlineName;

//    @ManyToOne
//    private Airline airline;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
//    private List<AirTicket> airTicketList;
}
