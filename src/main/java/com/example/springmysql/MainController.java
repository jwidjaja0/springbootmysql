package com.example.springmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email){
        //@ResponseBody means the returned String is the response, not a view name
        //@RequestParam means it is a parameter from the Get or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        //This returns a JSON or XML with the users
        return userRepository.findAll();
    }

}
