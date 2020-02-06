package ru.vallball.gym01.service;

import java.util.List;

import ru.vallball.gym01.model.Sportsman;

public interface SportsmanService {
	
	void save(Sportsman sportsman);

	List<Sportsman> list();

	void delete(Long id);

	void update(Sportsman sportsman);

	Sportsman findSportsmanById(Long id);

}
