package com.daliaga.MantenedorUsuariosSpring.repository;

import com.daliaga.MantenedorUsuariosSpring.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono,Long> {
}
