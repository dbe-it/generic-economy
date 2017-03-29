package genericEconomy.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import genericEconomy.data.location.Biom;


@Repository
public interface BiomRepository extends JpaRepository<Biom, Long> {


    @Query("SELECT b FROM Biom b JOIN FETCH b.sectors WHERE b.id = (:id)")
    public Biom findByIdAndFetchSectorsEagerly(@Param("id") Long id);

    @Query("SELECT b FROM Biom b JOIN FETCH b.sectors")
    public Biom findAllAndFetchSectorsEagerly();
}
