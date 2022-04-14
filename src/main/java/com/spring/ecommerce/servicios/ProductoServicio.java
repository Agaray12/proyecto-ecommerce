package com.spring.ecommerce.servicios;

import com.spring.ecommerce.entidades.Producto;
import com.spring.ecommerce.entidades.Usuario;
import com.spring.ecommerce.repositorios.ProductoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio pr;
    
    public void registrarProducto(String nombre, String descripcion, Double precio, Integer cantidad, Usuario usuario){
        Producto producto = new Producto();
        
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setUsuario(usuario);
        
        pr.save(producto);
    }
    
    public Optional<Producto> buscarProducto(Integer idProducto){
        return pr.findById(idProducto);
    }
    
    public void modificarProducto(Integer idProducto, String nombre, String descripcion, Double precio, Integer cantidad, Usuario usuario){
        Optional<Producto> respuesta = buscarProducto(idProducto);
        
        if(respuesta.isPresent()){
            Producto producto = respuesta.get();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
            producto.setUsuario(usuario);
            pr.save(producto);
        }
    }
    
    public void eliminarProducto(Integer idProducto){
        pr.deleteById(idProducto);
    }
    
    public List<Producto> listarProductos(){
        return pr.findAll();
    }
    
}
