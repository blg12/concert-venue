package concert.venue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import concert.venue.controller.model.ConcertData;
import concert.venue.controller.model.TicketData;
import concert.venue.controller.model.VenueData;
import concert.venue.service.ConcertVenueService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/concert_venue")
@Slf4j
public class ConcertVenueController {
	
	@Autowired
	private ConcertVenueService concertVenueService;
	
	//Create/Save the venue
	@PostMapping("/venue/{concertId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public VenueData insertVenue(
	@RequestBody VenueData venueData, @PathVariable Long concertId) {
		log.info("Creating Venue {}", venueData);
		return concertVenueService.saveVenue(concertId,venueData);
}
	//Create/Saving the concert
	@PostMapping("/concert")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ConcertData insertConcert(
	@RequestBody ConcertData concertData) {
	log.info("Creating Concert {}", concertData);
		return concertVenueService.saveConcert(concertData);
	}
	//Create/Save the ticket
	@PostMapping("/ticket")
	@ResponseStatus(code = HttpStatus.CREATED)
	public TicketData insertTicket(
		@RequestBody TicketData ticketData) {
		log.info("Creating Ticket {}", ticketData);
		return concertVenueService.saveTicket(ticketData);
	}
	
	
}

