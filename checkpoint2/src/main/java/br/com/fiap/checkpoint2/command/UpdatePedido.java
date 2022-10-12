package br.com.fiap.checkpoint2.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.PedidoDto;
import br.com.fiap.checkpoint2.dto.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service("updatePedido")
public class UpdatePedido implements UseCase {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoMapper mapper;

	@Override
	public Map<String, Object> executar(Map<String, Object> dados) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			String idString = String.valueOf(dados.get("id"));
			Long id = Long.parseLong(idString);
			
			Optional<Pedido> canBeNullPedido = pedidoRepository.findById(id);
			Pedido pedido = canBeNullPedido.get();
			pedido = mapper.toPedidoUpdate((PedidoDto) dados.get("pedidoDto"), pedido);
			pedidoRepository.save(pedido);
			retorno.put("stringRetorno", String.format("Pedido %o atualizado", id));
			
		}catch (Exception e) {
			retorno.put("stringRetorno", "Erro ao editar pedido: " + e.getMessage());
		}
		
		return retorno;
	}

}
