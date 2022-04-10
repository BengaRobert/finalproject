package ro.sda.java30.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InstructorDto {
    private Long id;
    private String name;
    private Integer phoneNumber;
    private String experience;
    private String certifications;
    private String description;
    private String languages;
    private String photo;
}
