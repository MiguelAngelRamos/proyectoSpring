package cl.awakelab.bootcamp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cl.awakelab.bootcamp.entitys.Student;
import cl.awakelab.bootcamp.services.IStudentService;

@Controller
public class StudentController {
  
  private final IStudentService service;
  
  @Autowired
  public StudentController(IStudentService service) {
    this.service = service;
  }
  
  // locahost:8080/students
  @GetMapping({"/students", "/"})
  public String getAllStudents(Model model) {
    model.addAttribute("students", service.listAllStudents());
    return "students";
  }
 
  @GetMapping("/students/new")
  public String createStudentForm(Model model) {
    
    Student student = new Student();
    model.addAttribute("student", student);
    return "create-student"; // create-student.html
  }
  
  @PostMapping("/students")
  public String saveStudent(@ModelAttribute("student") Student student) {
    service.saveStudent(student);
    return "redirect:/students";
  }
  
  // students/edit/1
  @GetMapping("/students/edit/{id}")
  public String showFormEditStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
    Optional<Student> optionalStudent = service.getStudentById(id); 
    
    if(!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("No se encontro un estudiante con ese id: " + id);
    } 
    
    Student studentExists = optionalStudent.get(); // obtengo al estudiante por su id
    model.addAttribute("student", studentExists);
    return "edit-student";
  }
  
  
  @PostMapping("/students/{id}")
  public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
    Optional<Student> optionalStudent = service.getStudentById(id); 
    
    if(!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("No se encontro un estudiante con ese id: " + id);
    } 
    
    Student studentExists = optionalStudent.get(); // obtengo al estudiante por su id
    
    // Construimos al estudiante con los nuevos datos
    studentExists.setId(id);
    studentExists.setName(student.getName());
    studentExists.setLastname(student.getLastname());
    studentExists.setEmail(student.getEmail());
    
    service.updateStudent(studentExists);
    return "redirect:/students";
  }

}

class StudentNotFoundException extends RuntimeException {
  public StudentNotFoundException(String message) {
    super(message);
  }
}