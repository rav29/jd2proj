package by.itacad.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 * Created by Radion on 18.06.2017.
 */
@Entity
@Table(name = "group_messages")
@PrimaryKeyJoinColumn(name = "message_id")
public class GroupMessage extends Message {

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
