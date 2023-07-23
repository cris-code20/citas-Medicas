package UI;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static UI.UIdoctor.*;

public class UIpatient {

    public static void showPatientMenu(){
        int response = 0;

        do {

            System.out.println("\n\n");
            System.out.println("Paitentn");
            System.out.println("Welcome: " + AInterface.patientLogged);
            System.out.println("1. Add scheduled apponintmets");
            System.out.println("2. My Schelduled apponuntments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showPatien();
                    break;
                case 2:
                    showPatienMyAppoinment();
                    break;
                case 0:
                    AInterface.showMenu();
                    break;
            }
        }while (response != 0);
    }
    private static void  showPatien(){
        int response = 0;

        do {
            System.out.println("\n");
            System.out.println("Add Available Appointmenr");
            System.out.println("Select a Date");

            Map<Integer, Map<Integer, Doctor>> doctorss = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIdoctor.doctors.size(); i++){
                ArrayList<Doctor.AvalibleAppointment> avalibleAppointments = UIdoctor.doctors.get(i).
                                                                            getAvalibleAppointment();

                Map<Integer, Doctor> doctorMap = new TreeMap<>();

                for (int j = 0; j < avalibleAppointments.size(); j++){
                 k++;

                    System.out.println(k + " . " + avalibleAppointments.get(j).getDate());
                    doctorMap.put(Integer.valueOf(j),  UIdoctor.doctors.get(i));
                    doctorss.put(Integer.valueOf(k), doctorMap);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseSelecte = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctorss.get(responseSelecte);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getNombre() +
                    ". Date " + doctorSelected.getAvalibleAppointment().get(indexDate).getTime() +
                    ". Time " + doctorSelected.getAvalibleAppointment().get(indexDate).getTime());

            System.out.println("Confirm your Appointment: \n1. yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());


            if (response == 1){
                AInterface.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvalibleAppointment().get(indexDate).getDate(null),
                        doctorSelected.getAvalibleAppointment().get(indexDate).getTime());

                showPatientMenu();
            }


        }while (response != 0);
    }

    private static void  showPatienMyAppoinment() {

        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (AInterface.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < AInterface.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + AInterface.patientLogged.getAppointmentDoctors().get(i).getData() +
                        " Time: " + AInterface.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + AInterface.patientLogged.getAppointmentDoctors().get(i).getDoctor().getNombre()
                );
            }
        }while (response != 0);
    }
}
