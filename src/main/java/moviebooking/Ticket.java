package moviebooking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : alexchen
 * @created : 9/13/20, Sunday
 **/
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Ticket {

    private Movie movie;

    private Show show;

    private Hall hall;

    private Seat seat;

    private int userId;
}
