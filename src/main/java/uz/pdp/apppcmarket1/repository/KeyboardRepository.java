package uz.pdp.apppcmarket1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket1.entity.Keyboard;
import uz.pdp.apppcmarket1.projection.CustomKeyboard;

@RepositoryRestResource(path = "keyboard",collectionResourceRel = "list",excerptProjection = CustomKeyboard.class)
public interface KeyboardRepository extends JpaRepository<Keyboard,Integer> {
    @RestResource(path = "byName")
    Page<Keyboard> findAllByName(@Param("name") String name, Pageable pageable);
}
