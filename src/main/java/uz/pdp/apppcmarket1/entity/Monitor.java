package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Monitor extends AbsEntity {
    private String brand;

    private String screenResolution;

    private String videoConnectors;

    private String matrix;

    private Double diagonalScreen;

    private boolean curvedScreen;

    private Integer screenRefreshRate;

    private String responseTime;
}
