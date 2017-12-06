package de.tiupe.controller;


import de.tiupe.business.User;
import de.tiupe.business.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;


    @RequestMapping(method = RequestMethod.GET, value="/register")
    public String showForm(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value="/register")
    public String saveUser(Model aModel, @Valid User aUser, Errors errors) {
        if (errors.hasErrors()) {
            aModel.addAttribute("user", aUser);
            aModel.addAttribute("errors", errors.getFieldErrors());
            return "register";
        }
        this.userRepo.save(aUser);
        return "redirect:/user/find/" + aUser.getUsername();
    }

    @RequestMapping(method = RequestMethod.GET, value="/find/{username}")
    public String findUser(Model model, @PathVariable("username") String username){
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);
        return "find";
    }


}
