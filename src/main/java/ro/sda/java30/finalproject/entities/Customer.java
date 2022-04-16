package ro.sda.java30.finalproject.entities;

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
public class Customer{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private Integer phoneNumber;

}
