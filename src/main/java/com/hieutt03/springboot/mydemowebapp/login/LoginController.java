package com.hieutt03.springboot.mydemowebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }
    //    http://localhost:8080/login?name=Hieu
    //Model pass value into jsp
//    @RequestMapping("login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap model){
//        model.put("name", name);
//        logger.debug("Request param is {}", name);
//        return "login";
//    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (authenticationService.authenticate(name, password)) {

            model.put("name", name);

            return "welcome";
        }
        model.put("errorMessage", "Invalid username or password");
        return "login";

    }
}
