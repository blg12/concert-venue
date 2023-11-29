package concert.venue.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	//Retrieve the venues
	@GetMapping("/venue")
	public List <VenueData> retrieveAllVenues(){
		log.info("Retreive all venues.");
		return concertVenueService.retrieveAllVenues();
	}
	//Retrieve the concert by ID
	@GetMapping("/concert/{concertId}")
	public ConcertData retrieveConcertById(@PathVariable Long concertId) {
		log.info("Retrieving concert with ID={}", concertId);
		return concertVenueService.retrieveConcertById(concertId);
	}
	//Update the concert
	@PutMapping("concert/")
	public ConcertData updateConcert (@PathVariable Long concertId, 
			@RequestBody ConcertData concertData) {
		concertData.setConcertId(concertId);
		log.info("Updating concert {} ", concertData);
		return concertVenueService.saveConcert(concertData);
	}
	//Delete all concerts
	@DeleteMapping("/concert")
	public void deleteAllConcerts() {
		throw new UnsupportedOperationException(
				"Deleting all concerts is not allowed.");
	}
	//Delete all venues
	@DeleteMapping("/venue")
	public void deleteAllVenues() {
		throw new UnsupportedOperationException(
				"Deleting all venues is not allowed.");
	}
	//Delete concert by ID
	@DeleteMapping("/concert/{concertId}")
	public Map<String, String> deleteConcertById(
			@PathVariable Long concertId) {
		log.info("Deleting concert with ID={}", concertId);
		concertVenueService.deleteConcertById(concertId);
		return Map.of("message", 
				"Deletion of concert with ID=" + concertId + "was successful.");
}

}
