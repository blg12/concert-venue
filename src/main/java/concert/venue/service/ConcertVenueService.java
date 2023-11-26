package concert.venue.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import concert.venue.controller.model.VenueData;
import concert.venue.dao.VenueDao;
import concert.venue.entity.Venue;

@Service
public class ConcertVenueService {

	@Autowired
	private VenueDao venueDao;
	
	@Transactional(readOnly = false)
	public VenueData saveVenue(VenueData venueData) {
		Long venueId = venueData.getVenueId();
		Venue venue = findOrCreateVenue(venueId);
		
		setFieldsInVenue(venue, venueData);
		return new VenueData(venueDao.save(venue));
	}
		
	private void setFieldsInVenue(Venue venue, VenueData venueData) {
		venue.setState(venueData.getState());
		venue.setVenueName(venueData.getVenueName());
	}

	private Venue findOrCreateVenue(Long venueId) {
		Venue venue;
		
		if(Objects.isNull(venueId)) {
			venue = new Venue();
		}
		else {
			venue = findVenueById(venueId); 	
		}
		
		return venue;
		}

	private Venue findVenueById(Long venueId) {
		return venueDao.findById(venueId)
				.orElseThrow(() -> new NoSuchElementException( 
						"Venue with ID=" + venueId + " was not found."));
		
	}
	}


