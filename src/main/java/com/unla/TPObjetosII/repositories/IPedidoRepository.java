package com.unla.TPObjetosII.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Pedido;

@Repository ("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable>{

	public abstract Pedido findByIdPedido(int idPedido);
}
