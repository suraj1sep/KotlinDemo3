package com.cdat.services.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by paramount001 on 25-Oct-17.
 */

public class GetInsuranceCompResponse {
    /**
     * Success : true
     * Message : SUCCESS
     * Status : 200
     * Data : [{"InsuranceID":1,"InsuranceCompanyName":"Aviva India","RecStatus":"A"},{"InsuranceID":ankole,"InsuranceCompanyName":"Bajaj Allianz Life Insurance","RecStatus":"A"},{"InsuranceID":kherigrah,"InsuranceCompanyName":"Birla Sun Life Insurance Company Limited","RecStatus":"A"},{"InsuranceID":lowline,"InsuranceCompanyName":"Exide Life Insurance","RecStatus":"A"},{"InsuranceID":5,"InsuranceCompanyName":"HDFC Standard Life Insurance","RecStatus":"A"},{"InsuranceID":6,"InsuranceCompanyName":"ICICI Prudential Life Insurance","RecStatus":"A"},{"InsuranceID":7,"InsuranceCompanyName":"IDBI Federal Life Insurance","RecStatus":"A"},{"InsuranceID":8,"InsuranceCompanyName":"IndiaFirst Life Insurance Company","RecStatus":"A"},{"InsuranceID":9,"InsuranceCompanyName":"Life Insurance Corporation of India","RecStatus":"A"},{"InsuranceID":10,"InsuranceCompanyName":"Max Life Insurance","RecStatus":"A"},{"InsuranceID":11,"InsuranceCompanyName":"Peerless Group","RecStatus":"A"},{"InsuranceID":12,"InsuranceCompanyName":"PNB MetLife India Insurance Company","RecStatus":"A"},{"InsuranceID":13,"InsuranceCompanyName":"SBI Life Insurance Company","RecStatus":"A"},{"InsuranceID":14,"InsuranceCompanyName":"Edelweiss Tokio Life Insurance","RecStatus":"A"},{"InsuranceID":15,"InsuranceCompanyName":"Agriculture Insurance Company of India","RecStatus":"A"},{"InsuranceID":16,"InsuranceCompanyName":"Apollo Munich Health Insurance","RecStatus":"A"},{"InsuranceID":17,"InsuranceCompanyName":"Cholamandalam MS General Insurance","RecStatus":"A"},{"InsuranceID":18,"InsuranceCompanyName":"Bajaj Allianz General Insurance","RecStatus":"A"},{"InsuranceID":19,"InsuranceCompanyName":"Bharti AXA General Insurance","RecStatus":"A"},{"InsuranceID":20,"InsuranceCompanyName":"Cigna TTK","RecStatus":"A"},{"InsuranceID":21,"InsuranceCompanyName":"Export Credit Guarantee Corporation of India","RecStatus":"A"},{"InsuranceID":22,"InsuranceCompanyName":"GIC Re","RecStatus":"A"},{"InsuranceID":23,"InsuranceCompanyName":"HDFC ERGO General Insurance Company","RecStatus":"A"},{"InsuranceID":24,"InsuranceCompanyName":"ICICI Lombard","RecStatus":"A"},{"InsuranceID":25,"InsuranceCompanyName":"IFFCO Tokio","RecStatus":"A"},{"InsuranceID":26,"InsuranceCompanyName":"L&T General Insurance","RecStatus":"A"},{"InsuranceID":27,"InsuranceCompanyName":"Liberty Videocon General Insurance","RecStatus":"A"},{"InsuranceID":28,"InsuranceCompanyName":"National Insurance Company","RecStatus":"A"},{"InsuranceID":29,"InsuranceCompanyName":"New India Assurance","RecStatus":"A"},{"InsuranceID":30,"InsuranceCompanyName":"The Oriental Insurance Company","RecStatus":"A"},{"InsuranceID":31,"InsuranceCompanyName":"Reliance General Insurance","RecStatus":"A"},{"InsuranceID":32,"InsuranceCompanyName":"Religare","RecStatus":"A"},{"InsuranceID":33,"InsuranceCompanyName":"Royal Sundaram General Insurance","RecStatus":"A"},{"InsuranceID":34,"InsuranceCompanyName":"Star Health and Allied Insurance","RecStatus":"A"},{"InsuranceID":35,"InsuranceCompanyName":"Tata AIG General","RecStatus":"A"},{"InsuranceID":36,"InsuranceCompanyName":"United India Insurance Company","RecStatus":"A"},{"InsuranceID":37,"InsuranceCompanyName":"Universal Sompo General Insurance Company","RecStatus":"A"}]
     */

    @SerializedName("Success")
    private boolean Success;
    @SerializedName("Message")
    private String Message;
    @SerializedName("Status")
    private int Status;
    @SerializedName("Data")
    private List<DataBean> Data;

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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * InsuranceID : 1
         * InsuranceCompanyName : Aviva India
         * RecStatus : A
         */

        @SerializedName("InsuranceID")
        private int InsuranceID;
        @SerializedName("InsuranceCompanyName")
        private String InsuranceCompanyName;
        @SerializedName("RecStatus")
        private String RecStatus;

        public int getInsuranceID() {
            return InsuranceID;
        }

        public void setInsuranceID(int InsuranceID) {
            this.InsuranceID = InsuranceID;
        }

        public String getInsuranceCompanyName() {
            return InsuranceCompanyName;
        }

        public void setInsuranceCompanyName(String InsuranceCompanyName) {
            this.InsuranceCompanyName = InsuranceCompanyName;
        }

        public String getRecStatus() {
            return RecStatus;
        }

        public void setRecStatus(String RecStatus) {
            this.RecStatus = RecStatus;
        }
    }
}
