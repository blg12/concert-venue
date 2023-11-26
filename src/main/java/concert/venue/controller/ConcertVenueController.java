package concert.venue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import concert.venue.controller.model.VenueData;
import concert.venue.service.ConcertVenueService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/concert_venue")
@Slf4j
public class ConcertVenueController {
	
	@Autowired
	private ConcertVenueService concertVenueService;
	
	//@PostMapping("/venue")
	//public VenueData insertVenue(
	//		@RequestBody VenueData venueData) {
	//	log.info("Creating Venue {}", venueData);
//	}

}
