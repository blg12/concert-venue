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
	private String concertGenre;
	private Set <TicketData> tickets = new HashSet<>();
	private Set <VenueData> venues = new HashSet<>();

	
public ConcertData (Concert concert) {
		concertId = concert.getConcertId();
		concertName = concert.getConcertName();
		concertGenre = concert.getConcertGenre();
		
	for(Ticket ticket : concert.getTickets()) {
		tickets.add(new TicketData(ticket));
}
	for(Venue venue : concert.getVenues()) {
		venues.add(new VenueData(venue));
}
}
	}

