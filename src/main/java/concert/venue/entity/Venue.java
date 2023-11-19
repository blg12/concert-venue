package concert.venue.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Venue {
	private Long venueId;
	private String venueName;
	private String state;
	
	Set <ConcertVenue> concertVenue = new HashSet<>();
}
