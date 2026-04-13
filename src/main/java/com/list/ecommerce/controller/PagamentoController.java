package com.list.ecommerce.controller;


import com.list.ecommerce.DTOs.PagamentoRequest;
import com.list.ecommerce.DTOs.PagamentoResponse;
import com.list.ecommerce.service.PagamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Pagamento")
public class PagamentoController {


    private final PagamentoService pagamentoService;


    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    public PagamentoResponse buscarPagamento(@PathVariable Integer id) {
        return pagamentoService.buscarPagamento(id);
    }

}
