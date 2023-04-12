package uz.pdp.apppcmarket1.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.apppcmarket1.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {
    Integer getId();

    String getName();

    Category getCategory();
}
