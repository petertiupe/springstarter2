package de.tiupe.controller;


import de.tiupe.business.User;
import de.tiupe.business.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restuser")
public class RestUserController {

    @Autowired
    UserRepository userRepo;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method=RequestMethod.POST, produces="application/json", consumes = "application/json")
    public @ResponseBody User addUser(@RequestBody User aUser) {
        User myUser = this.userRepo.save(aUser);
        return myUser;
    }

}
