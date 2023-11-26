package concert.venue.controller.model;

import java.math.BigDecimal;

import concert.venue.entity.Concert;
import lombok.Data;


@Data
public class TicketData {
	private Long ticketId;
	private Long concertId;
	private BigDecimal seatNumber;
	private BigDecimal ticketPrice;


	private Concert concert;
}
