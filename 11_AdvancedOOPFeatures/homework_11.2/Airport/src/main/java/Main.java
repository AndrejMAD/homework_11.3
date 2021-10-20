import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);

        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> flights = new ArrayList<>();
        Date now = new Date();
        Date nowPlus2Hours = new Date(System.currentTimeMillis() + 2 * 3600000);

        List<Terminal> terminals = airport.getTerminals();
        for (Terminal terminal : terminals) {
            flights.addAll(terminal.getFlights());
        }

        Stream<Flight> stream = flights.stream()
                .filter(f -> f.getType() == Flight.Type.DEPARTURE)
                .filter(f -> f.getDate().after(now) && f.getDate().before(nowPlus2Hours));

        return stream.collect(Collectors.toList());
    }
}