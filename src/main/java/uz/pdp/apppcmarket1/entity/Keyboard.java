package uz.pdp.apppcmarket1.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.apppcmarket1.entity.template.AbsEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Keyboard extends AbsEntity {
    private String brand;

    private String primarySetColor;

    private String additionalSetColor;

    private String keyBoardKeys;

    private boolean backLight;

    private String keyMechanism;

    private String connectionInterface;

}
