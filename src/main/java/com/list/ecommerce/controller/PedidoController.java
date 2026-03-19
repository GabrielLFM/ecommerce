package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.PedidoResponse;
import com.list.ecommerce.service.PedidoService;
import org.springframework.stereotype.Controller;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


}
