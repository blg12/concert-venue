package concert.venue.controller.model;

import java.math.BigDecimal;

import concert.venue.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TicketData {
	private Long ticketId;
	private Long concertId;
	private BigDecimal seatNumber;
	private BigDecimal ticketPrice;
	
	public TicketData(Ticket ticket) {
		ticketId = ticket.getTicketId();
		seatNumber = ticket.getSeatNumber();
		ticketPrice = ticket.getTicketPrice();
	

}
}
