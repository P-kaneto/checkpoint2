package br.com.fiap.checkpoint2.dto;

import java.math.BigDecimal;

public class PedidoDto {
	private String dataPedido;
	private Long codigoCliente;
	private String dataCadastro;
	private BigDecimal valorTotal;
	
	public String getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
