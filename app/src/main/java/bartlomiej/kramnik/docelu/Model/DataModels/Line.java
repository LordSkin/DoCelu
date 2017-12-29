package bartlomiej.kramnik.docelu.Model.DataModels;

/**
 * Data model represents Line
 */

public class Line {

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
}
