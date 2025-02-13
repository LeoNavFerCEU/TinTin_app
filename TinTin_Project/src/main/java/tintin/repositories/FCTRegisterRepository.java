package tintin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.FCTRegister;
@Repository
public interface FCTRegisterRepository extends JpaRepository<FCTRegister, Long>{

}
