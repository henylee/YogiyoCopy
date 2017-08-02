package kr.co.tjenit.yogiyocopy.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjenit.yogiyocopy.R;

/**
 * Created by the on 2017-08-02.
 */

public class SortSpinnerAdapter extends ArrayAdapter<String> {

    Context mContext;
    List<String> mList;
    LayoutInflater inf;

    public SortSpinnerAdapter(Context context, List<String> list) {
        super(context, R.layout.sort_spinner_liist_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.sort_spinner_display_item, null);
        }

        String data = mList.get(position);

        TextView sortTypeTxt = (TextView) row.findViewById(R.id.sortTypeTxt);
        sortTypeTxt.setText(data);

        return row;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.sort_spinner_liist_item, null);
        }

        String data = mList.get(position);

        TextView sortTypeTxt = (TextView) row.findViewById(R.id.sortTypeTxt);
        sortTypeTxt.setText(data);

        return row;
    }

}
