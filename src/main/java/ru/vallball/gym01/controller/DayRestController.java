package ru.vallball.gym01.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import ru.vallball.gym01.model.TrainingDay;
import ru.vallball.gym01.service.DayService;


@RestController
@RequestMapping(value = "/days", produces = "application/json;charset=UTF-8")
public class DayRestController {
	
	@Autowired
	DayService dayService;

	@GetMapping
	@ResponseBody
	public List<TrainingDay> list() {
		return dayService.list();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public TrainingDay get(@PathVariable(value = "id") Long id) {
		return dayService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody TrainingDay day) {
		dayService.save(day);
		return new ResponseEntity<>("Тренировочный день создан успешно", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody TrainingDay day) {
		try {
			TrainingDay dayForUpdate = dayService.findById(id);
			dayForUpdate.setBlocks(day.getBlocks());
			dayService.save(dayForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Day not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Day is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			dayService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Day not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Block is deleted successfully", HttpStatus.ACCEPTED);
	}

}
