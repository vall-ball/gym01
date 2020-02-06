package ru.vallball.gym01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.gym01.dao.BlockRepository;
import ru.vallball.gym01.model.Block;

@Service
@Transactional
public class BlockServiceImpl implements BlockService{
	
	@Autowired
	BlockRepository blockRepository;

	@Override
	public void save(Block block) {
		blockRepository.save(block);
		
	}

	@Override
	public List<Block> list() {
		return blockRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		blockRepository.deleteById(id);
		
	}

	@Override
	public void update(Block block) {
		blockRepository.save(block);		
	}

	@Override
	public Block findById(Long id) {
		return blockRepository.findById(id).get();
	}

}
