package com.example.indotrainticket.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.indotrainticket.R;
import com.example.indotrainticket.model.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends ArrayAdapter<HistoryModel> {

    public HistoryAdapter(Activity context, ArrayList<HistoryModel> notification) {
        super(context, 0, notification);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            //source code mengarah ke act list_item_booking
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_booking, parent, false);
        }

        HistoryModel current = getItem(position);
        //untuk menampilkan id booking pada setiap pemesanan
        TextView idBook = listItemView.findViewById(R.id.id_booking);
        idBook.setText("ID : " + current.getIdBook());
        //untuk menampilkan tanggal booking pada setiap pemesanan
        TextView tanggal = listItemView.findViewById(R.id.tanggal);
        tanggal.setText(current.getTanggal());
        //untuk menampilkan riwayat pada setiap pemesanan
        TextView riwayat = listItemView.findViewById(R.id.riwayat);
        riwayat.setText(current.getRiwayat());
        //untuk menampilkan total pada setiap pemesanan
        TextView tvTotal = listItemView.findViewById(R.id.tv_total);
        tvTotal.setText("Total :");
        //untuk menampilkan harga pada setiap pemesanan
        TextView total = listItemView.findViewById(R.id.total);
        total.setText("Rp. " + current.getTotal());
        //untuk menampilkan image pada setiap pemesanan
        ImageView imageIcon = listItemView.findViewById(R.id.image);

        if (current.hasImage()) {
            imageIcon.setImageResource(current.getImageResourceId());
            imageIcon.setVisibility(View.VISIBLE);
        } else {
            imageIcon.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
