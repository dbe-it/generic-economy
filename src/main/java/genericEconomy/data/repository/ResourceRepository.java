package genericEconomy.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import genericEconomy.data.resource.Resource;


@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {


}
