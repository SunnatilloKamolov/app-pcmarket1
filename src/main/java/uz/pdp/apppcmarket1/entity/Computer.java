package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Computer extends AbsEntity {
    private String motherBoard;

    private String cpu;

    private boolean collingSystem;

    private String ram;

    private String ssd;

    private String powerSupply;

    private String frame;

    private String operationSystem;
}
