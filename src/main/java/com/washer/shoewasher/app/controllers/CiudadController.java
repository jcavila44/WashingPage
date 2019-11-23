package com.washer.shoewasher.app.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.washer.shoewasher.app.models.Ciudad;
import com.washer.shoewasher.app.models.Departamento;
import com.washer.shoewasher.app.models.Rol;
import com.washer.shoewasher.app.models.Usuario;
import com.washer.shoewasher.app.services.CiudadService;
import com.washer.shoewasher.app.services.DepartamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/ciudad")
public class CiudadController {
	@Value("${tittle}")
	private String tittle;

	@Value("${design}")
	private String design;

	@Value("${version}")
	private String version;

	@Value("${actualizado}")
	private String update;
	
	@Autowired
	private DepartamentoService departamentoS;
	@Autowired
	private CiudadService Serv;

	@RequestMapping(path = "/insertar", method = RequestMethod.POST)
	public String insertar(@Valid Ciudad var, Model model) {
		Serv.save(var);
		return "redirect:All";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Ciudad var, @PathVariable("id") long id, Model model) {
		var.setId_Ciudad(id);
		Serv.update(var);
		return "redirect:../All";
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Ciudad> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Ciudad> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
	
	@GetMapping(path = "/list/{id}")
	public List<Ciudad> listarCity(@PathVariable("id") Long id) {
		return Serv.ListCity(id);
	}
	
	@GetMapping(path = "/All")
	public String listarAll(Model model) {
		model.addAttribute("tittle", tittle);
		model.addAttribute("design", design);
		model.addAttribute("version", version);
		model.addAttribute("update", update);
		model.addAttribute("city", Serv.listar());
		model.addAttribute("departament", departamentoS.listar());
		return "/views/city/formList";
	}
	
	@GetMapping(path="/crear")
	public String crearFunc(Map<String, Object> model) {
		Ciudad ciudad = new Ciudad();
		List<Departamento> dpto = departamentoS.listar();
		
		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("city", ciudad);
		model.put("dpto", dpto);
		
		return "/views/city/formAdd"; 
	}
	@GetMapping(path = { "/edit/{id}" })
	public String listar(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Ciudad ciudad = null;
		List<Departamento> dpto = departamentoS.listar();

		if (id > 0) {
			ciudad = Serv.listarId(id);
			if (ciudad == null) {
				flash.addFlashAttribute("error", "El ID de la Ciudad no existe!");
				return "redirect:/views/departament/formList";
			}
		} else {
			flash.addFlashAttribute("error", "El ID de la Ciudad no puede ser cero!");
			return "redirect:/views/city/formList";
		}

		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("dpto", dpto);
		model.put("city", ciudad);

		return "/views/city/formEdit";
	}
}
