package studentplatform.student_platform.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentplatform.student_platform.model.Student;

@Repository
public interface repo extends JpaRepository<Student,Long> {
	Page<Student> findByName(String name,Pageable page);
	Student findByName(String name);

}
