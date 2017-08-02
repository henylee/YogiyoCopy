package kr.co.tjenit.yogiyocopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjenit.yogiyocopy.R;
import kr.co.tjenit.yogiyocopy.data.StoreData;

/**
 * Created by the on 2017-08-02.
 */

public class StoreAdapter extends ArrayAdapter<StoreData> {

    Context mContext;
    List<StoreData> mList;
    LayoutInflater inf;

    public StoreAdapter (Context context, List<StoreData> list) {

        super(context, R.layout.store_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.store_list_item, null);
        }

        StoreData data = mList.get(position);

        TextView storeName = (TextView) row.findViewById(R.id.storeName);
        TextView grade = (TextView) row.findViewById(R.id.grade);
        TextView delivery = (TextView) row.findViewById(R.id.delivery);
        TextView openAndClose = (TextView) row.findViewById(R.id.openAndClose);
        TextView payMethodTxt = (TextView) row.findViewById(R.id.payMethodTxt);

        ImageView isCescoimg = (ImageView) row.findViewById(R.id.isCescoimg);
        ImageView storeImage = (ImageView) row.findViewById(R.id.storeImage);
        ImageView starImg1 = (ImageView) row.findViewById(R.id.starImg1);
        ImageView starImg2 = (ImageView) row.findViewById(R.id.starImg2);
        ImageView starImg3 = (ImageView) row.findViewById(R.id.starImg3);
        ImageView starImg4 = (ImageView) row.findViewById(R.id.starImg4);
        ImageView starImg5 = (ImageView) row.findViewById(R.id.starImg5);

        List<ImageView> stars = new ArrayList<>();
        stars.add(starImg1);
        stars.add(starImg2);
        stars.add(starImg3);
        stars.add(starImg4);
        stars.add(starImg5);

        for (ImageView iv : stars) {
            iv.setImageResource(R.drawable.gray_star);
        }

        int rating = (int) data.getAverageRating();
        for (int i=0; i<rating; i++) {
            stars.get(i).setImageResource(R.drawable.fill_star);
        }

        storeName.setText(data.getStoreName());
        grade.setText(data.getAverageRating()+"점 / " + data.getReviews().size() + "개의 리뷰");

        String minCost = String.format("%,d원 이상 배달 가능", data.getMinCost());

        delivery.setText(minCost);

        int openHour = data.getOpenTime() / 100;
        int openMinute = data.getOpenTime() % 100;
        int closeHour = data.getCloseTime() / 100;
        int closeMinute = data.getCloseTime() % 100;

        String openCloseStr = String.format("%02d:%02d - %02d:%02d", openHour,openMinute,closeHour,closeMinute);

        openAndClose.setText(openCloseStr);

        if (data.isCesco() == true) {
            isCescoimg.setVisibility(View.VISIBLE);
        }
        else {
            isCescoimg.setVisibility(View.INVISIBLE);
        }

        return row;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.store_list_item, null);
        }

        StoreData data = mList.get(position);

        TextView storeName = (TextView) row.findViewById(R.id.storeName);
        TextView grade = (TextView) row.findViewById(R.id.grade);
        TextView delivery = (TextView) row.findViewById(R.id.delivery);

        storeName.setText(data.getStoreName());
        grade.setText(data.getAverageRating()+"");
        delivery.setText(data.getMinCost()+"");

        return row;
    }
}
