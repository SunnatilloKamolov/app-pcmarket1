package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Laptop extends AbsEntity {
    private String screenResolution;

    private String cpu;

    private String ram;

    private String hardDisk;

    private String ssd;

    private String operationSystem;
}
