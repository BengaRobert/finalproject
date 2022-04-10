package ro.sda.java30.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipmentDto {
    private Long id;
    private String category;
    private String name;
    private Integer price;
    private String level;
    private Integer size;
    private String description;
}
