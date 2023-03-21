package project.student_management.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import project.student_management.model.Student;
import project.student_management.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/students";
    }
    @GetMapping ("/students")
    public String list(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        model.addAttribute("addStudent", new Student());
        return "students";
    }
    @GetMapping("/students/add")
    public String addStudentForm(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("action","/students/add");
        model.addAttribute("click","Add");
        return "updateStudent";
    }
    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("action","/students/update/" + id);
        model.addAttribute("click","Update");
        return "updateStudent";
    }
    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        Student studentUpdate = studentService.getStudentById(id);
        studentUpdate.setFirstName(student.getFirstName());
        studentUpdate.setLastName(student.getLastName());
        studentUpdate.setEmail(student.getEmail());
        studentService.updateStudent(studentUpdate);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
