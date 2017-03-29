package genericEconomy.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import genericEconomy.data.location.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {

    @Query("SELECT s FROM Sector s JOIN FETCH s.modules WHERE s.id = (:id)")
    public Sector findByIdAndFetchModulesEagerly(@Param("id") Long id);
}
