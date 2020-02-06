package ru.vallball.gym01.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class WeekSchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sportsman_id")
	private Sportsman sportsman;
	@OneToMany
	@JoinColumn(name = "schedule_id")
	private Set<TrainingDay> days;
	
	public Sportsman getSportsman() {
		return sportsman;
	}
	public void setSportsman(Sportsman sportsman) {
		this.sportsman = sportsman;
	}
	public Set<TrainingDay> getDays() {
		return days;
	}
	public void setDays(Set<TrainingDay> days) {
		this.days = days;
	}
	public Long getId() {
		return id;
	}
	
	
}
