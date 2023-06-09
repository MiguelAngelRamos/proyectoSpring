package cl.awakelab.bootcamp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
  
  // localhost:8080/students
  // localhost:8080 => http://localhost:8080/
  @GetMapping({"/students", "/"})
  public String getAllStudents() {
    return "students";
  }

}
