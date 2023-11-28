package concert.venue.controller.model;

import java.util.HashSet;
import java.util.Set;

import concert.venue.entity.Concert;
import concert.venue.entity.Venue;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class VenueData {
		private Long venueId;
		private String venueName;
		private String venueState;
		
		private Concert concert;
		Set <ConcertData> concerts = new HashSet<>();
		
		public VenueData(Venue venue) {
			venueId = venue.getVenueId();
			venueName = venue.getVenueName();
			venueState = venue.getVenueState();
			
		//for(Concert concert : venue.getConcerts());
			//concerts.add(new ConcertData(concerts));
		
		}


}
	
		
