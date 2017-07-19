package by.itacad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Radion on 13.06.2017.
 */
@Entity
@Table(name = "diaries")
@ToString
@NoArgsConstructor
public class Diary extends BaseEntity {

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Setter
    @Getter
    @OneToMany(mappedBy = "group")
    private Set<Task> finishedTasks = new HashSet<>();

    @Setter
    @Getter
    @Column(name = "tasks_passed")
    private int tasksPassed;

    @Setter
    @Getter
    @Column(name = "tasks_to_finish")
    private int tasksToFinish;

}
