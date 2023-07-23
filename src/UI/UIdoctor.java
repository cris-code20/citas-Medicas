package UI;

import model.Doctor;

import javax.print.Doc;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Scanner;

import static UI.AInterface.showMenu;

public class UIdoctor {

    public static ArrayList<Doctor> doctors = new ArrayList<>();

    public static void ShowDoctorMenu(){
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Welcome: " + AInterface.doctorLogged.getNombre());
            System.out.println("1. Add scheduled apponintmets");
            System.out.println("2. My Schelduled apponuntments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showMenuAvalideAppointments();
                    break;
                case 2:
                    break;
                case 0:
                    AInterface.showMenu();
                    break;
            }
        }while (response != 0);


    }

    private static void showMenuAvalideAppointments() {
        int reponse = 0;

        do {
            System.out.println("\n");
            System.out.println("Add Available Appointmenr");
            System.out.println("Select a Month");

            for (int i = 0; i<3; i++){
                int j = i +1;
                System.out.println(j + " " + AInterface.MONTHS[i]);
            }
            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            reponse = Integer.valueOf(sc.nextLine());

            if (reponse > 0 && reponse < 4){
                System.out.println(reponse + " . "+ AInterface.MONTHS[reponse-1] );
                System.out.println("INSERT THE DATE AVALIBLE:  [DD/MM/YYYY]");
                String date = sc.nextLine();

                System.out.println("your date: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time availabel for date : " + date + " [16:00]");
                    System.out.println("your time: " + time + "\n1. Correct \n. Change time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);

                AInterface.doctorLogged.addAvalibleAppointment(date, time);
                cheakDoctor((AInterface.doctorLogged));

            }
            if (reponse == 0){
                ShowDoctorMenu();
                return;
            }
        }while (reponse != 0);
    }

    private static void cheakDoctor(Doctor doctor){
        if (doctor.getAvalibleAppointment().size() > 0
        && !doctors.contains(doctor) ){
             doctors.add(doctor);
        }
    }
}
