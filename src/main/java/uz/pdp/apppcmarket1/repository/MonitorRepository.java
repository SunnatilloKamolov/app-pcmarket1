package uz.pdp.apppcmarket1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.apppcmarket1.entity.Monitor;
import uz.pdp.apppcmarket1.projection.CustomMonitor;

@RepositoryRestResource(path = "monitor",collectionResourceRel = "list",excerptProjection = CustomMonitor.class)
public interface MonitorRepository extends JpaRepository<Monitor,Integer> {
    @RestResource(path = "byName")
    Page<Monitor> findAllByName(@Param("name") String name, Pageable pageable);

}
