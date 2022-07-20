package com.project.triple.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Triple")   // http://localhost:9090/Triple
public class PageController {

    @RequestMapping(path={""})
    public ModelAndView index(){
        return null;
    }
}
