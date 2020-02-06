package ru.vallball.gym01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import ru.vallball.gym01.model.Exercise;
import ru.vallball.gym01.service.ExerciseService;

@RestController
@RequestMapping(value = "/exercises", produces = "application/json;charset=UTF-8")
public class ExerciseRestController {

	@Autowired
	ExerciseService exerciseService;

	private static final Logger logger = LoggerFactory.getLogger(ExerciseRestController.class);

	@GetMapping
	@ResponseBody
	public List<Exercise> list() {
		return exerciseService.list();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Exercise get(@PathVariable(value = "id") Long id) {
		return exerciseService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Exercise exercise) {
		System.out.println("ResponseEntity<Object> create");
		logger.info(exercise.toString());
		System.out.println(exercise);
		exerciseService.save(exercise);
		return new ResponseEntity<>("Упражнение создано успешно", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Exercise exercise) {
		try {

			Exercise exerciseForUpdate = exerciseService.findById(id);
			exerciseForUpdate.setMuscles(exercise.getMuscles());
			exerciseForUpdate.setName(exercise.getName());
			exerciseForUpdate.setTrainer(exercise.getTrainer());
			exerciseService.save(exerciseForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Exercise not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Exercise is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSportsman(@PathVariable(value = "id") Long id) {
		try {
			exerciseService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Exercise not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Exercise is deleted successfully", HttpStatus.ACCEPTED);
	}

}
