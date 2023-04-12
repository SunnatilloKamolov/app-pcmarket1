package uz.pdp.apppcmarket1.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.entity.Printer;

@Projection(types = Printer.class)
public interface CustomPrinter {
    Integer getId();

    String getName();

    Category getCategory();

    Attachment getAttachment();

    double getPrice();

    Integer getGuarantee();

    String getDescription();

    String getBrand();

    String getPrintColor();

    String getDeviceFeatures();

    String getTechnology();

    String getMaxFormat();

    String getTwoSpeedPrinting();
}
