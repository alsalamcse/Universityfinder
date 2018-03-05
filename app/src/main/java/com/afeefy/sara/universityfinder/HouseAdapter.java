package com.afeefy.sara.universityfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.afeefy.sara.universityfinder.Data.House;

/**
 * Created by user on 05/03/2018.
 */


    public class HouseAdapter extends ArrayAdapter<House> {
    /**
     * @param context
     * @param resource the item XML file ex. R.layout.product_item
     */
    public HouseAdapter(@NonNull Context context,  int resource) {
        super(context, resource);
    }



    /**
     * todo מספר סידןרי של הנתון (עצם) ממקור הניתונים
     *
     * @param position    the index of one item from the data (object) source. starting from zero
     * @param convertView todo הממשק שיכול להציג אוסף ניתונים לדוגמה listView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_house, parent, false);
        TextView itmTvnumhouse = (TextView) view.findViewById(R.id.tvnumberinhouse);
        TextView itmTvroomspace = (TextView) view.findViewById(R.id.tvroomspace);
        TextView itmTvphonenumber = (TextView) view.findViewById(R.id.tvphonenumber);
        TextView itmvaddress = (TextView) view.findViewById(R.id.tvaddress);
        House h = getItem(position);
        itmTvnumhouse.setText(h.getNumberinhouse() + "");
        itmTvroomspace.setText(h.getRoomspace() + "");
        itmTvphonenumber.setText(h.getPhonenumber() + "");
        itmvaddress.setText(h.getAddress() + "");
        return view;
    }
}
