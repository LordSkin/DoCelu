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
    private String duration;
            private String distance;

    public Walking(String description, String duration) {
        this.duration = duration;
        this.description = description;
    }


    @Override
    public View getView(LayoutInflater inflater) {
        View result = inflater.inflate(R.layout.walking_cell, null);

        ((TextView) result.findViewById(R.id.description)).setText(description);
        ((TextView) result.findViewById(R.id.duration)).setText(duration);
        return result;
    }
}
