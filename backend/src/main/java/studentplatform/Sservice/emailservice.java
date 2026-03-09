package studentplatform.student_platform.Sservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import studentplatform.student_platform.model.Student;

@Service
public class emailservice {

	@Autowired
	JavaMailSender js;			
	public void sendstudent(Student s)
	{
		  System.out.println("EMAIL METHOD TRIGGERED");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(s.getEmail());
		message.setSubject("welcome");
		message.setText("hello"+s);
		js.send(message);

                                        
	}
}