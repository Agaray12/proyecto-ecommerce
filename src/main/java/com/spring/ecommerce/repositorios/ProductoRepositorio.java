package com.spring.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.ecommerce.entidades.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
