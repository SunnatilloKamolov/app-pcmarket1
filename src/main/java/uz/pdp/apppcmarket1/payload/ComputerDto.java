package uz.pdp.apppcmarket1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {
    private String name;
    private Integer CategoryId;
    private String motherBoard;

    private String cpu;

    private boolean collingSystem;

    private String ram;

    private String ssd;

    private String powerSupply;

    private String frame;

    private String operationSystem;

}
