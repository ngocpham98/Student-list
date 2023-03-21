package project.student_management.service;

import project.student_management.model.Student;
import project.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIml implements StudentService{

    private StudentRepository studentRepository;
    public StudentServiceIml(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student>getAllStudents(){

        return studentRepository.findAll();
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
