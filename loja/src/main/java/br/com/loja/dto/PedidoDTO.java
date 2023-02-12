package br.com.loja.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.loja.model.ItemPedido;
import br.com.loja.model.Pedido;
import br.com.loja.model.TipoPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {
	
private Long id;
	
	private LocalDateTime data;
	private BigDecimal valorTotal;
	private List<ItemPedido> itens;
	private TipoPagamento pagamento;
	
	public static PedidoDTO of(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setData(pedido.getData());
		pedidoDTO.setItens(pedido.getItens());
		pedidoDTO.setValorTotal(pedido.getValorTotal());
		pedidoDTO.setPagamento(pedido.getPagamento());
		
		return pedidoDTO;
	}

}
