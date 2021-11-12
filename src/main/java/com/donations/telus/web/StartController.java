package com.donations.telus.web;

import com.donations.telus.domain.Person;
import com.donations.telus.service.IPersonService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController
@Controller
@Slf4j
public class StartController {

    /**
     * @see IpersonService
     * @code this the interface that will be used for the CRUD
     */
    @Autowired
    private IPersonService iPersonService;
    //@Value("${index.saludo}")
    //private String saludo;

    /**
     *
     * @code firrst method called localhost:8080
     * @param uses a Model which is part of spring boot
     */
    @GetMapping("/")
    public String init(Model model, @AuthenticationPrincipal User user) {
        var team = iPersonService.personList();
        log.info("usuario que hizo login : " + user);
        model.addAttribute("team", team);
        return "index";
    }

    @GetMapping("/update")
    public String update(Person person) {

        return "modify";

    }

    /**
     * This method is to save user data and validate if error will send back to
     * modify which is the update method or Index which is the homepage These 2
     * params must stay next to each other.
     *
     * @param person send object to store in Database
     * @return back to homepage localhots:8080
     * @param errors send back validation error class belongs to Spring Boot
     *
     */
    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "modify";
        }
        iPersonService.save(person);
        return "redirect:/";

    }

    /**
     * This methos will be used to edit. It will search for a user/person using
     * the personId variable with the service inteface IPersonService
     *
     * @param person is the user / object to be updated
     * @param model is the send date back to html
     * @return the name of the param in the URL in this case it will take the
     * user back to edit the user chosen
     */
    @GetMapping("/edit/{personId}")
    public String edit(Person person, Model model) {
        person = iPersonService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";

    }

    //@PostMapping("/delete/{personId}")
    @GetMapping("/delete")
    public String delete(Person person) {

        iPersonService.delete(person);

        return "redirect:/";

    }

//    @GetMapping("/")
//    public String init(Model model){
//        var mensaje ="hola mundo";
//        model.addAttribute("mensaje", mensaje);
//        model.addAttribute("saludo", saludo);
//        
//        var person = new Person();
//        person.setName("Josh");
//        person.setEmail("jcoco@gmail.com");
//        person.setCreatedOn(LocalDateTime.now());
//        
//        
//        var person2 = new Person();
//        person2.setName("Coco");
//        person2.setEmail("coco@gmail.com");
//        person2.setCreatedOn(LocalDateTime.now());
//        
//        var personas = new ArrayList();
//        personas.add(person);
//        personas.add(person2);
//        //var team = Arrays.asList(person, person2);
//        var team = Arrays.asList();
//        
//        
//        model.addAttribute("team", team);
//        model.addAttribute("person", person);
//        
//        
//        
//        log.info("calling index");
//        log.debug("debug");
//        return "index";
//    
//    }
}
