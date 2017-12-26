package bartlomiej.kramnik.docelu.Model.DataModels;

/**
 * Data model represents Line
 */

public class Line {
    private String name;
    private String from;
    private String where;

    public Line(String name, String from, String where) {
        this.name = name;
        this.from = from;
        this.where = where;
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
}
