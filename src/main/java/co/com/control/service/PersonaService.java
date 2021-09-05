package co.com.control.service;

import java.util.List;

import co.com.control.domain.Persona;

public interface PersonaService {

	public List<Persona>listarPersonas();
	
	public Persona consultarPersona(Persona persona);
	
	public void guardarPersona(Persona persona);
	
	public void eliminarPersona(Persona persona);
	
}
