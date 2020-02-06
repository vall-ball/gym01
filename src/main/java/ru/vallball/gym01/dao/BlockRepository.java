package ru.vallball.gym01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.gym01.model.Block;

public interface BlockRepository extends JpaRepository<Block, Long>{

}
