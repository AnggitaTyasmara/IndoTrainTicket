package com.example.indotrainticket.model;

public class HistoryModel {
//mendeklarasikan idbook, mtanggal, mriwayat, mtotal, dan mResourceid
    private String mIdBook;
    private String mTanggal;
    private String mRiwayat;
    private String mTotal;
    private int mImageResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public HistoryModel(String idBook, String tanggal, String riwayat, String total, int imageResourceId) {
        mIdBook = idBook;
        mTanggal = tanggal;
        mRiwayat = riwayat;
        mTotal = total;
        mImageResourceId = imageResourceId;
    }
    //memanggil id book
    public String getIdBook() {
        return mIdBook;
    }
    //memanggil tanggal
    public String getTanggal() {
        return mTanggal;
    }
    //memanggil riwayat
    public String getRiwayat() {
        return mRiwayat;
    }
    //memanggil total
    public String getTotal() {
        return mTotal;
    }
    //memanggil image id
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
