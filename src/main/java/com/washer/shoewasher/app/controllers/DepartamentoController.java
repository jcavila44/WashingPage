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

import com.washer.shoewasher.app.models.Color;
import com.washer.shoewasher.app.models.Departamento;
import com.washer.shoewasher.app.services.DepartamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	@Value("${tittle}")
	private String tittle;

	@Value("${design}")
	private String design;

	@Value("${version}")
	private String version;

	@Value("${actualizado}")
	private String update;

	@Autowired
	private DepartamentoService Serv;

	@RequestMapping(path = "/insertar", method = RequestMethod.POST)
	public String insertar(@Valid Departamento var, Model model) {
		Serv.save(var);
		return "redirect:All";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Departamento var, @PathVariable("id") long id, Model model) {
		var.setId_Depto(id);
		Serv.update(var);
		return "redirect:../All";
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<Departamento> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<Departamento> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}
	

	@GetMapping(path = "/All")
	public String listarAll(Model model) {
		model.addAttribute("tittle", tittle);
		model.addAttribute("design", design);
		model.addAttribute("version", version);
		model.addAttribute("update", update);
		model.addAttribute("departaments", Serv.listar());

		return "/views/departament/formList";
	}
	@GetMapping(path = "/crear")
	public String crearFunc(Map<String, Object> model) {
		Departamento departamento = new Departamento();

		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("departament", departamento);

		return "/views/departament/formAdd";
	}

	@GetMapping(path = { "/edit/{id}" })
	public String listar(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Departamento departamento = null;

		if (id > 0) {
			departamento = Serv.listarId(id);
			if (departamento == null) {
				flash.addFlashAttribute("error", "El ID del Departamento no existe!");
				return "redirect:/views/departament/formList";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del Departamento no puede ser cero!");
			return "redirect:/views/departamento/formList";
		}

		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("departament", departamento);

		return "/views/departament/formEdit";
	}

}

