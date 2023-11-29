package concert.venue.service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import concert.venue.controller.model.ConcertData;
import concert.venue.controller.model.TicketData;
import concert.venue.controller.model.VenueData;
import concert.venue.dao.ConcertDao;
import concert.venue.dao.TicketDao;
import concert.venue.dao.VenueDao;
import concert.venue.entity.Concert;
import concert.venue.entity.Ticket;
import concert.venue.entity.Venue;

@Service
public class ConcertVenueService {

	@Autowired
	private VenueDao venueDao;
	
	@Autowired
	private ConcertDao concertDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	//Create Venue
	@Transactional(readOnly = false)
	public VenueData saveVenue(Long concertId, VenueData venueData) {
		Concert concert = findConcertById(concertId);
		Venue venue = findOrCreateVenue(venueData.getVenueId(),concertId);
		setFieldsInVenue(venue, venueData);
		venue.getConcerts().add(concert);
		concert.getVenues().add(venue);
		Venue savedVenue = venueDao.save(venue);
		return new VenueData(savedVenue);
		
	}
		
	private void setFieldsInVenue(Venue venue, VenueData venueData) {
		venue.setVenueId(venueData.getVenueId());
		venue.setVenueState(venueData.getVenueState());
		venue.setVenueName(venueData.getVenueName());
	}
	//Retrieve - Get Venue
	private Venue findOrCreateVenue(Long venueId, Long concertId) {
		Venue venue;
		
		if(Objects.isNull(venueId)) {
			
		return new Venue();
			}
		return findVenueById(venueId, concertId);
		}

	private Venue findVenueById(Long venueId) {
		return venueDao.findById(venueId)
				.orElseThrow(() -> new NoSuchElementException( 
						"Venue with ID=" + venueId + " was not found."));
		
	}

	public ConcertData saveConcert(ConcertData concertData) {
		Concert concert = findOrCreateConcert(concertData.getConcertId());
		setFieldsInConcert(concert, concertData); 
		Concert savedConcert = concertDao.save(concert);
		return new ConcertData(savedConcert);
	}

	private void setFieldsInConcert(Concert concert, ConcertData concertData) {
		concert.setConcertId(concertData.getConcertId());
		concert.setConcertName(concertData.getConcertName());
		concert.setConcertGenre(concertData.getConcertGenre());
	}
	
	private Concert findOrCreateConcert(Long concertId) {
		Concert concert;
		
		if(Objects.isNull(concertId)) {
			concert = new Concert();
		} else {
			concert = findConcertById(concertId);
		}
		return concert;
	}

	private Concert findConcertById(Long concertId) {
		return concertDao.findById(concertId)
				.orElseThrow(() -> new NoSuchElementException("Concert with ID=" + concertId + "was not found."));
	}

	public TicketData saveTicket(TicketData ticketData) {
		Ticket ticket = findOrCreateTicket(ticketData.getTicketId());
		setFieldsInTicket(ticket, ticketData);
		Ticket savedTicket = ticketDao.save(ticket);
		return new TicketData(savedTicket);
	}

	private void setFieldsInTicket(Ticket ticket, TicketData ticketData) {
		ticket.setTicketId(ticketData.getTicketId());
		ticket.setSeatNumber(ticketData.getSeatNumber());
		ticket.setTicketPrice(ticketData.getTicketPrice());
	}

	private Ticket findOrCreateTicket(Long ticketId) {
		Ticket ticket;
		
		if(Objects.isNull(ticketId)) {
			ticket = new Ticket();
		} else {
			ticket = findTicketById(ticketId);
		}
		return ticket;
	}

	private Ticket findTicketById(Long ticketId, Long concertId) {
		Ticket ticket = ticketDao.findById(ticketId).orElseThrow(() -> NoSuchElementException("Ticket with ID= " + ticketId + " was not found."));
		
		if(ticket.getConcert().getConcertId() == concertId) {
			return ticket;
		} else {
			throw new IllegalArgumentException("Please enter correct data in the appropriate format");
		}
	}
}


