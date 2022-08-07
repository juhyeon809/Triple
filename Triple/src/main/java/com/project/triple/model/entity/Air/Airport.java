package com.project.triple.model.entity.Air;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name="seq_airport",
        sequenceName = "seq_airport",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_airport")
    private Long idx;
    private String airportName;
    private String country;
    private String city;

}
