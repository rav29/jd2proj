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
@Table(name = "group_walls")
@ToString
@NoArgsConstructor
public class GroupWall extends BaseEntity {

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Setter
    @Getter
    @OneToMany(mappedBy = "sender")
    private Set<Message> messages;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @Getter
    @Setter
    @OneToMany(mappedBy = "group")
    private Set<Achievement> achievements;

}
