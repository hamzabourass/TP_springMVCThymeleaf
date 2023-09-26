package ma.spring.clinique.entities;

import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private boolean malade;
	private int score;

}
