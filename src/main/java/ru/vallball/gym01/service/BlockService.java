package ru.vallball.gym01.service;

import java.util.List;

import ru.vallball.gym01.model.Block;

public interface BlockService {
	
	void save(Block block);

	List<Block> list();

	void delete(Long id);

	void update(Block block);

	Block findById(Long id);

}
