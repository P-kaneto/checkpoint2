package br.com.fiap.checkpoint2.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.PedidoDto;
import br.com.fiap.checkpoint2.dto.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service("allPedidos")
public class GetAllPedidos implements UseCase {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoMapper mapper;

	@Override
	public Map<String, Object> executar(Map<String, Object> dados) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDto> pedidosDto = new ArrayList<PedidoDto>();
		
		for(Pedido p: pedidos) {
			pedidosDto.add(mapper.toDto(p));
		}
		
		retorno.put("list", pedidosDto);
		return retorno;
	}
	
	
}
