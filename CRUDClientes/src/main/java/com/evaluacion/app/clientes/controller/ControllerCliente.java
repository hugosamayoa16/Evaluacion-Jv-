package com.evaluacion.app.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.app.clientes.bean.Cliente;
import com.evaluacion.app.clientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ControllerCliente {
	
	@Autowired
	ClienteService service;

	@PostMapping("add")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return service.add(cliente);
	}

	@PutMapping("update")
	public Cliente update(@RequestBody Cliente cliente) {
		return service.update(cliente);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}

	@GetMapping("search/{id}")
	public Cliente buscar(@PathVariable int id) {
		return service.search(id);
	}

	@GetMapping("allshow")
	public List<Cliente> listarClientes() {
		return service.allshow();
	}
}
