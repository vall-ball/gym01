package ru.vallball.gym01.service;

import java.util.List;

import ru.vallball.gym01.model.Exercise;

public interface ExerciseService {
	
	void save(Exercise exercise);

	List<Exercise> list();

	void delete(Long id);

	void update(Exercise exercise);

	Exercise findById(Long id);

}
