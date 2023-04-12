package uz.pdp.apppcmarket1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.projection.CustomCategory;

@RepositoryRestResource(path = "category",collectionResourceRel = "list",excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @RestResource(path = "byName")
    Page<Category> findAllByName(@Param("name") String name, Pageable pageable);
}
