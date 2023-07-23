package model;

import model.Nurse;
import model.Patient;

import javax.xml.crypto.Data;
import java.util.Date;

// estas clases que tienen solo get y set son conocidas como pojo
//plain old java object
public class AppointmentNurse  implements ISchedulable{
    private int id;
    private Nurse nurse;
    private Patient painter;
    private Data data;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Patient getPainter() {
        return painter;
    }

    public void setPainter(Patient painter) {
        this.painter = painter;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void shedulable(Date date, String time) {

    }


}
