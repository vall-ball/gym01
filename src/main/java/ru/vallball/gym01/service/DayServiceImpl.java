package ru.vallball.gym01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.gym01.dao.DayRepository;
import ru.vallball.gym01.model.TrainingDay;

@Service
@Transactional
public class DayServiceImpl implements DayService{
	
	@Autowired
	DayRepository dayRepository;

	@Override
	public void save(TrainingDay day) {
		dayRepository.save(day);
		
	}

	@Override
	public List<TrainingDay> list() {
		return dayRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		dayRepository.deleteById(id);	
	}

	@Override
	public void update(TrainingDay day) {
		dayRepository.save(day);
	}

	@Override
	public TrainingDay findById(Long id) {
		return dayRepository.findById(id).get();
	}

}
