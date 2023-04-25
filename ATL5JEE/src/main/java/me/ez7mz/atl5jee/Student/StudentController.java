package me.ez7mz.atl5jee.Student;

import me.ez7mz.atl5jee.Registration.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Registration registration, @ModelAttribute Student student){
        registration.setStudent(student);
        System.out.println("Student from UI = "+ registration);
        /*
            Here write code to save student to database
        */

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student_information");
        modelAndView.addObject("reg", registration);
        return modelAndView;
    }

}
