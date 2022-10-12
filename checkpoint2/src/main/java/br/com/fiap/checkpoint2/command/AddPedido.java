package br.com.fiap.checkpoint2.command;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.PedidoDto;
import br.com.fiap.checkpoint2.dto.PedidoMapper;
import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service("addPedido")
public class AddPedido implements UseCase {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoMapper mapper;

	@Override
	public Map<String, Object> executar(Map<String, Object> dados) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			PedidoDto dto = (PedidoDto) dados.get("pedidoDto");
			dto.setDataCadastro(mapper.instantToString(Instant.now().minus(Duration.ofDays(1))));
			dto.setDataPedido(mapper.instantToString(Instant.now()));
			Pedido pedido = (Pedido) mapper.toPedido(dto);
			pedidoRepository.save(pedido);
			retorno.put("stringRetorno",
					String.format("Pedido com o valor total de R$ %f do cliente %o cadastrado",
							pedido.getValorTotal(), pedido.getCodigoCliente()));
		}catch (Exception e) {
			retorno.put("stringRetorno", "Erro ao criar pedido: " + e.getMessage());
		}
	
		return retorno;
	}

}
