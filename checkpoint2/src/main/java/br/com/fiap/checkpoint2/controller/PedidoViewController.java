package br.com.fiap.checkpoint2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.command.AddPedido;
import br.com.fiap.checkpoint2.command.DeletePedido;
import br.com.fiap.checkpoint2.command.GetAllPedidos;
import br.com.fiap.checkpoint2.command.GetPedidoById;
import br.com.fiap.checkpoint2.command.UpdatePedido;
import br.com.fiap.checkpoint2.dto.PedidoDto;

@RestController
@RequestMapping("pedido")
public class PedidoViewController {
	
	@Autowired
	private AddPedido addPedido;
	
	@Autowired
	private UpdatePedido updatePedido;
	
	@Autowired
	private DeletePedido deletePedido;
	
	@Autowired
	private GetPedidoById getPedidoById;
	
	@Autowired
	private GetAllPedidos getAllPedidos;
	
	@PostMapping("/create")
	public String addNewPedido(@RequestBody PedidoDto pedidoDto) {
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("pedidoDto", pedidoDto);
		Map<String, Object> retorno = addPedido.executar(dados);
		
		return retorno.get("stringRetorno").toString();
	}
	
	@PutMapping("/update/{id}")
	public String updatePedido(@PathVariable Long id, @RequestBody PedidoDto pedidoDto) {		
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("pedidoDto", pedidoDto);
		dados.put("id", id);
		Map<String, Object> retorno = updatePedido.executar(dados);
		
		return retorno.get("stringRetorno").toString();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePedido(@PathVariable Long id) {
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("id", id);
		Map<String, Object> retorno = deletePedido.executar(dados);
		
		return retorno.get("stringRetorno").toString();	
	}
	
	@GetMapping("/{id}")
	public PedidoDto getPedidoById(@PathVariable Long id) {
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("id", id);
		Map<String, Object> retorno = getPedidoById.executar(dados);
		if (retorno.get("retorno").getClass().getSimpleName() == "String")
			return null;

		return (PedidoDto) retorno.get("retorno");
	}
	
	@GetMapping
	public List<PedidoDto> listAllPedidos() {
		Map<String, Object> dados = null;
		Map<String, Object> retorno = getAllPedidos.executar(dados);
		
		return (List<PedidoDto>) retorno.get("list");
	}

}
