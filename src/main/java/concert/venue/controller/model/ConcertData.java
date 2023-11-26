package concert.venue.controller.model;

import java.util.HashSet;
import java.util.Set;

import concert.venue.entity.Ticket;
import concert.venue.entity.Venue;
import lombok.Data;

@Data
public class ConcertData {
	private Long concertId;
	private String concertName;
	private String genre;
	private Set <Ticket> tickets = new HashSet<>();
	private Set <Venue> venues = new HashSet<>();

}
