package me.ez7mz.atl5jee.Registration;

import me.ez7mz.atl5jee.Student.Student;
import me.ez7mz.atl5jee.Student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;
    private final StudentService studentService;

    public RegistrationController(RegistrationService registrationService, StudentService studentService) {
        this.registrationService = registrationService;
        this.studentService = studentService;
    }

    @RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
    public ModelAndView saveRegistration(@ModelAttribute Registration registration, @ModelAttribute Student student){
        studentService.addNewStudent(student);
        registration.setStudent(student);
        registration.setStudentId(student.getId());
        System.out.println("Registration from UI = "+ registration);
        System.out.println("Student from UI = "+ registration.getStudent());

        registrationService.addNewRegistration(registration);
//        studentService.addNewStudent(student);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student_information");
        modelAndView.addObject("reg", registration);
        return modelAndView;
    }
}
