package com.loja.lojadegames.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoLojaDeGames> GetByID(@PathVariable long id)
	{
		return this.produto.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ProdutoLojaDeGames> post(@RequestBody ProdutoLojaDeGames produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.produto.save(produto));
	}
	

	@PutMapping
	public ResponseEntity<ProdutoLojaDeGames> put(@RequestBody ProdutoLojaDeGames produto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.produto.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		this.produto.deleteById(id);
	}
}
