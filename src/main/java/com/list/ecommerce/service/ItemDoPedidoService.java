package com.list.ecommerce.service;

import com.list.ecommerce.DTOs.ItemDoPedidoRequest;
import com.list.ecommerce.DTOs.ItemDoPedidoResponse;
import com.list.ecommerce.entity.ItemDoPedido;
import com.list.ecommerce.entity.ItemDoPedidoPK;
import com.list.ecommerce.entity.Pedido;
import com.list.ecommerce.entity.Produto;
import com.list.ecommerce.repository.ItemDoPedidoRepository;
import com.list.ecommerce.repository.PedidoRepository;
import com.list.ecommerce.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDoPedidoService {

    private final ItemDoPedidoRepository itemRepository;
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;

    public ItemDoPedidoService(ItemDoPedidoRepository itemRepository,
                               PedidoRepository pedidoRepository,
                               ProdutoRepository produtoRepository) {
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }


    public ItemDoPedidoResponse criarItem(Integer pedidoId, Integer produtoId, ItemDoPedidoRequest request) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));


        ItemDoPedidoPK pk = new ItemDoPedidoPK(pedido, produto);
        if (itemRepository.existsById(pk)) {
            throw new RuntimeException("Item já existe no pedido");
        }

        ItemDoPedido item = new ItemDoPedido(
                pedido,
                produto,
                produto.getPreco(),
                request.getQuantidade()
        );

        itemRepository.save(item);

        return new ItemDoPedidoResponse(
                item.getId(),
                produto.getNomeProduto(),
                item.getQuantidade(),
                item.getPreco()
        );
    }


    public ItemDoPedidoResponse buscarPorId(Integer pedidoId, Integer produtoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemDoPedidoPK pk = new ItemDoPedidoPK(pedido, produto);

        ItemDoPedido item = itemRepository.findById(pk)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        return new ItemDoPedidoResponse(
                item.getId(),
                item.getProduto().getNomeProduto(),
                item.getQuantidade(),
                item.getPreco()
        );
    }


    public List<ItemDoPedidoResponse> listarItensDoPedido(Integer pedidoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        List<ItemDoPedido> itens = pedido.getItens();

        return itens.stream().map(item ->
                new ItemDoPedidoResponse(
                        item.getId(),
                        item.getProduto().getNomeProduto(),
                        item.getQuantidade(),
                        item.getPreco()
                )
        ).toList();
    }

    public void removerItem(Integer pedidoId, Integer produtoId) {

        Pedido pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemDoPedidoPK pk = new ItemDoPedidoPK(pedido, produto);

        ItemDoPedido item = itemRepository.findById(pk)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        itemRepository.delete(item);
    }
}
