package ru.vallball.gym01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.gym01.dao.SportsmanRepository;
import ru.vallball.gym01.model.Sportsman;

@Service
@Transactional
public class SportsmanServiceImpl implements SportsmanService {

	@Autowired
	SportsmanRepository sportsmanRepository;

	@Override
	public void save(Sportsman sportsman) {
		sportsmanRepository.save(sportsman);
	}

	@Override
	public List<Sportsman> list() {
		return sportsmanRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		sportsmanRepository.deleteById(id);
	}

	@Override
	public void update(Sportsman sportsman) {
		sportsmanRepository.save(sportsman);
	}

	@Override
	public Sportsman findSportsmanById(Long id) {
		return sportsmanRepository.findById(id).get();
	}

}
