package tintin.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tintin.model.FCTRegister;
import tintin.model.Student;

@Repository
public interface FCTRegisterRepository extends JpaRepository<FCTRegister, Long> {
	public List<FCTRegister> findByAssociatedStudent(Student student);

	public FCTRegister findOneByAssociatedDate_Date(LocalDate date);

	public List<FCTRegister> findAllByAssociatedStudent_Id(Long idstudent);

}
