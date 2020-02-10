package ru.vallball.gym01.controller;

import java.io.IOException;
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
import ru.vallball.gym01.model.WeekSchedule;
import ru.vallball.gym01.service.DayService;
import ru.vallball.gym01.service.ScheduleService;
import ru.vallball.gym01.utils.ExcelUtil;

@RestController
@RequestMapping(value = "/weeks", produces = "application/json;charset=UTF-8")
public class ScheduleRestController {
	
	@Autowired
	ScheduleService scheduleService;

	@GetMapping
	@ResponseBody
	public List<WeekSchedule> list() {
		return scheduleService.list();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public WeekSchedule get(@PathVariable(value = "id") Long id) {
		return scheduleService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody WeekSchedule week) {
		scheduleService.save(week);
		return new ResponseEntity<>("Расписание создано успешно", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody WeekSchedule week) {
		try {
			WeekSchedule weekForUpdate = scheduleService.findById(id);
			weekForUpdate.setDays(week.getDays());
			weekForUpdate.setSportsman(week.getSportsman());
			scheduleService.save(weekForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Week not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Week is updated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			scheduleService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("Week not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Week is deleted successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/prog/{id}")
	public ResponseEntity<Object> createFile(@PathVariable(value = "id") Long id){
		WeekSchedule week = scheduleService.findById(id);
		ExcelUtil util = new ExcelUtil();
		try {
			util.writeData(week);
			return new ResponseEntity<>("Your schedule is ready", HttpStatus.ACCEPTED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("WTF!!!", HttpStatus.BAD_REQUEST);
		}
		
	}
}

