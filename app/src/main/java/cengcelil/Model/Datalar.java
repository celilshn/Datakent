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
    public Datalar(String log_id, String data_id,String t1, String log,String date,int k) {
        this.log_id=log_id;
        this.id = data_id;
        this.datah=t1;
        this.date=date;
     this.log=log;

    }

    public Datalar(String id, String datah, String status) {
        this.id=id;
        this.datah = datah;
        this.status=status;
    }


    public Datalar(String id, String datah, String data1,String status) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.status=status;
    }
    public Datalar(String id, String datah, String data1, String data2,String status) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.status=status;
    }
    public Datalar(String id, String datah, String data1, String data2, String data3,String status) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.status=status;
    }
    public Datalar(String id, String datah, String data1, String data2, String data3,String data4,String status) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.status=status;
    }


    public Datalar(String id, String datah, String data1, String data2, String data3, String data4, String data5, String status) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.status=status;
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


    public String getData1() {
        return data1;
    }


    public String getData2() {
        return data2;
    }


    public String getData3() {
        return data3;
    }


    public String getData4() {
        return data4;
    }

    public String getData5() { return data5; }

    String id,log_id;
    String datah,data1,data2,data3,data4,data5;

    public String getStatus() {
        return status;
    }

    String status;

}
