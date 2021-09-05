package co.com.control.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.control.dao.PersonaDao;
import co.com.control.domain.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		return personaDao.findAll();
	}

	@Override
	public Persona consultarPersona(Persona persona) {
		return persona = personaDao.findById(persona.getIdPersona()).orElse(null);
	}

	@Override
	public void guardarPersona(Persona persona) {
		personaDao.save(persona);
	}

	@Override
	public void eliminarPersona(Persona persona) {
		personaDao.delete(persona);
	}

}
