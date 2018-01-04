package bartlomiej.kramnik.docelu.Model.DataModels;

import java.io.Serializable;
import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Line;
import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Transport;

/**
 * Data model represents single route
 */

public class Route implements Serializable {
    private List<Transport> lineList;

    public Route(List<Transport> stops) {
        this.lineList = stops;
    }

    public List<Transport> getLineList() {
        return lineList;
    }

    public int getLinesCount(){
        return lineList.size();
    }

    public Transport getFirst(){
        return lineList.get(0);
    }

    public Transport getLast(){
        return lineList.get(lineList.size()-1);
    }
}
