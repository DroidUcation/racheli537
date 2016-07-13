package entity;

/**
 * Created by user on 13/07/2016.
 */
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.audio.kramer.configureaudio.R;

public class AudioCursorAdapter extends CursorAdapter {

    public AudioCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // when the view will be created for first time,
        // we need to tell the adapters, how each item will look
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.singel_row_item, parent, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // here we are setting our data
        // that means, take the data from the cursor and put it in views

        TextView textViewPort = (TextView) view.findViewById(R.id.tv_port_number);
        textViewPort.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));

        TextView textViewName = (TextView) view.findViewById(R.id.tv_name);
        textViewName.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));

        TextView textViewDescription = (TextView) view.findViewById(R.id.tv_description);
        textViewDescription.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
    }
}

