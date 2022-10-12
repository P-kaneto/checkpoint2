package br.com.fiap.checkpoint2.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import br.com.fiap.checkpoint2.model.Pedido;

@Component
public class PedidoMapper {
	ZoneId zone = ZoneId.of("America/Sao_Paulo");
	
	public Pedido toPedido(PedidoDto dto) {
		Pedido pedido = new Pedido();
		pedido.setCodigoCliente(dto.getCodigoCliente());
		pedido.setDataCadastro(this.stringToInstant(dto.getDataCadastro()));
		pedido.setDataPedido(this.stringToInstant(dto.getDataPedido()));
		pedido.setValorTotal(dto.getValorTotal());
		
		return pedido;
	}
	
	public Pedido toPedidoUpdate(PedidoDto dto, Pedido pedido) {
		if (dto.getCodigoCliente() != null){
			pedido.setCodigoCliente(dto.getCodigoCliente());
		}
		if (dto.getDataCadastro() != null){
			pedido.setDataCadastro(this.stringToInstant(dto.getDataCadastro()));
		}
		if (dto.getDataPedido() != null){
			pedido.setDataPedido(this.stringToInstant(dto.getDataPedido()));
		}
		if (dto.getValorTotal() != null){
			pedido.setValorTotal(dto.getValorTotal());
		}
		
		return pedido;
	}
	
	public PedidoDto toDto(Pedido pedido) {
		PedidoDto dto = new PedidoDto();
		dto.setCodigoCliente(pedido.getCodigoCliente());
		dto.setDataCadastro(this.instantToString(pedido.getDataCadastro()));
		dto.setDataPedido(this.instantToString(pedido.getDataPedido()));
		dto.setValorTotal(pedido.getValorTotal());
		
		return dto;
	}
	
	public String instantToString(Instant date) {
		String brazilianPattern = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(brazilianPattern).withZone(zone);
		String dateFromatted = formatter.format(date);
		return dateFromatted;
	}
	
	public Instant stringToInstant(String dateString) {
		String[] splitDate = dateString.split("/");
		dateString = splitDate[2] + "-" + splitDate[1] + "-" + splitDate[0];
		String instantPattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(instantPattern);
		LocalDateTime ldt = LocalDate.parse(dateString, formatter).atStartOfDay();
		ZonedDateTime zdt = ldt.atZone(zone);
		Instant date = zdt.toInstant();
		return date;
	}
}
