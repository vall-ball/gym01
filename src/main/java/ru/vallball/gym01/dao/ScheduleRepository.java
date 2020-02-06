package ru.vallball.gym01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.gym01.model.WeekSchedule;

public interface ScheduleRepository extends JpaRepository<WeekSchedule, Long>{

}
