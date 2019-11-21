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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.washer.shoewasher.app.models.ClaseEstado;
import com.washer.shoewasher.app.services.ClaseEstadoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/claseEstado")
public class ClaseEstadoController {
	@Value("${tittle}")
	private String tittle;

	@Value("${design}")
	private String design;

	@Value("${version}")
	private String version;

	@Value("${actualizado}")
	private String update;

	@Autowired
	private ClaseEstadoService Serv;

	@RequestMapping(path = "/insertar", method = RequestMethod.POST)
	public String insertar(@Valid ClaseEstado us, Model model) {
		Serv.save(us);
		return "redirect:All";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.POST)
	public String update(@Valid ClaseEstado us, @PathVariable("id") long id, Model model) {
		us.setId_ClaseEstado(id);
		Serv.update(us);
		return "redirect:../All";
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id);
	}

	@GetMapping(path = "/all")
	public List<ClaseEstado> listarall() {
		return Serv.listar();
	}

	@GetMapping(path = { "/{id}" })
	public Optional<ClaseEstado> listarId(@PathVariable("id") long id) {
		return Serv.listarId(id);
	}

	@GetMapping(path = "/All")
	public String listarAll(Model model) {
		model.addAttribute("tittle", tittle);
		model.addAttribute("design", design);
		model.addAttribute("version", version);
		model.addAttribute("update", update);
		model.addAttribute("ClaseEstado", Serv.listar());

		return "/views/ClaseEstados/formList";
	}

	@GetMapping(path = "/crear")
	public String crearFunc(Map<String, Object> model) {
		ClaseEstado ClaseEstado = new ClaseEstado();

		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("ClaseEstado", ClaseEstado);

		return "/views/ClaseEstados/formAdd";
	}

	@GetMapping(path = { "/edit/{id}" })
	public String listar(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		ClaseEstado ClaseEstados = null;

		if (id > 0) {
			ClaseEstados = Serv.listarId(id);
			if (ClaseEstados == null) {
				flash.addFlashAttribute("error", "El ID del ClaseEstado no existe!");
				return "redirect:/views/claseEstado/formList";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del ClaseEstado no puede ser cero!");
			return "redirect:/views/claseEstado/formList";
		}

		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("ClaseEstado", ClaseEstados);

		return "/views/ClaseEstados/formEdit";
	}

}
