package com.project.triple.model.entity;

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
        name="seq_tour_ticket",
        sequenceName = "seq_tour_ticket",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class TourTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tour_ticket")
    private Long idx;
    private String ticketType;
    private String ticketNum;
    private String revName;
    private String revHp;
    private String revEmail;
    private String repreHp;
    private String repreLastname;
    private String repreFirstname;
    private String repreBirth;
    private String kakaoid;
    private String lodgingName;
    private String useLastname;
    private String useFirstname;
    @CreatedDate
    private LocalDateTime regDate;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tourTicket")
//    private List<Question> questionList;
}
