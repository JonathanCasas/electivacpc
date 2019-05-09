/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.entities.Multiplexs;
import com.uniminuto.electiva.repositories.MultiplexRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "")
public class IndexController {

    @Autowired
    MultiplexRepository multiplexRepository;

    @GetMapping(path = "")
    public ModelAndView index(Model model) {
        List<Multiplexs> multiplexs = (List<Multiplexs>) multiplexRepository.findAll();
        model.addAttribute("multiplexs", multiplexs);
        return new ModelAndView("home");
    }

}
