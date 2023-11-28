package concert.venue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import concert.venue.entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long> {

}
