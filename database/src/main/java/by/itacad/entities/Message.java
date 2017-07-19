package by.itacad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;



/**
 * Created by Radion on 13.06.2017.
 */
@Entity
@Table(name = "messages")
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Message extends BaseEntity {

    @Getter
    @Setter
    @Column(name = "message")
    private String message;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User sender;

    @Getter
    @Setter
    @Column(name = "date")
    private LocalDateTime date;

}
