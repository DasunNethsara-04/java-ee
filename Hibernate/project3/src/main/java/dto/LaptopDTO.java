package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDTO {
    private int id;
    private String brand;
    private String processor;
    private String ram;
    private String storage;
    private String os;
    private String price;
}
