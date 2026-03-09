package studentplatform.student_platform.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentplatform.student_platform.Sservice.Sservice;
import studentplatform.student_platform.model.Student;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class Controller {
	
	private final Sservice s;
	
	Controller(Sservice s)
	{
		this.s=s;
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Student ss)
	{
		s.add(ss);
		return "sucess";
	}
   
    @PutMapping("/modify/{id}")
    public String modify(@PathVariable long id,
                         @RequestParam String email) {
        s.modify(id, email);
        return "Student email updated successfully";
    } 
   
	@GetMapping("/test")
	public String test()
	{
		return "hi";
	}
	@GetMapping("/get")
	public Page<Student> pa(@RequestParam  String name, @RequestParam(defaultValue="0") int sp, @RequestParam(defaultValue="5") int  ep, @RequestParam(defaultValue="name,asc") String[] sort)
	{
		return s.pge(name, sp, ep,sort);
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
	    s.deleteStudent(id);
	    return "Student Deleted";
	}

}
























