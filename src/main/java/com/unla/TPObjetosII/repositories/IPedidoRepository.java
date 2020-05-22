package com.unla.TPObjetosII.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.TPObjetosII.entities.Pedido;

@Repository ("pedidoRepository")
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable>{

	public abstract Pedido findByIdPedido(int idPedido);
	
	
	@Query("Select p from Pedido p JOIN FETCH p.producto x JOIN FETCH p.vendedorOriginal o JOIN FETCH o.local LEFT JOIN FETCH p.vendedorAuxiliar a LEFT JOIN FETCH a.local")
	public abstract List<Pedido> findAllConTodo();
}
