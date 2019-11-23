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

import com.washer.shoewasher.app.models.Pedido;
import com.washer.shoewasher.app.services.ColorService;
import com.washer.shoewasher.app.services.MaterialService;
import com.washer.shoewasher.app.services.PedidoService;
import com.washer.shoewasher.app.services.TallaService;
import com.washer.shoewasher.app.services.TipoCalzadoService;
import com.washer.shoewasher.app.services.TipoLavadoService;
import com.washer.shoewasher.app.services.UsuarioService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	@Value("${tittle}")
	private String tittle;
	
	@Value("${design}")
	private String design;
	
	@Value("${version}")
	private String version;
	
	@Value("${actualizado}")
	private String update;
	
	@Autowired
	private PedidoService Serv;

	
	@Autowired
	private UsuarioService ServUsu;
	
	
	@Autowired
	private TipoCalzadoService ServTip;
	
	
	
	@Autowired
	private ColorService ServColor;
	
	
	
	@Autowired
	private TallaService ServTalla;
	
	
	
	@Autowired
	private MaterialService ServMate;
	
	
	
	@Autowired
	private TipoLavadoService ServLava;
	
	
	
	@RequestMapping(path="/insertar", method = RequestMethod.POST)
	public String insertar(@Valid Pedido us, Model model) {
        Serv.save(us);
		return "redirect:All"; 
	}
	
	
	@RequestMapping(path="/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Pedido us, @PathVariable("id") long id, Model model) {
		us.setId_Pedido(id);
		Serv.update(us);
		return "redirect:../All";
	}
	
	@DeleteMapping(path="/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		Serv.delete(id); 
	}
	
	@GetMapping(path = "/all")
	public List<Pedido> listarall() {
		return Serv.listar();
	}
	
	@GetMapping(path = {"/{id}"})
    public Optional<Pedido> listarId(@PathVariable("id")long id){
        return Serv.listarId(id);
    }
	
	
	
	
	@GetMapping(path="/All")
	public String listarAll(Model model) {
		model.addAttribute("tittle", tittle);
		model.addAttribute("design", design);
		model.addAttribute("version", version);
		model.addAttribute("update", update);
		List<Pedido> ObjetoPedido = Serv.listar();
		model.addAttribute("pedidos", ObjetoPedido);
		model.addAttribute("usuarios", ServUsu.listar());
		model.addAttribute("tipCalzado", ServTip.listar());
		model.addAttribute("Color", ServColor.listar());
		model.addAttribute("Talla", ServTalla.listar());
		model.addAttribute("material", ServMate.listar());
		model.addAttribute("tipLavado", ServLava.listar());
		
		return "/views/pedidos/formList";
		
	}
	
	
	@GetMapping(path="/crear")
	public String crearFunc(Map<String, Object> model) {
		Pedido pedidosObject = new Pedido();
		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("pedidos", pedidosObject);
		model.put("usuarios", ServUsu.listar());
		model.put("tipCalzado", ServTip.listar());
		model.put("Color", ServColor.listar());
		model.put("Talla", ServTalla.listar());
		model.put("material", ServMate.listar());
		model.put("tipLavado", ServLava.listar());
		
		return "/views/pedidos/formAdd"; 
	}
	
	@GetMapping(path = {"/edit/{id}"})
    public String listar(@PathVariable("id") Long id, Map<String, Object> model, RedirectAttributes flash){
		Pedido pedidos = null;
		

		if (id > 0) {
			pedidos = Serv.listarId(id);
			if (pedidos == null) {
				flash.addFlashAttribute("error", "El ID del cliente no existe!");
				return "redirect:/views/pedidos/formList";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/views/pedidos/formList";
		}
		
		model.put("tittle", tittle);
		model.put("design", design);
		model.put("version", version);
		model.put("update", update);
		model.put("pedidos", pedidos);
		model.put("usuarios", ServUsu.listar());
		model.put("tipCalzado", ServTip.listar());
		model.put("Color", ServColor.listar());
		model.put("Talla", ServTalla.listar());
		model.put("material", ServMate.listar());
		model.put("tipLavado", ServLava.listar());
		
		return "/views/pedidos/formEdit";
    }
	
}
