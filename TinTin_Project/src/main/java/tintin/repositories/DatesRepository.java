package tintin.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, LocalDate>{

}
