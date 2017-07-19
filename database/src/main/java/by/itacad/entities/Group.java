package by.itacad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;



/**
 * Created by Radion on 13.06.2017.
 */
@Entity
@Table(name = "groups")
@ToString(exclude = {"members"})
@NoArgsConstructor
public class Group extends BaseEntity {


    @Setter
    @Getter
    @Column(name = "name", unique = true)
    private String name;

    @Setter
    @Getter
    @ManyToMany
    @JoinTable(name = "groups_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<User> members;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "group_status")
    private GroupStatus groupStatus;

    @Setter
    @Getter
    @Column(name = "max_members")
    private int maxNumberOfMembers;

    @Setter
    @Getter
    @Column(name = "number_of_tasks")
    private int NumberOfTasks;

    @Setter
    @Getter
    @Column(name = "current_task")
    private int currentTaskNumber;


}
