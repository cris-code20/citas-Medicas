package model;

import javax.xml.crypto.Data    ;
import java.util.Date;

public class AppointmentDoctor implements ISchedulable {
    private int id;
    private  Patient patient;
    private Doctor doctor;
    private Data data;
    private String time;

    public AppointmentDoctor(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getTime() {
        return time + "hrs.";
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public void shedulable(Date date, String time) {
        this.data =data;
        this.time = time;
    }
}
