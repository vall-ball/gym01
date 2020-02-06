package ru.vallball.gym01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.gym01.model.Sportsman;

public interface SportsmanRepository extends JpaRepository<Sportsman, Long>{

}
