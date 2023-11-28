package concert.venue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import concert.venue.entity.Concert;

public interface ConcertDao extends JpaRepository<Concert, Long> {

}
