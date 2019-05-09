/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers.admin;

import com.uniminuto.electiva.entities.Empleados;
import com.uniminuto.electiva.entities.EmpleadosMultiplex;
import com.uniminuto.electiva.entities.EmpleadosMultiplexPK;
import com.uniminuto.electiva.entities.Multiplexs;
import com.uniminuto.electiva.repositories.CustomEmpleadoMultiplexRepository;
import com.uniminuto.electiva.repositories.EmpleadoMultiplexRepository;
import com.uniminuto.electiva.repositories.EmpleadoRepository;
import com.uniminuto.electiva.repositories.MultiplexRepository;
import com.uniminuto.electiva.request.StoreEmpleadoRequest;
import com.uniminuto.electiva.request.TrasladoEmpleadoRequest;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "admin/empleados")
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    MultiplexRepository multiplexRepository;
    @Autowired
    EmpleadoMultiplexRepository empleadoMultiplexRepository;
    @Autowired
    CustomEmpleadoMultiplexRepository customEmpleadoMultiplexRepository;

    @GetMapping(path = "")
    public ModelAndView index(Model model) {
        model.addAttribute("empleados", empleadoRepository.findAll());
        return new ModelAndView("admin.empleados.index");
    }

    @GetMapping(path = "crear")
    public ModelAndView create(Model model) {
        model.addAttribute("multiplexs", multiplexRepository.findAll());
        return new ModelAndView("admin.empleados.create");
    }

    @PostMapping(path = "store")
    public ModelAndView store(Model model, @ModelAttribute StoreEmpleadoRequest empleadoRequest, RedirectAttributes redirAttrs) {
        Integer id = empleadoRepository.findMaxId();
        if (id == null) {
            id = 0;
        }
        id = id + 1;
        Empleados empleado = new Empleados();
        empleado.setCedula(empleadoRequest.getCedula());
        empleado.setCodigo(empleadoRequest.getCodigo());
        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setTelefono(empleadoRequest.getTelefono());
        empleado.setId(id);
        empleadoRepository.save(empleado);
        Optional<Multiplexs> multiplex = multiplexRepository.findById(empleadoRequest.getMultiplex());
        EmpleadosMultiplex empleadosMultiplex = new EmpleadosMultiplex();
        empleadosMultiplex.setInicio(new Date());
        empleadosMultiplex.setMultiplexs(multiplex.get());
        empleadosMultiplex.setEmpleados(empleado);
        EmpleadosMultiplexPK empleadosMultiplexPK = new EmpleadosMultiplexPK();
        empleadosMultiplexPK.setEmpleadosId(empleado.getId());
        empleadosMultiplexPK.setMultiplexsId(multiplex.get().getId());
        empleadosMultiplex.setEmpleadosMultiplexPK(empleadosMultiplexPK);
        empleadoMultiplexRepository.save(empleadosMultiplex);
        redirAttrs.addFlashAttribute("message", "Empleado creado correctamente");
        return new ModelAndView("redirect:/admin/empleados");
    }

    @GetMapping(path = "/{empleado}/trasladar")
    public ModelAndView trasladar(@PathVariable Empleados empleado, Model model) {
        model.addAttribute("empleado", empleado);
        EmpleadosMultiplex empleadosMultiplex = customEmpleadoMultiplexRepository.findByFinIsNull(empleado.getId());
        if (empleadosMultiplex == null) {
            empleadosMultiplex = new EmpleadosMultiplex();
        }
        model.addAttribute("multiplex", empleadosMultiplex.getMultiplexs());
        model.addAttribute("multiplexs", multiplexRepository.findAll());
        return new ModelAndView("admin.empleados.trasladar");
    }

    @PostMapping(path = "{empleado}/trasladar/store")
    public ModelAndView trasladar(@PathVariable Empleados empleado, @ModelAttribute TrasladoEmpleadoRequest trasladoEmpleadoRequest, RedirectAttributes redirAttrs) {
        Optional<Multiplexs> multiplex = multiplexRepository.findById(trasladoEmpleadoRequest.getMultiplex());
        EmpleadosMultiplex empleadosMultiplex = customEmpleadoMultiplexRepository.findByFinIsNull(empleado.getId());
        empleadosMultiplex.setFin(new Date());
        empleadoMultiplexRepository.save(empleadosMultiplex);
        EmpleadosMultiplex empleadosMultiplex1 = new EmpleadosMultiplex();
        empleadosMultiplex1.setEmpleados(empleado);
        empleadosMultiplex1.setInicio(new Date());
        empleadosMultiplex1.setMultiplexs(multiplex.get());
        EmpleadosMultiplexPK empleadosMultiplexPK = new EmpleadosMultiplexPK();
        empleadosMultiplexPK.setEmpleadosId(empleado.getId());
        empleadosMultiplexPK.setMultiplexsId(multiplex.get().getId());
        empleadosMultiplex1.setEmpleadosMultiplexPK(empleadosMultiplexPK);
        empleadoMultiplexRepository.save(empleadosMultiplex1);
        redirAttrs.addFlashAttribute("message", "Empleado trasladado correctamente");
        return new ModelAndView("redirect:/admin/empleados");
    }
}
