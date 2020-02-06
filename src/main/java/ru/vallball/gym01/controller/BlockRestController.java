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

import ru.vallball.gym01.model.Block;
import ru.vallball.gym01.service.BlockService;

@RestController
@RequestMapping(value = "/blocks", produces = "application/json;charset=UTF-8")
public class BlockRestController {

	@Autowired
	BlockService blockService;

	@GetMapping
	@ResponseBody
	public List<Block> list() {
		return blockService.list();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Block get(@PathVariable(value = "id") Long id) {
		return blockService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Block block) {
		blockService.save(block);
		return new ResponseEntity<>("Сет создан успешно", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Block block) {
		try {

			Block blockForUpdate = blockService.findById(id);
			blockForUpdate.setApproaches(block.getApproaches());
			blockForUpdate.setExercise(block.getExercise());
			blockForUpdate.setNumbers(block.getNumbers());
			blockForUpdate.setWeight(block.getWeight());
			blockService.save(blockForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Exercise not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Exercise is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteSportsman(@PathVariable(value = "id") Long id) {
		try {
			blockService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Block not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Block is deleted successfully", HttpStatus.ACCEPTED);
	}

}
