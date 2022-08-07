package com.project.triple.model.entity.Lodging;


import com.project.triple.model.entity.QnA.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private String roomNum;
    private String revName;
    private String revHp;
    private String revEmail;
    private String useEngLastname;
    private String useEngFirstname;
    private String useBirth;
    private String useRequests;
    private String infoAgree;
    @CreatedDate
    private LocalDateTime regDate;
    private Long userId;
    private Long guestNum;
    private String transportation;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "lodgingTicket")
//    private List<Question> questionList;
}
