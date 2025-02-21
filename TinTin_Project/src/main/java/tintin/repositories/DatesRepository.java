package tintin.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.Dates;

@Repository
public interface DatesRepository extends JpaRepository<Dates, LocalDate>{
	public List<Dates> findAllByDateBetween(LocalDate since, LocalDate till);
}
