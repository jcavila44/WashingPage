package com.washer.shoewasher.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.shoewasher.app.models.Pedido;
import com.washer.shoewasher.app.repositories.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository Rep;

	public Pedido save(Pedido var) {
		return Rep.save(var);
	}

	public Pedido update(Pedido var) {
		return Rep.save(var);
	}

	public void delete(long var) {
		Rep.deleteById(var);
	}

	public List<Pedido> listar() {
		return Rep.findAll();
	}

	public Optional<Pedido> listarId(long var) {
		return Rep.findById(var);
	}
}
