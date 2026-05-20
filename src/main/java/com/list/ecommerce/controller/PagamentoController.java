package com.list.ecommerce.controller;


import com.list.ecommerce.DTOs.response.PagamentoResponse;
import com.list.ecommerce.service.PagamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {


    private final PagamentoService pagamentoService;


    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/buscar/{id}")
    public PagamentoResponse buscarPagamento(@PathVariable Integer id) {
        return pagamentoService.buscarPagamento(id);
    }

}
