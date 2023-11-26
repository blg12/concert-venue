package concert.venue.controller.model;

import java.util.HashSet;
import java.util.Set;

import concert.venue.entity.Concert;
import lombok.Data;


@Data
public class VenueData {
		private Long venueId;
		private String venueName;
		private String state;
		Set <Concert> concerts = new HashSet<>();
		
	
}

