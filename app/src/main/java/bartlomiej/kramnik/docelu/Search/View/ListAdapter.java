package bartlomiej.kramnik.docelu.Search.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace;
import bartlomiej.kramnik.docelu.R;
import bartlomiej.kramnik.docelu.Search.Presenter.SearchPresenter;

/**
 * Adapter for last places list
 */

public class ListAdapter extends BaseAdapter {

    @Inject
    SearchPresenter presenter;

    private LayoutInflater infalter;

    public ListAdapter(Context context) {
        this.infalter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return presenter.getlastPlacesCount();
    }

    @Override
    public Object getItem(int position) {
        return presenter.getLastPlace(position);
    }

    @Override
    public long getItemId(int position) {
         return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = infalter.inflate(R.layout.list_row_simple, parent, false);
        TextView textView = (TextView)convertView.findViewById(R.id.text);
        textView.setText(presenter.getLastPlace(position).getDescription());
        return  convertView;
    }
}
