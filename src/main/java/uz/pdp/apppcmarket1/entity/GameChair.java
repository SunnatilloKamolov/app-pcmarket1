package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class GameChair extends AbsEntity {
    private String color;

    private String forPeopleLength;

    private double load;

    private String gasLiftClass;

    private double weight;

    private String frameMaterial;

    private String size; //60x80x120

    private String movementType;
}
