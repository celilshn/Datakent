package cengcelil.Model;

public class Datalar {
    public Datalar(String id,String datah, String data1, String data2, String data3) {
        this.id=id;
        this.datah = datah;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
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

    String id;
    String datah,data1,data2,data3;

}
