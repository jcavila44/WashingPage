package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.washer.shoewasher.app.models.Pedido;
import com.washer.shoewasher.app.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository Rep;

	@Transactional
	public void save(Pedido us) {
		Rep.save(us);
	}
	
	@Transactional
	public void update(Pedido us) {
		Rep.save(us);
	}
	
	public void delete(long id) {
		Rep.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Pedido> listar(){
		return Rep.findAll();
	}
	
	public Optional<Pedido> listarId(long id) {
        return Rep.findById(id);
    }
	
	@Transactional(readOnly = true)
	public Pedido listarId(Long id) {
		return Rep.findById(id).orElse(null);
	}
	
}
