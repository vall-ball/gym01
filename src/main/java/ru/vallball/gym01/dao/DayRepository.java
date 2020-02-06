package ru.vallball.gym01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.gym01.model.TrainingDay;

public interface DayRepository extends JpaRepository<TrainingDay, Long>{

}
