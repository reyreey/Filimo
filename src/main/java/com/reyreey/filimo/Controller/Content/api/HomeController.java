package com.reyreey.filimo.Controller.Content.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : reyreey
 * @mailto : reyhaneh179@yahoo.com
 * @created : 3/30/2025, Sunday
 **/

@Controller
public class HomeController {

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Hello Reyreey!";
    }
}
