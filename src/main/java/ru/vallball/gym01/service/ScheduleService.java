package ru.vallball.gym01.service;

import java.util.List;

import ru.vallball.gym01.model.WeekSchedule;

public interface ScheduleService {
	
	void save(WeekSchedule schedule);

	List<WeekSchedule> list();

	void delete(Long id);

	void update(WeekSchedule schedule);

	WeekSchedule findById(Long id);

}
