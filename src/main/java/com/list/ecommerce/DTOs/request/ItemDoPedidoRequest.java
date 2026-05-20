package com.list.ecommerce.DTOs.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoRequest {


    private Integer idProduto;
    private Integer idCategoria;
    private int quantidade;
}
