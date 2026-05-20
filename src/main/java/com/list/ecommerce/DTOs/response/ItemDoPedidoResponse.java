package com.list.ecommerce.DTOs.response;

import com.list.ecommerce.entity.ItemDoPedido;
import com.list.ecommerce.entity.ItemDoPedidoPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemDoPedidoResponse {

    private Integer quantidade;
    private ItemDoPedido itemDoPedido;

    public ItemDoPedidoResponse(ItemDoPedidoPK id, String nomeProduto, Integer quantidade, Double preco) {
    }
}
