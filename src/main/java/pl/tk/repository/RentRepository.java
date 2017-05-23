package pl.tk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tk.model.Rent;

/**
 * Created by Tobiasz on 2017-05-22.
 */

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
