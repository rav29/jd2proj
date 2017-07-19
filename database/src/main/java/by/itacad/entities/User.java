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
@Table(name = "users")
@ToString
@NoArgsConstructor
public class User extends BaseEntity {

    @Setter
    @Getter
    @Column(name = "name", unique = true)
    private String name;

    @Setter
    @Getter
    @Column(name = "password")
    private String password;

    @Setter
    @Getter
    @Column(name = "email", unique = true)
    private String email;

    @Getter
    @Setter
    @Embedded
    private Region region;


    @Setter
    @Getter
    @ManyToMany(mappedBy = "members")
    private Set<Group> groups;

}
