package ro.sda.java30.finalproject.config.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instructors {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer phoneNumber;
    private String experience;
    private String description;
    private String languages;
    private String photo;

}
