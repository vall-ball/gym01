package ru.vallball.gym01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.gym01.dao.ExerciseRepository;
import ru.vallball.gym01.model.Exercise;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	ExerciseRepository exerciseRepository;
	
	@Override
	public void save(Exercise exercise) {
		exerciseRepository.save(exercise);
		
	}

	@Override
	public List<Exercise> list() {
		return exerciseRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		exerciseRepository.deleteById(id);
		
	}

	@Override
	public void update(Exercise exercise) {
		exerciseRepository.save(exercise);
		
	}

	@Override
	public Exercise findById(Long id) {
		return exerciseRepository.findById(id).get();
	}

}
