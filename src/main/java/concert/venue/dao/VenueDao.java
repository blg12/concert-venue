package concert.venue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import concert.venue.entity.Venue;

public interface VenueDao extends JpaRepository<Venue, Long> {

}
