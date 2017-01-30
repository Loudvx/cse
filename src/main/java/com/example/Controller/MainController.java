package com.example.Controller;

/**
 * Created by Lou-Evans on 29/01/2017.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homepage(){
        return "index";
    }
}

