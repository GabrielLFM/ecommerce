package com.list.ecommerce.repository;

import com.list.ecommerce.entity.ItemDoPedido;
import com.list.ecommerce.entity.ItemDoPedidoPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK> {

    ItemDoPedidoPK id(ItemDoPedidoPK id);
}
