package ru.vallball.gym01.service;

import java.util.List;

import ru.vallball.gym01.model.TrainingDay;

public interface DayService {
	
	void save(TrainingDay day);

	List<TrainingDay> list();

	void delete(Long id);

	void update(TrainingDay day);

	TrainingDay findById(Long id);

}
