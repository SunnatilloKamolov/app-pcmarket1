package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Printer extends AbsEntity {
    private String brand;

    private String printColor;

    private String deviceFeatures;

    private String technology;

    private String maxFormat;

    private String twoSpeedPrinting;
}
