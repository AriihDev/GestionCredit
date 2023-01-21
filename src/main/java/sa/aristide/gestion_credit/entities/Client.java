package sa.aristide.gestion_credit.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name ="client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Email
	private String mailAddress;
	
	@NotNull
	private String phoneNumber;
	
	@NotBlank
	@Size(min=10)
	@Column(length = 10)
	private String civility;
	
	@NotNull
	@Size(min= 3 , max = 20)
	@Column(length = 20)
	private String fname;
	
	@NotNull
	@Size(min= 3 , max = 20)
	@Column(length = 20)
	private String lname;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dob;
	
	@NotBlank
	private String idNumber;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dateStartActivity;
	
	@NotBlank
	private int monthlyIncome;
	
	private boolean oldClient;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonProperty(access= Access.WRITE_ONLY)
	private List<Simulation> simulations;
}
