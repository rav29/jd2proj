package by.itacad.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Radion on 18.06.2017.
 */
@Embeddable
@NoArgsConstructor
@ToString
public class Region {
    @Getter
    @Setter
    @Column(name = "country")
    private String country;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;
}
