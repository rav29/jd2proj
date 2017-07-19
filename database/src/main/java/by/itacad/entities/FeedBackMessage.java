package by.itacad.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Radion on 18.06.2017.
 */
@Entity
@Table(name = "fb_messages")
@PrimaryKeyJoinColumn(name = "message_id")
public class FeedBackMessage extends Message {

    @Getter
    @Setter
    @Column(name = "mark")
    private int mark;
}

