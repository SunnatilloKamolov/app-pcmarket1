package uz.pdp.apppcmarket1.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.MonoBlock;

@Projection(types = MonoBlock.class)
public interface CustomMonoBlock {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getVideoCard();

    double getDiagonalScreen();

    String getScreenResolution();

    String getCpu();

    String getRam();

    String getHardDisk();

    String getSsd();

    String getOperationSystem();
}
