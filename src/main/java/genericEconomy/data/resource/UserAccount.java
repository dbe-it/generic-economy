package genericEconomy.data.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 30)
    @NotNull
    private String name;

    private long moneyBalance = 0;

    public String getName() {
        return name;
    }

    public long getMoneyBalance() {
        return moneyBalance;
    }
}
