package com.uniminuto.electiva.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController{

    @GetMapping(path = "")
    public ModelAndView index() {
        return new ModelAndView("admin.index");
    }

}
