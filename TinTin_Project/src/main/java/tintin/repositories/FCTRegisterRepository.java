package tintin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;
@Repository
public interface FCTRegisterRepository extends JpaRepository<FCTRegister, Long>{
	public List<FCTRegister> findByAssociatedStudent(Student student);
	
	public FCTRegister findOneByAssociatedDate(Dates date);
	
	public List<FCTRegister> findAllByAssociatedStudent(Long idstudent);
	
	public List<FCTRegister> findAllByNotAssociatedStudent(Long idstudent);
	
	public List<FCTRegister> findAllByAssociatedDate(List<Dates> dates);
}
