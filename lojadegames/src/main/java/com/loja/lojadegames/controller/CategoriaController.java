package com.loja.lojadegames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.loja.lojadegames.model.CategoriaLojaDeGames;
import com.loja.lojadegames.repository.CategoriaLojaDeGamesRepository;

@RestController
@RequestMapping("/categoria")
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
}
