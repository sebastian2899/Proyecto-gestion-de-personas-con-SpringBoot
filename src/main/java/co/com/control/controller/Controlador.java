package co.com.control.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import co.com.control.domain.Persona;
import co.com.control.service.PersonaService;

@Controller
public class Controlador {

	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		List<Persona>personas = personaService.listarPersonas();
		model.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregarPersona(Persona persona) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardarPersona(@Valid Persona persona,Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		
		personaService.guardarPersona(persona);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona,Model model) {
		persona = personaService.consultarPersona(persona);
		model.addAttribute("persona",persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar/{idPersona}")
	public String eliminar(Persona persona) {
		personaService.eliminarPersona(persona);
		return "redirect:/";
	}
	
}
