package sa.aristide.gestion_credit.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name ="simulation")
public class Simulation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String job;
	
	@NotBlank
	private double amount; 
	
	@NotBlank
	private int duration;
	
	@NotBlank
	private double monthlyPayment;
	
	@NotNull
	@Size(min=10)
	@Column(length = 10)
	private String reference;
	
	@NotNull
	private String status;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client client;

}
