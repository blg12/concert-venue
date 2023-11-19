package concert.venue.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	private Long concertId;
	private BigDecimal seatNumber;
	private BigDecimal ticketPrice;
	
@EqualsAndHashCode.Exclude
@ToString.Exclude
@OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
private Concert concert;


}
