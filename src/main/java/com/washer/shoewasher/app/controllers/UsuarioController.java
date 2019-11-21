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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.washer.shoewasher.app.models.Ciudad;
import com.washer.shoewasher.app.models.Departamento;
import com.washer.shoewasher.app.models.Estado;
import com.washer.shoewasher.app.models.Rol;
import com.washer.shoewasher.app.models.Usuario;
import com.washer.shoewasher.app.services.CiudadService;
import com.washer.shoewasher.app.services.DepartamentoService;
import com.washer.shoewasher.app.services.EstadoService;
import com.washer.shoewasher.app.services.RolService;
import com.washer.shoewasher.app.services.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Value("${tittle}")
	private String tittle;
	
	@Value("${design}")
	private String design;
	
	@Value("${version}")
	private String version;
	
	@Value("${actualizado}")
	private String update;
	
	@Autowired
	private UsuarioService Serv;
	
	@Autowired
	private DepartamentoService ServDpto;
	
	@Autowired
	private CiudadService ServCity;
	
	@Autowired
	private RolService ServRol;
	
	@Autowired
	private EstadoService ServEst;
	
	@RequestMapping(path="/insertar", method = RequestMethod.POST)
	public String insertar(@Valid Usuario us, Model model) {
		us.setId_Estado(1);
        Serv.save(us);
		return "redirect:All"; 
	}
	
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Usuario us, @PathVariable("id") long id, Model model) {
		us.setId_Usuario(id);
		Serv.update(us); 
		return "redirect:../All";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id); 
	}
	
	@GetMapping(path = "/all")
	public List<Usuario> listarall() {
		return Serv.listar();
	}
	
	@GetMapping(path = {"/{id}"})
    public Optional<Usuario> listarId(@PathVariable("id")long id){
        return Serv.listarId(id);
    }
	
	
	
	
	@GetMapping(path="/All")
	public String listarAll(Model model) {
		model.addAttribute("tittle", tittle);
		model.addAttribute("design", design);
		model.addAttribute("version", version);
		model.addAttribute("update", update);
		model.addAttribute("usrs", Serv.listar());
		
		return "/views/users/formList";
	}
	
	@GetMapping(path="/listCity/{id}")
	public String listarCity(@PathVariable("id") Long idDpto, Model model) {
		List<Ciudad> city = ServCity.ListCity(idDpto);
		model.addAttribute("city", city);
		
		return "/views/users/formAdd :: listCity";
	}
	
	@GetMapping(path="/crear")
	public String crearFunc(Map<String, Object> model) {
		Usuario usr = new Usuario();
		List<Departamento> dpto = ServDpto.listar();
		List<Rol> roles = ServRol.listar();
		
		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("usuario", usr);
		model.put("dpto", dpto);
		model.put("roles", roles);
		
		return "/views/users/formAdd"; 
	}
	
	@GetMapping(path = {"/edit/{id}"})
    public String listar(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Usuario users = null;
		
		List<Departamento> dpto = ServDpto.listar();
		List<Rol> roles = ServRol.listar();
		List<Estado> states = ServEst.ListEst((long)1);

		if (id > 0) {
			users = Serv.listarId(id);
			if (users == null) {
				flash.addFlashAttribute("error", "El ID del cliente no existe!");
				return "redirect:/views/users/formList";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/views/users/formList";
		}
		
		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("usuario", users);
		model.put("dpto", dpto);
		model.put("roles", roles);
		model.put("states", states);
		
		return "/views/users/formEdit";
    }
	
	@PostMapping(path = {"/login"})
    public List<Usuario> Login(@RequestParam String user, @RequestParam(name = "pwd") String pwd, Model model){
        System.out.println("usuario obtenido en el control " + user);
        System.out.println("contrasena obtenido en el control " + pwd);
		return Serv.LoginService(user, pwd);
    }
}
