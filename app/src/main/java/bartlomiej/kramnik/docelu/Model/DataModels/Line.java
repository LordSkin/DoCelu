package bartlomiej.kramnik.docelu.Model.DataModels;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

import bartlomiej.kramnik.docelu.R;

/**
 * Data model represents Line
 */

public class Line implements Serializable {

    public static int BUS = 0;
    public static int TRAMWAJ = 1;
    public static int OTHER = 2;

    private String name;
    private String from;
    private String where;
    private int numStops;
    private int vechicleType;

    public Line(String name, String from, String where, int numStops, String vechicleType) {
        this.name = name;
        this.from = from;
        this.where = where;
        this.numStops = numStops;
        this.vechicleType = OTHER;
        if(vechicleType.equals("TRAM")){
            this.vechicleType = TRAMWAJ;
        }
        if(vechicleType.equals("BUS")){
            this.vechicleType = BUS;
        }
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

    public View getView(LayoutInflater inflater){
        View result = inflater.inflate(R.layout.line_cell, null);
        ((TextView)result.findViewById(R.id.from)).setText(from);
        ((TextView)result.findViewById(R.id.where)).setText(where);
        ((TextView)result.findViewById(R.id.lineName)).setText(name);
        ((TextView)result.findViewById(R.id.numStops)).setText(numStops+" stops");

        ((ImageView)result.findViewById(R.id.vechicleType)).setImageResource(vechicleType==Line.BUS ? R.drawable.bus : R.drawable.tram);

        return  result;
    }
}
