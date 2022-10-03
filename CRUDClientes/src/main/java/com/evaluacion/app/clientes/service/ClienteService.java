package com.evaluacion.app.clientes.service;

import java.util.List;

import com.evaluacion.app.clientes.bean.Cliente;

public interface ClienteService {
	

	Cliente add(Cliente c);
	Cliente update(Cliente c);
	Cliente search(int id);
	String delete(int id);
	List<Cliente> allshow();
}
