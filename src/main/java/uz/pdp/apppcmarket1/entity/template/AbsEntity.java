package uz.pdp.apppcmarket1.entity.template;

import jakarta.persistence.*;
import lombok.Data;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.entity.Category;

@MappedSuperclass
@Data

public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment attachment;
    private  double price;
    private Integer guarantee;
    private String description;
}
