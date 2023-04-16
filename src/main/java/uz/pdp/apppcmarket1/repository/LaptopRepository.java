package uz.pdp.apppcmarket1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket1.entity.Laptop;
import uz.pdp.apppcmarket1.projection.CustomLaptop;

@RepositoryRestResource(path = "laptop",collectionResourceRel = "list",excerptProjection = CustomLaptop.class)
public interface LaptopRepository extends JpaRepository<Laptop,Integer> {
    @RestResource(path = "byName")
    Page<Laptop> findAllByName(@Param("name") String name, Pageable pageable);
    boolean existsByName(String name);
}
