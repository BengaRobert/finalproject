package ro.sda.java30.finalproject.entities;


import javax.persistence.*;

@Entity
public class Languages{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String language;

}
