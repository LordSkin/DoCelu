package bartlomiej.kramnik.docelu.Model.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;

/**
 * SQLite database implementation
 */

public class DataBaseConnectorImpl extends SQLiteOpenHelper implements DataBaseConnector {

    Context context;

    private String tableName = "Places";
    private String idColumn = "id";
    private String placeIDColumn = "placeID";
    private String descriptionColumn = "description";

    public DataBaseConnectorImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public DataBaseConnectorImpl(Context context) {
        super(context, "PlacesDB", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PLACES_TABLE = "CREATE TABLE IF NOT EXISTS " + tableName + "(" + idColumn + " INTEGER PRIMARY KEY, " + descriptionColumn + "TEXT,"+ placeIDColumn +" TEXT)";
        sqLiteDatabase.execSQL(CREATE_PLACES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    @Override
    public List<MyPlace> getPlaces() {
        List<MyPlace> result = new ArrayList<MyPlace>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM " + tableName, null);
        db.close();

        if (cursor.moveToFirst()) {
            do {
                MyPlace place = new MyPlace(cursor.getInt(0), cursor.getString(1),cursor.getString(2));
                result.add(place);
            }
            while (cursor.moveToNext());
        }

        return result;
    }

    @Override
    public MyPlace getPlace(int i) {
        if (i < 0) return null;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM " + tableName, null);
        db.close();

        cursor.moveToFirst();
        cursor.move(i);
        MyPlace place = new MyPlace(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        return place;
    }

    @Override
    public void addPlace(MyPlace p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(idColumn, p.getId());
        values.put(descriptionColumn, p.getDescription());
        values.put(placeIDColumn, p.getPlaceID());

        db.insert(tableName, null, values);
        db.close();
    }

    @Override
    public void clearPlaces() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        db.close();
    }

    @Override
    public void deletePlace(MyPlace p) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(tableName, "WHERE "+idColumn+" = "+p.getId(), null);
        db.close();
    }

    @Override
    public void deletePlace(int i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM " + tableName, null);
        db.close();

        cursor.moveToFirst();
        cursor.move(i);
        MyPlace place = new MyPlace(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        deletePlace(place);
    }
}