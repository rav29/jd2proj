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
@Table(name = "user_walls")
@ToString
@NoArgsConstructor
public class UserWall extends BaseEntity {

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private Set<Achievement> achievements;

    @Getter
    @Setter
    @OneToMany(mappedBy = "sender")
    private Set<Message> messages;

    @Getter
    @Setter
    @OneToMany(mappedBy = "members")
    private Set<Group> groups;

}
