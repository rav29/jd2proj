package by.itacad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


/**
 * Created by Radion on 13.06.2017.
 */
@Entity
@Table(name = "achievements")
@NoArgsConstructor
@ToString
public class Achievement extends BaseEntity {

    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private User mentor;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
