package cl.awakelab.bootcamp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.bootcamp.entitys.Student;
import cl.awakelab.bootcamp.repositories.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
  
  
  private final IStudentRepository repository;
  
  @Autowired
  public StudentServiceImpl(IStudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Student> listAllStudents() {
    return (List<Student>) repository.findAll();
  }

  @Override
  public Student saveStudent(Student student) {
    return repository.save(student);
  }

  @Override
  public Optional<Student> getStudentById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Student updateStudent(Student student) {
    return repository.save(student);
  }

  @Override
  public void deleteStudentById(Long id) {
    repository.deleteById(id);
  }

}
