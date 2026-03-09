package studentplatform.student_platform.Sservice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import studentplatform.student_platform.model.Student;
import studentplatform.student_platform.repo.repo;

@Service
public class Sservice {
	@Autowired 
	repo repoin;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	emailservice es;
	
	private static final Logger log =
            LoggerFactory.getLogger(Sservice.class);
	
	
	
	public void add(Student s)
	{
		    s.setPass(passwordEncoder.encode(s.getPass()));
		  
		

		repoin.save(s);
		es.sendstudent(s);
		log.info("Adding student: {}", s.getName());
		  
	}
public void delete(long id)
{
	    
	     repoin.deleteById(id);
}

public void modify(long id,String email)
{
	Optional<Student> s=repoin.findById(id);
	if(s.isPresent())
	{
		Student ss=s.get();
		
		ss.setEmail(email);
		repoin.save(ss);
		}


}
public void deleteStudent(long id)
{
    repoin.deleteById(id);
}
public Page<Student> pge(String name,int startpage,int endpage,String[] sort)
{
	String sf=sort[0];
	String sd=sort[1];
	Sort.Direction dire = sd.equalsIgnoreCase("Desc")?Sort.Direction.DESC:Sort.Direction.ASC;
	Pageable page = PageRequest.of(startpage, endpage,Sort.by(dire,sf));
	return repoin.findByName(name,page);
	
}
	
	
	
	
	
	
	
}