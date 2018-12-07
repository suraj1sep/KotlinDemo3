package com.cdat.services.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetVendorNameLogoNearByResponse {

    /**
     * Success : true
     * Message : SUCCESS
     * Status : 200
     * Data : [{"VendorCatID":0,"VendorCatName":null,"VendorID":7,"VendorCode":null,"VendName":"SHAH CHILDREN HOSPITAL","VendAdd1":null,"VendAdd2":null,"VendCityID":107,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":32,"VendorCode":null,"VendName":"DR. KANDOIS ASHIRWAD HOSPITAL( AMBERNATH WEST)","VendAdd1":null,"VendAdd2":null,"VendCityID":118,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":33,"VendorCode":null,"VendName":"Saidham Multispeciality Hospital","VendAdd1":null,"VendAdd2":null,"VendCityID":51,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":34,"VendorCode":null,"VendName":"Lilavati Hospital","VendAdd1":null,"VendAdd2":null,"VendCityID":52,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":40,"VendorCode":null,"VendName":"KAPOOR MEDICAL CENTRE","VendAdd1":null,"VendAdd2":null,"VendCityID":154,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":42,"VendorCode":null,"VendName":"ANAND HOSPITAL-","VendAdd1":null,"VendAdd2":null,"VendCityID":51,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":46,"VendorCode":null,"VendName":"HCG APEX CANCER CENTRE-","VendAdd1":null,"VendAdd2":null,"VendCityID":52,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":48,"VendorCode":null,"VendName":"SHREE HARNESHWAR CLINIC","VendAdd1":null,"VendAdd2":null,"VendCityID":51,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":49,"VendorCode":null,"VendName":"DALVI NURSING HOME-","VendAdd1":null,"VendAdd2":null,"VendCityID":52,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":50,"VendorCode":null,"VendName":"MAA SHARDA HOSPITAL","VendAdd1":null,"VendAdd2":null,"VendCityID":82,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":51,"VendorCode":null,"VendName":"MAX VISION ADVANCE EYE CARE CENTRE","VendAdd1":null,"VendAdd2":null,"VendCityID":117,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null},{"VendorCatID":0,"VendorCatName":null,"VendorID":55,"VendorCode":null,"VendName":"CONTACARE EYE HOSPITAL-","VendAdd1":null,"VendAdd2":null,"VendCityID":52,"VendStateID":0,"VendCountryID":0,"VendPrimaryEmail":null,"VendPrimaryMobile":null,"VendWebsite":null,"VendPriLat":null,"VendPriLon":null,"CategoryID":0,"CityID":0,"KMDistance":0,"FromKm":null,"ToKm":null,"VendStateName":null,"VendCityName":null,"ServiceID":0,"DoctorID":0,"ServiceName":null,"GetVendorPrimaryList":null,"GetServiceList":null,"GetServicesPackageList":null,"ServiceIDs":null,"ServiceType":null}]
     */

    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Status")
    private int Status;
    @SerializedName("Data")
    private ArrayList<DataBean> Data;

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public ArrayList<DataBean> getData() {
        return Data;
    }

    public void setData(ArrayList<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * VendorCatID : 0
         * VendorCatName : null
         * VendorID : 7
         * VendorCode : null
         * VendName : SHAH CHILDREN HOSPITAL
         * VendAdd1 : null
         * VendAdd2 : null
         * VendCityID : 107
         * VendStateID : 0
         * VendCountryID : 0
         * VendPrimaryEmail : null
         * VendPrimaryMobile : null
         * VendWebsite : null
         * VendPriLat : null
         * VendPriLon : null
         * CategoryID : 0
         * CityID : 0
         * KMDistance : 0
         * FromKm : null
         * ToKm : null
         * VendStateName : null
         * VendCityName : null
         * ServiceID : 0
         * DoctorID : 0
         * ServiceName : null
         * GetVendorPrimaryList : null
         * GetServiceList : null
         * GetServicesPackageList : null
         * ServiceIDs : null
         * ServiceType : null
         */

        @SerializedName("VendorCatID")
        private int VendorCatID;
        @SerializedName("VendorCatName")
        private Object VendorCatName;
        @SerializedName("VendorID")
        private int VendorID;
        @SerializedName("VendorCode")
        private Object VendorCode;
        @SerializedName("VendName")
        private String VendName;
        @SerializedName("VendAdd1")
        private Object VendAdd1;
        @SerializedName("VendAdd2")
        private Object VendAdd2;
        @SerializedName("VendCityID")
        private int VendCityID;
        @SerializedName("VendStateID")
        private int VendStateID;
        @SerializedName("VendCountryID")
        private int VendCountryID;
        @SerializedName("VendPrimaryEmail")
        private Object VendPrimaryEmail;
        @SerializedName("VendPrimaryMobile")
        private Object VendPrimaryMobile;
        @SerializedName("VendWebsite")
        private Object VendWebsite;
        @SerializedName("VendPriLat")
        private Object VendPriLat;
        @SerializedName("VendPriLon")
        private Object VendPriLon;
        @SerializedName("CategoryID")
        private int CategoryID;
        @SerializedName("CityID")
        private int CityID;
        @SerializedName("KMDistance")
        private int KMDistance;
        @SerializedName("FromKm")
        private Object FromKm;
        @SerializedName("ToKm")
        private Object ToKm;
        @SerializedName("VendStateName")
        private Object VendStateName;
        @SerializedName("VendCityName")
        private Object VendCityName;
        @SerializedName("ServiceID")
        private int ServiceID;
        @SerializedName("DoctorID")
        private int DoctorID;
        @SerializedName("ServiceName")
        private Object ServiceName;
        @SerializedName("GetVendorPrimaryList")
        private Object GetVendorPrimaryList;
        @SerializedName("GetServiceList")
        private Object GetServiceList;
        @SerializedName("GetServicesPackageList")
        private Object GetServicesPackageList;
        @SerializedName("ServiceIDs")
        private Object ServiceIDs;
        @SerializedName("ServiceType")
        private Object ServiceType;

        public int getVendorCatID() {
            return VendorCatID;
        }

        public void setVendorCatID(int VendorCatID) {
            this.VendorCatID = VendorCatID;
        }

        public Object getVendorCatName() {
            return VendorCatName;
        }

        public void setVendorCatName(Object VendorCatName) {
            this.VendorCatName = VendorCatName;
        }

        public int getVendorID() {
            return VendorID;
        }

        public void setVendorID(int VendorID) {
            this.VendorID = VendorID;
        }

        public Object getVendorCode() {
            return VendorCode;
        }

        public void setVendorCode(Object VendorCode) {
            this.VendorCode = VendorCode;
        }

        public String getVendName() {
            return VendName;
        }

        public void setVendName(String VendName) {
            this.VendName = VendName;
        }

        public Object getVendAdd1() {
            return VendAdd1;
        }

        public void setVendAdd1(Object VendAdd1) {
            this.VendAdd1 = VendAdd1;
        }

        public Object getVendAdd2() {
            return VendAdd2;
        }

        public void setVendAdd2(Object VendAdd2) {
            this.VendAdd2 = VendAdd2;
        }

        public int getVendCityID() {
            return VendCityID;
        }

        public void setVendCityID(int VendCityID) {
            this.VendCityID = VendCityID;
        }

        public int getVendStateID() {
            return VendStateID;
        }

        public void setVendStateID(int VendStateID) {
            this.VendStateID = VendStateID;
        }

        public int getVendCountryID() {
            return VendCountryID;
        }

        public void setVendCountryID(int VendCountryID) {
            this.VendCountryID = VendCountryID;
        }

        public Object getVendPrimaryEmail() {
            return VendPrimaryEmail;
        }

        public void setVendPrimaryEmail(Object VendPrimaryEmail) {
            this.VendPrimaryEmail = VendPrimaryEmail;
        }

        public Object getVendPrimaryMobile() {
            return VendPrimaryMobile;
        }

        public void setVendPrimaryMobile(Object VendPrimaryMobile) {
            this.VendPrimaryMobile = VendPrimaryMobile;
        }

        public Object getVendWebsite() {
            return VendWebsite;
        }

        public void setVendWebsite(Object VendWebsite) {
            this.VendWebsite = VendWebsite;
        }

        public Object getVendPriLat() {
            return VendPriLat;
        }

        public void setVendPriLat(Object VendPriLat) {
            this.VendPriLat = VendPriLat;
        }

        public Object getVendPriLon() {
            return VendPriLon;
        }

        public void setVendPriLon(Object VendPriLon) {
            this.VendPriLon = VendPriLon;
        }

        public int getCategoryID() {
            return CategoryID;
        }

        public void setCategoryID(int CategoryID) {
            this.CategoryID = CategoryID;
        }

        public int getCityID() {
            return CityID;
        }

        public void setCityID(int CityID) {
            this.CityID = CityID;
        }

        public int getKMDistance() {
            return KMDistance;
        }

        public void setKMDistance(int KMDistance) {
            this.KMDistance = KMDistance;
        }

        public Object getFromKm() {
            return FromKm;
        }

        public void setFromKm(Object FromKm) {
            this.FromKm = FromKm;
        }

        public Object getToKm() {
            return ToKm;
        }

        public void setToKm(Object ToKm) {
            this.ToKm = ToKm;
        }

        public Object getVendStateName() {
            return VendStateName;
        }

        public void setVendStateName(Object VendStateName) {
            this.VendStateName = VendStateName;
        }

        public Object getVendCityName() {
            return VendCityName;
        }

        public void setVendCityName(Object VendCityName) {
            this.VendCityName = VendCityName;
        }

        public int getServiceID() {
            return ServiceID;
        }

        public void setServiceID(int ServiceID) {
            this.ServiceID = ServiceID;
        }

        public int getDoctorID() {
            return DoctorID;
        }

        public void setDoctorID(int DoctorID) {
            this.DoctorID = DoctorID;
        }

        public Object getServiceName() {
            return ServiceName;
        }

        public void setServiceName(Object ServiceName) {
            this.ServiceName = ServiceName;
        }

        public Object getGetVendorPrimaryList() {
            return GetVendorPrimaryList;
        }

        public void setGetVendorPrimaryList(Object GetVendorPrimaryList) {
            this.GetVendorPrimaryList = GetVendorPrimaryList;
        }

        public Object getGetServiceList() {
            return GetServiceList;
        }

        public void setGetServiceList(Object GetServiceList) {
            this.GetServiceList = GetServiceList;
        }

        public Object getGetServicesPackageList() {
            return GetServicesPackageList;
        }

        public void setGetServicesPackageList(Object GetServicesPackageList) {
            this.GetServicesPackageList = GetServicesPackageList;
        }

        public Object getServiceIDs() {
            return ServiceIDs;
        }

        public void setServiceIDs(Object ServiceIDs) {
            this.ServiceIDs = ServiceIDs;
        }

        public Object getServiceType() {
            return ServiceType;
        }

        public void setServiceType(Object ServiceType) {
            this.ServiceType = ServiceType;
        }
    }
}
