package ru.vallball.gym01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.gym01.model.Sportsman;
import ru.vallball.gym01.service.SportsmanService;

@RestController
@RequestMapping(value = "/sportsmen", produces = "application/json;charset=UTF-8")
public class SportsmanRestController {

	@Autowired
	SportsmanService sportsmanService;

	@GetMapping
	@ResponseBody
	public List<Sportsman> list() {
		return sportsmanService.list();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Sportsman get(@PathVariable(value = "id") Long id) {
		return sportsmanService.findSportsmanById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createSportsman(@Valid @RequestBody Sportsman sportsman) {
		sportsmanService.save(sportsman);
		return new ResponseEntity<>("Спортсмен создан успешно", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateSportsman(@PathVariable(value = "id") Long id,
			@RequestBody Sportsman sportsman) {
		try {

			Sportsman sportsmanForUpdate = sportsmanService.findSportsmanById(id);
			sportsmanForUpdate.setDateOfBirth(sportsman.getDateOfBirth());
			sportsmanForUpdate.setGender(sportsman.getGender());
			sportsmanForUpdate.setHeight(sportsman.getHeight());
			sportsmanForUpdate.setName(sportsman.getName());
			sportsmanForUpdate.setWeight(sportsman.getWeight());
			sportsmanService.save(sportsmanForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("User is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSportsman(@PathVariable(value = "id") Long id) {
		try {
			sportsmanService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Sportsman not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Sportsman is deleted successfully", HttpStatus.ACCEPTED);
	}
}
