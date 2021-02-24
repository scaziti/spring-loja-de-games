package com.loja.lojadegames.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.lojadegames.model.ProdutoLojaDeGames;
import com.loja.lojadegames.repository.ProdutosLojaDeGamesRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController 
{
	@Autowired
	public ProdutosLojaDeGamesRepository produto;
	
	@GetMapping
	public ResponseEntity<List<ProdutoLojaDeGames>> GetAll()
	{
		return ResponseEntity.ok(this.produto.findAll());
	}
}
