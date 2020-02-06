package ru.vallball.gym01.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "exercises")
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true)
	@Size(min = 3, max = 300, message = "Не меньше 3, не больше 300")
	private String name;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "exercise_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
	@Column(name = "muscle")
	@Enumerated(EnumType.STRING)
	private Set<Muscle> muscles ;//= new HashSet<>()
	@NotNull
	@Enumerated(EnumType.STRING)
	private Trainer trainer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Muscle> getMuscles() {
		return muscles;
	}

	public void setMuscles(Set<Muscle> muscles) {
		this.muscles = muscles;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", muscles=" + muscles + ", trainer=" + trainer + "]";
	}
	
	
}
