package ru.vallball.gym01.model;

import java.time.DayOfWeek;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class TrainingDay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "day_of_week")
	private DayOfWeek dayOfWeek;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="day_block", joinColumns=@JoinColumn(name="day_id"), inverseJoinColumns=@JoinColumn(name="block_id"))  
	private Set<Block> blocks;
	
	public Set<Block> getBlocks() {
		return blocks;
	}
	public void setBlocks(Set<Block> blocks) {
		this.blocks = blocks;
	}
	public Long getId() {
		return id;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
		
}
