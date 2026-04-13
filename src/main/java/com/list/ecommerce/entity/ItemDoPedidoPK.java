package com.list.ecommerce.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ItemDoPedidoPK {

    @ManyToOne
    @JoinColumn(name="id_Pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_Produto")
    private Produto produto;

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }
}
