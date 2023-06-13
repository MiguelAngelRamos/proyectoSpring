package cl.awakelab.bootcamp.repositories;

import org.springframework.data.repository.CrudRepository;

import cl.awakelab.bootcamp.entitys.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {

}
