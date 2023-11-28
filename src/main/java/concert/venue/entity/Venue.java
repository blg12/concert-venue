package concert.venue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venueId;
	private String venueName;
	private String venueState;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "venues", cascade = CascadeType.PERSIST)
	Set <Concert> concerts = new HashSet<>();
}

