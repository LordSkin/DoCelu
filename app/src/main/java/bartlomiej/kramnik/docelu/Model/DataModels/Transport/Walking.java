package bartlomiej.kramnik.docelu.Model.DataModels.Transport;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import bartlomiej.kramnik.docelu.R;

/**
 * Data model for walking
 */

public class Walking extends Transport implements Serializable {

    private String description;

    public Walking(String description) {
        this.description = description;
    }


    @Override
    public View getView(LayoutInflater inflater) {
        View result = inflater.inflate(R.layout.walking_cell,null);

        ((TextView)result.findViewById(R.id.description)).setText(description);

        return result;
    }
}
