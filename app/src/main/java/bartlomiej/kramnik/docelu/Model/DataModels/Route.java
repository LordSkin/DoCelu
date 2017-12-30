package bartlomiej.kramnik.docelu.Model.DataModels;

import java.io.Serializable;
import java.util.List;

/**
 * Data model represents single route
 */

public class Route implements Serializable {
    private List<Line> lineList;

    public Route(List<Line> stops) {
        this.lineList = stops;
    }

    public List<Line> getLineList() {
        return lineList;
    }

    public int getLinesCount(){
        return lineList.size();
    }

    public Line getFirst(){
        return lineList.get(0);
    }

    public Line getLast(){
        return lineList.get(lineList.size()-1);
    }
}
