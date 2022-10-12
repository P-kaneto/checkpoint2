package br.com.fiap.checkpoint2.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="data_pedido")
	private Instant dataPedido;
	
	@Column(name="codigo_cliente", nullable=false)
	private Long codigoCliente;
	
	@Column(name="data_cadastro")
	private Instant dataCadastro;
	
	@Column(name="valor_total", nullable=false)
	private BigDecimal valorTotal;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
