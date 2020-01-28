package ru.vallball.gym01.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sportsmen")
public class Sportsman {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique=true)
	@Size(min=3, max=30)
	private String name;
	@NotNull
	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "yyyy.MM.dd")
	private LocalDate dateOfBirth;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int height;
	
	private int weight;
	
	

}
