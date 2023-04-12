package uz.pdp.apppcmarket1.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Keyboard;

@Projection(types = Keyboard.class)
public interface CustomKeyboard {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getPrimarySetColor();

    String getAdditionalSetColor();

    String getKeyBoardKeys();

    boolean getBackLight();

    String getKeyMechanism();

    String getConnectionInterface();
}
