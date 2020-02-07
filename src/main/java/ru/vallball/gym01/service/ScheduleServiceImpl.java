package ru.vallball.gym01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.gym01.dao.ScheduleRepository;
import ru.vallball.gym01.model.WeekSchedule;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public void save(WeekSchedule schedule) {
		scheduleRepository.save(schedule);		
	}

	@Override
	public List<WeekSchedule> list() {
		return scheduleRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		scheduleRepository.deleteById(id);		
	}

	@Override
	public void update(WeekSchedule schedule) {
		scheduleRepository.save(schedule);
	}

	@Override
	public WeekSchedule findById(Long id) {
		return scheduleRepository.findById(id).get();
	}

}
