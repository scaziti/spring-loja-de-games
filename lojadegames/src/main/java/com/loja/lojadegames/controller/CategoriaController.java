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
import com.loja.lojadegames.model.CategoriaLojaDeGames;
import com.loja.lojadegames.repository.CategoriaLojaDeGamesRepository;

@RestController
@RequestMapping("/categorialojadegames")
@CrossOrigin("*")
public class CategoriaController 
{
	@Autowired
	public CategoriaLojaDeGamesRepository categoriaLoja;
	
	@GetMapping
	public ResponseEntity<List<CategoriaLojaDeGames>> GetAll()
	{
		return ResponseEntity.ok(categoriaLoja.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaLojaDeGames> GetById(@PathVariable long id)
	{
		return categoriaLoja.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomeCategoria}")
	public ResponseEntity<List<CategoriaLojaDeGames>> GetByTitulo(@PathVariable String nomeCategoria)
	{
		return ResponseEntity.ok(categoriaLoja.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaLojaDeGames> post(@RequestBody CategoriaLojaDeGames categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoriaLoja.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaLojaDeGames> put(@RequestBody CategoriaLojaDeGames categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(this.categoriaLoja.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		this.categoriaLoja.deleteById(id);
	}
}
