package cengcelil.Model;

public class Datalar {
    public String getLog() {
        return log;
    }

    public String getLog_id() {
        return log_id;
    }

    String log;

    public String getDate() {
        return date;
    }

    String date;
    public Datalar(String log_id, String data_id,String t1, String log,String date) {
        this.log_id=log_id;
        this.id = data_id;
        this.datah=t1;
        this.date=date;
    this.log=log;

    }

    public Datalar(String id, String datah, int onay) {
        this.id=id;
        this.datah = datah;
        this.onay=onay;
    }

    public void setOnay(int onay) {
        this.onay = onay;
    }

    public Datalar(String id, String datah, String data1,int onay) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.onay=onay;
    }
    public Datalar(String id, String datah, String data1, String data2,int onay) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.onay=onay;
    }
    public Datalar(String id, String datah, String data1, String data2, String data3,int onay) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.onay=onay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatah() {
        return datah;
    }

    public void setDatah(String datah) {
        this.datah = datah;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    String id,log_id;
    String datah,data1,data2,data3;

    public int getOnay() {
        return onay;
    }

    int onay;

}
