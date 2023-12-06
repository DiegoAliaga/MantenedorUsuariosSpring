package com.daliaga.MantenedorUsuariosSpring.repository;

import com.daliaga.MantenedorUsuariosSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
