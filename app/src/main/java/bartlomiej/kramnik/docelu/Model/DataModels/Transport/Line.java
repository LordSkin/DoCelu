package bartlomiej.kramnik.docelu.Model.DataModels.Transport;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import bartlomiej.kramnik.docelu.R;

/**
 * Data model represents Line
 */

public class Line extends Transport implements Serializable {

    public static int BUS = 0;
    public static int TRAMWAJ = 1;
    public static int OTHER = 2;

    private String name;
    private String from;
    private String where;
    private int numStops;
    private int vechicleType;
    private String arrivalTime;
    private String departureTime;

    public Line(String name, String from, String where, int numStops, String vechicleType, String arrivalTime, String departureTime) {
        this.name = name;
        this.from = from;
        this.where = where;
        this.numStops = numStops;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.vechicleType = OTHER;
        if (vechicleType.equals("TRAM")) {
            this.vechicleType = TRAMWAJ;
        }
        if (vechicleType.equals("BUS")) {
            this.vechicleType = BUS;
        }
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public String getName() {
        return name;
    }

    public int getNumStops() {
        return numStops;
    }

    public int getVechicleType() {
        return vechicleType;
    }

    @Override
    public View getView(LayoutInflater inflater) {
        View result = inflater.inflate(R.layout.line_cell, null);

        TextView stopstextView = (TextView) result.findViewById(R.id.numStops);
        ((TextView) result.findViewById(R.id.from)).setText(from);
        ((TextView) result.findViewById(R.id.where)).setText(where);
        ((TextView) result.findViewById(R.id.lineName)).setText(name);
        stopstextView.setText(numStops + " " + stopstextView.getText());
        ((TextView) result.findViewById(R.id.departureTime)).setText(departureTime);
        ((TextView) result.findViewById(R.id.arrivalTime)).setText(arrivalTime);

        ((ImageView) result.findViewById(R.id.vechicleType)).setImageResource(vechicleType == Line.BUS ? R.drawable.bus : R.drawable.tram);

        return result;
    }
}
