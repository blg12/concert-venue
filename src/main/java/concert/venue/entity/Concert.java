package concert.venue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Concert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long concertId;
	private String concertName;
	private String genre;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
	private Ticket ticket;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "concert_venue", 
		joinColumns = @JoinColumn(name = "venueId"),
		inverseJoinColumns = @JoinColumn(name = "concertId"))
	private Set <Venue> venues = new HashSet<>();

}
