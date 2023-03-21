package project.student_management.service;

import project.student_management.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student>getAllStudents();
    public Student addStudent(Student student);
    public Student getStudentById(Long id);
    public Student updateStudent(Student student);
    public void deleteStudent(Long id);
}
