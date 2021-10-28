import core.Line;
import core.Station;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    List<Station> route;

    @Override
    protected void setUp() throws Exception {
        routeCalculator = getRouteCalculator();
        route = getRoute();
    }

    private List<Station> getRoute() {
        List<Station> route = new ArrayList<>();

        Line line1 = new Line(1, "Линия 1");
        Line line2 = new Line(2, "Линия 2");
        route.add(new Station("Станция 1.1", line1));
        route.add(new Station("Станция 1.2", line1));
        route.add(new Station("Станция 2.1", line2));
        route.add(new Station("Станция 2.2", line2));

        return route;
    }

    private RouteCalculator getRouteCalculator() {
        stationIndex = new StationIndex();
        Line line1 = new Line(1, "Линия 1");
        Line line2 = new Line(2, "Линия 2");
        Line line3 = new Line(3, "Линия 3");
        Station station11 = new Station("Станция 1.1", line1);
        Station station12 = new Station("Станция 1.2", line1);
        Station station13 = new Station("Станция 1.3", line1);
        Station station21 = new Station("Станция 2.1", line2);
        Station station22 = new Station("Станция 2.2", line2);
        Station station23 = new Station("Станция 2.3", line2);
        Station station31 = new Station("Станция 3.1", line3);
        Station station32 = new Station("Станция 3.2", line3);
        Station station33 = new Station("Станция 3.3", line3);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
        stationIndex.addStation(station33);
        List<Station> connection1 = new ArrayList<>();
        connection1.add(station12);
        connection1.add(station31);
        stationIndex.addConnection(connection1);
        List<Station> connection2 = new ArrayList<>();
        connection2.add(station22);
        connection2.add(station32);
        stationIndex.addConnection(connection2);

        return new RouteCalculator(stationIndex);
    }

    public void testGetRouteOnTheLine() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Станция 1.1"));
        expected.add(stationIndex.getStation("Станция 1.2"));
        expected.add(stationIndex.getStation("Станция 1.3"));

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Станция 1.1"),
                stationIndex.getStation("Станция 1.3"));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Станция 1.1"));
        expected.add(stationIndex.getStation("Станция 1.2"));
        expected.add(stationIndex.getStation("Станция 3.1"));
        expected.add(stationIndex.getStation("Станция 3.2"));
        expected.add(stationIndex.getStation("Станция 3.3"));

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Станция 1.1"),
                stationIndex.getStation("Станция 3.3"));

        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> expected = new ArrayList<>();
        expected.add(stationIndex.getStation("Станция 1.1"));
        expected.add(stationIndex.getStation("Станция 1.2"));
        expected.add(stationIndex.getStation("Станция 3.1"));
        expected.add(stationIndex.getStation("Станция 3.2"));
        expected.add(stationIndex.getStation("Станция 2.2"));
        expected.add(stationIndex.getStation("Станция 2.1"));

        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Станция 1.1"),
                stationIndex.getStation("Станция 2.1"));

        assertEquals(expected, actual);
    }

    public void testCalculateDuration() {
        double expected = 8.5;
        double actual = RouteCalculator.calculateDuration(route);
        assertEquals(expected, actual);
    }
}