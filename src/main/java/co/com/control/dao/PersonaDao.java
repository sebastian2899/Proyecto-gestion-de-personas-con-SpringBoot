package co.com.control.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.control.domain.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{
}
