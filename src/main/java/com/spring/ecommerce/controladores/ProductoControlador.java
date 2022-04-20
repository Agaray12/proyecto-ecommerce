package com.spring.ecommerce.controladores;

import com.spring.ecommerce.entidades.Usuario;
import com.spring.ecommerce.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/productos")
public class ProductoControlador {
    
    @Autowired
    private ProductoServicio ps;
    
    @GetMapping("")
    public String show(ModelMap modelo){
        modelo.addAttribute("productos", ps.listarProductos());
        return "productos/show";
    }
    
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }
    
    @PostMapping("/create")
    public String create(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam Double precio, @RequestParam Integer cantidad){
        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        ps.registrarProducto(nombre, descripcion, precio, cantidad, u);
        return "redirect:/productos";
    }
}
