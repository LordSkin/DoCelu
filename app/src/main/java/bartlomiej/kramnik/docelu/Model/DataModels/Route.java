package bartlomiej.kramnik.docelu.Model.DataModels;

import java.util.List;

/**
 * Data model represents single route
 */

public class Route {
    private List<BusStop> stops;

    public Route(List<BusStop> stops) {
        this.stops = stops;
    }

    public List<BusStop> getStops() {
        return stops;
    }

    public BusStop getFirst(){
        return stops.get(0);
    }

    public BusStop getLast(){
        return stops.get(stops.size()-1);
    }
}
