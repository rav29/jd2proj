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
@Table(name = "tasks")
@ToString
@NoArgsConstructor
public class Task extends BaseEntity {

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @Getter
    @Setter
    @Column(name = "task")
    private String task;

    @Getter
    @Setter
    @Column(name = "begin_date")
    private LocalDateTime taskBegins;

    @Getter
    @Setter
    @Column(name = "end_date")
    private LocalDateTime taskEnds;

}
