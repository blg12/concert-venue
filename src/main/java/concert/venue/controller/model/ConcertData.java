package concert.venue.controller.model;

import java.util.HashSet;
import java.util.Set;

import concert.venue.entity.Concert;
import concert.venue.entity.Ticket;
import concert.venue.entity.Venue;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConcertData {
	private Long concertId;
	private String concertName;
	private String genre;
	private Set <Ticket> tickets = new HashSet<>();
	private Set <Venue> venues = new HashSet<>();

	Concert(Concert concert) {
		concertId = concert.getConcertId();
		concertName = concert.getConcertName();
		genre = concert.getGenre();
		
		}
	
}
