package concert.venue.controller.model;

import concert.venue.entity.Venue;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class VenueData {
		private Long venueId;
		private String venueName;
		private String venueState;
		
		
		public VenueData(Venue venue) {
			venueId = venue.getVenueId();
			venueName = venue.getVenueName();
			venueState = venue.getVenueState();
			
		
		}


}
	
		
