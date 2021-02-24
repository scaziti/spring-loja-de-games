package com.loja.lojadegames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.loja.lojadegames.model.CategoriaLojaDeGames;

public interface CategoriaLojaDeGamesRepository extends JpaRepository<CategoriaLojaDeGames, Long>
{
	public List<CategoriaLojaDeGames> findAllByNomeCategoriaContainingIgnoreCase(String nomeCategoria);
}
