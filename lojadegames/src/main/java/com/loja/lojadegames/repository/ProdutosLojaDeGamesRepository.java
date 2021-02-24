package com.loja.lojadegames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.lojadegames.model.ProdutoLojaDeGames;

public interface ProdutosLojaDeGamesRepository extends JpaRepository<ProdutoLojaDeGames, Long>
{
	public List<ProdutoLojaDeGames> findAllByDescricaoContainingIgnoreCase(String descricao);
}
