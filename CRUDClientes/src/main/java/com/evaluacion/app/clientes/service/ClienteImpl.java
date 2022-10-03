package com.evaluacion.app.clientes.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;

import org.springframework.stereotype.Service;

import java.io.File;

import com.evaluacion.app.clientes.bean.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClienteImpl implements ClienteService {

	private File file;
	private HashMap<Integer, Cliente> clientes;
	private ObjectMapper mapper;
	private int id = 0;

	ClienteImpl() {
		try {
			file = new File("C:\\Users\\NS-608\\Documents\\Json\\clientes.json");
			clientes = new HashMap<Integer, Cliente>();
			mapper = new ObjectMapper();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente add(Cliente cliente) {
		
//		System.out.println("este es el ultimo valor de la lista : "+v);
		id++;
		cliente.setClienteid(id);

		clientes.put(id, cliente);
		this.mantener(file, clientes);
		return new Cliente(id, cliente.getNombre(), cliente.getEdad(), cliente.getSexo(), cliente.getCorreo());
	}

	@Override
	public Cliente update(Cliente cliente) {//
		clientes.put(cliente.getClienteid(), cliente);
		this.mantener(file, clientes);
		return new Cliente(cliente.getClienteid(), cliente.getNombre(), cliente.getEdad(), cliente.getSexo(),
				cliente.getCorreo());
	}

	@Override
	public String delete(int id) {
		try {
			HashMap<Integer, Cliente> cliente = this.leerJson();
			if (search(id) != null) {
				cliente.remove(id);
				this.mantener(file, cliente);

			} else {
				return "No se encuentra el registro a eliminar!!!!";

			}

		} catch (Exception e) {
			return "ocurrio un error al eliminar";
		}
		return "Eliminado correctamente!!";

	}

	@Override
	public Cliente search(int id) {
		return this.leerJson().get(id);
	}

	@Override
	public List<Cliente> allshow() {
		List<Cliente> listClientes = new ArrayList<Cliente>();
		for (Integer key : this.leerJson().keySet()) {
			listClientes.add(this.leerJson().get(key));
		}
		return listClientes;
	}

	public HashMap<Integer, Cliente> leerJson() {
		HashMap<Integer, Cliente> clientesExistentes = new HashMap<Integer, Cliente>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inStr = new FileInputStream(file);
			TypeReference<HashMap<Integer, Cliente>> typeReference = new TypeReference<HashMap<Integer, Cliente>>() {
			};
			clientesExistentes = mapper.readValue(inStr, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientesExistentes;
	}

	public void mantener(File file, HashMap<Integer, Cliente> hashM) {
		try {
			mapper.writeValue(file, hashM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
