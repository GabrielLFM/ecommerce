package com.list.ecommerce.DTOs;

import com.list.ecommerce.entity.StatusDoPedido;

import java.time.Instant;

public class PedidoResponse {

    private long idPedido;
    private Instant MomentoPedido;
    private StatusDoPedido Status;
}
