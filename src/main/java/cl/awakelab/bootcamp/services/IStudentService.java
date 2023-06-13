package cl.awakelab.bootcamp.services;

import java.util.List;
import java.util.Optional;

import cl.awakelab.bootcamp.entitys.Student;

public interface IStudentService {
  
  public List<Student> listAllStudents();
  public Student saveStudent(Student student);
  public Optional<Student> getStudentById(Long id);
  public Student updateStudent(Student student);
  public void deleteStudentById(Long id);
  
}
