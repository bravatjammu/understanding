package de.hsm.controller;

import de.hsm.persistent.User;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import logic.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author neuhardt
 */
@Controller
public class LoginRegistrationController {

    @GetMapping("/")
    public ModelAndView login(LoginModel loginModel) {
        ModelAndView mv = new ModelAndView();     
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/")
    public ModelAndView showLogin(LoginModel loginModel, HttpSession session, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        UserManager userManager = new UserManager();
        
        if (userManager.loginUser(loginModel.getUserName(), loginModel.getPassword()) == null) {
            mv.setViewName("login");
            mv.addObject(loginModel);
            String [ ] codes = {"Password.Wrong"};
            FieldError fe = new FieldError("user", "password",
                                                loginModel.getPassword(), false, codes, null, "This is default error");
            bindingResult.addError(fe);
            return mv;
        }
        mv.setViewName("dashboard");
        mv.addObject(loginModel);
        userManager.loginUser(loginModel.getUserName(), loginModel.getPassword());
        session.setAttribute("user", loginModel);
        return mv;
    }

    @GetMapping("/registration")
    public ModelAndView registration(User user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        Map<String, String> names = new HashMap<>();
        names.put("Other1", "Other");
        names.put("Male1", "Male");
        names.put("Female1", "Female");
        mv.addObject("names", names);
        SortedMap<String, Integer> ages = new TreeMap<>();

        for (int i = 1; i <= 99; i++) {
            if (Integer.toString(i).length() == 1) {
                ages.put(" " + i, i);
            } else {
                ages.put("" + i, i);
            }
        }
        mv.addObject("ages", ages);
        mv.setViewName("registration");
        return mv;
    }

    @PostMapping("/registration")
    public ModelAndView showRegistration(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView();        
        UserManager userManager = new UserManager();
        
        if(!userManager.checkEmail(user.getEmailID())){
            String [ ] codes = {"Email.In.use"};
            FieldError fe = new FieldError("user", "emailID",
                                                user.getEmailID(), false, codes, null, "This is default error");
            bindingResult.addError(fe);
            Map<String, String> names = new HashMap<>();
            names.put("Other1", "Other");
            names.put("Male1", "Male");
            names.put("Female1", "Female");
            mv.addObject("names", names);
            SortedMap<String, Integer> ages = new TreeMap<>();
            for (int i = 1; i <= 99; i++) {
                
                if (Integer.toString(i).length() == 1) {
                    ages.put(" " + i, i);
                } else {
                    ages.put("" + i, i);
                }
            }
            mv.addObject("ages", ages);
            mv.setViewName("registration");
            return mv;
        }
        
        if (bindingResult.hasErrors()) {
            Map<String, String> names = new HashMap<>();
            names.put("Other1", "Other");
            names.put("Male1", "Male");
            names.put("Female1", "Female");
            mv.addObject("names", names);
            SortedMap<String, Integer> ages = new TreeMap<>();
            for (int i = 1; i <= 99; i++) {
                
                if (Integer.toString(i).length() == 1) {
                    ages.put(" " + i, i);
                } else {
                    ages.put("" + i, i);
                }
            }
            mv.addObject("ages", ages);
            mv.setViewName("registration");
            return mv;
        }
        mv.setViewName("login");
        LoginModel loginModel = new LoginModel();
        loginModel.setUserName(user.getUserName());
        loginModel.setPassword(user.getPassword());
        loginModel.setAge(user.getAge());
        loginModel.setFirstName(user.getFirstName());
        loginModel.setLastName(user.getLastName());
        loginModel.setGender(user.getGender());
        
        mv.addObject(loginModel);
        userManager.registerUser(user);
        
        return mv;
    }
}
