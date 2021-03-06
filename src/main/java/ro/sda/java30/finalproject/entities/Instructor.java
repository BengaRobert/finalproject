package ro.sda.java30.finalproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instructor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer phoneNumber;
    private String experience;
    private String certifications;
    private String description;
    private String languages;
    @Lob
    private byte[] photo;

}
