package genericEconomy.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import genericEconomy.data.resource.UserAccount;


@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {


}
