package tintin.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.Dates;

@Repository
public interface DateRepository extends JpaRepository<Dates, Long>{

}
