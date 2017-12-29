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

    private Context context;

    private String tableName = "Places";
    private String placeIDColumn = "placeID";
    private String descriptionColumn = "description";

    public DataBaseConnectorImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    public DataBaseConnectorImpl(Context context) {
        super(context, "PlacesDB.db", null, 14);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PLACES_TABLE = "CREATE TABLE " + tableName + "(" +  descriptionColumn + " TEXT, "+ placeIDColumn +" TEXT PRIMARY KEY)";
        sqLiteDatabase.execSQL(CREATE_PLACES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(db);
    }

    @Override
    public List<MyPlace> getPlaces() {
        List<MyPlace> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT DISTINCT * FROM " + tableName, null);

        if(cursor.getCount()<1)return new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                MyPlace place = new MyPlace(cursor.getString(0), cursor.getString(1));
                result.add(place);
            }
            while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return result;
    }

    @Override
    public MyPlace getPlace(int i) {
        if (i < 0) return null;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);

        if (cursor.getCount()<1){
            db.close();
            return null;
        }
        cursor.moveToFirst();
        cursor.move(i);
        MyPlace place = new MyPlace(cursor.getString(0), cursor.getString(1));
        cursor.close();
        db.close();
        return place;
    }

    @Override
    public void addPlace(MyPlace p) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(descriptionColumn, p.getDescription());
        values.put(placeIDColumn, p.getPlaceID());

        db.insert(tableName, null, values);
        db.close();
    }

    @Override
    public void clearPlaces() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + tableName);
        String CREATE_PLACES_TABLE = "CREATE TABLE " + tableName + "(" +  descriptionColumn + " TEXT, "+ placeIDColumn +" TEXT PRIMARY KEY)";
        db.execSQL(CREATE_PLACES_TABLE);
        db.close();
    }

    @Override
    public void deletePlace(MyPlace p) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(tableName, placeIDColumn+" = "+p.getPlaceID(), null);
        db.close();
    }

    @Override
    public void deletePlace(int i) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM " + tableName, null);

        cursor.moveToFirst();
        cursor.move(i);
        MyPlace place = new MyPlace(cursor.getString(0), cursor.getString(1));
        deletePlace(place);
        cursor.close();
        db.close();
    }
}
