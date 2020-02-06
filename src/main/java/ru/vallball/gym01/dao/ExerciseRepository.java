package ru.vallball.gym01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.gym01.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
