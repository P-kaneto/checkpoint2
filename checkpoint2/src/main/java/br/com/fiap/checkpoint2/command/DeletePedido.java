package br.com.fiap.checkpoint2.command;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service("deletePedido")
public class DeletePedido implements UseCase {
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Map<String, Object> executar(Map<String, Object> dados) {
		Map<String, Object> retorno = new HashMap<String, Object>();
		try {
			String idString = String.valueOf(dados.get("id"));
			Long id = Long.parseLong(idString);
			pedidoRepository.deleteById(id);
			retorno.put("stringRetorno", String.format("Pedido %o excluído", id));
		}catch (Exception e) {
			retorno.put("stringRetorno", "Erro ao fazer a exclusão: " + e.getMessage());
		}
		
		return retorno;
	}

}
