package com.dairy.services.request;

import com.google.gson.annotations.SerializedName;

public class GetVendorNameCityREQ {
    @SerializedName("VendorCatID")
    private int VendorCatID;
   @SerializedName("SpecialityID")
    private int SpecialityID;

    public int getSpecialityID() {
        return SpecialityID;
    }

    public void setSpecialityID(int specialityID) {
        SpecialityID = specialityID;
    }

    public int getVendCityID() {
        return VendCityID;
    }

    public void setVendCityID(int vendCityID) {
        VendCityID = vendCityID;
    }

    @SerializedName("VendCityID")
    private int VendCityID;

    public int getVendorCatID() {
        return VendorCatID;
    }

    public void setVendorCatID(int vendorCatID) {
        VendorCatID = vendorCatID;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    @SerializedName("VendorName")
    private String VendorName;

    @SerializedName("vendorID")
    private int vendorID;

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }
}
