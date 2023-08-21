/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TextFileRW {

    public TextFileRW() {
        
    }

    public User login(String id, String password) {
        User u = new User();
        if (id.equals("admin1") && password.equals("admin1")) {
            return new Admin("admin");
        } else {
            ArrayList<Lecturer> lecturers = readAllLecturer();

            for (Lecturer lecturer : lecturers) {
                if (lecturer.getId().equals(id) && lecturer.getPassword().equals(password)) {
                    return lecturer;
                }
            }
        }
        return null;
    }

    public Lecturer addUser(String name) {
        ArrayList<Lecturer> lecturers = readAllLecturer();
        Lecturer l = new Lecturer();
        l.setName(name);
        l.setPassword("abcd1234");
        lecturers.add(l);
        saveAllLecturer(lecturers);
        return l;
    }

    public void deleteUser(String id) {
        ArrayList<Lecturer> lecturers = readAllLecturer();
        for (int i = 0; i < lecturers.size(); i++) {
            Lecturer lecturer = lecturers.get(i);
            if (lecturer.getId().equals(id)) {
                lecturers.remove(i);
                break;
            }
        }
        saveAllLecturer(lecturers);
    }

    public boolean changePassword(String id, String oldPW, String newPW) {
        ArrayList<Lecturer> lecturers = readAllLecturer();
        for (int i = 0; i < lecturers.size(); i++) {
            Lecturer lecturer = lecturers.get(i);
            if (lecturer.getId().equals(id) && lecturer.getPassword().equals(oldPW)) {
                lecturer.setPassword(newPW);
                saveAllLecturer(lecturers);
                return true;
            }
        }
        return false;
    }

    public void addVenue(String name) {
        ArrayList<Venue> venues = readAllVenue();
        Venue l = new Venue();
        l.setName(name);
        venues.add(l);
        saveAllVenue(venues);
    }

    public void bookVenue(Booking b) {
        ArrayList<Booking> bookings = readAllBooking(null);
        bookings.add(b);
        saveAllBooking(bookings);
    }

    public void deleteVenue(String code) {
        ArrayList<Venue> venues = readAllVenue();
        for (int i = 0; i < venues.size(); i++) {
            Venue venue = venues.get(i);
            if (venue.getCode().equals(code)) {
                venues.remove(i);
                break;
            }
        }
        saveAllVenue(venues);
    }

    public ArrayList<Lecturer> readAllLecturer() {
        ArrayList<Lecturer> a = new ArrayList<>();
        String[] read = ReadTextFile("Lecturer.txt");
        for (int i = 0; i < read.length; i++) {
            String[] data = read[i].split(";");
            Lecturer c = new Lecturer(data[0], data[1], data[2]);
            a.add(c);
        }
        return a;
    }

    public ArrayList<Booking> readAllBooking(String searchString) {
        ArrayList<Booking> a = new ArrayList<>();
        String[] read = ReadTextFile("Booking.txt");
        for (int i = 0; i < read.length; i++) {
            String[] data = read[i].split(";");
            Booking c = new Booking(data[0], data[1], data[2], Integer.parseInt(data[3]));

            if ((searchString != null && searchString.equals(data[0])) || 
                    (searchString != null && searchString.equals(data[1])) || 
                        (searchString != null && searchString.equals(data[2])) || 
                            searchString == null) {
                a.add(c);
            }
        }
        return a;
    }

    public ArrayList<Venue> readAllVenue() {
        ArrayList<Venue> a = new ArrayList<>();
        String[] read = ReadTextFile("Venue.txt");
        for (int i = 0; i < read.length; i++) {
            String[] data = read[i].split(";");
            Venue c = new Venue(data[0], data[1]);
            a.add(c);
        }
        return a;
    }

    public void saveAllLecturer(ArrayList<Lecturer> l) {
        String[] write = new String[l.size()];
        for (int i = 0; i < write.length; i++) {
            write[i] = String.format("%s;%s;%s",
                    l.get(i).getId(),
                    l.get(i).getPassword(),
                    l.get(i).getName());
        }
        WriteTextFile(write, "Lecturer.txt");
    }

    public void saveAllBooking(ArrayList<Booking> b) {
        String[] write = new String[b.size()];
        for (int i = 0; i < write.length; i++) {
            write[i] = String.format("%s;%s;%s;%d",
                    b.get(i).getVenueID(),
                    b.get(i).getLecturerID(),
                    b.get(i).getDate(),
                    b.get(i).getTime());
        }
        WriteTextFile(write, "Booking.txt");
    }

    public void saveAllVenue(ArrayList<Venue> v) {
        String[] write = new String[v.size()];
        for (int i = 0; i < write.length; i++) {
            write[i] = String.format("%s;%s",
                    v.get(i).getCode(),
                    v.get(i).getName());
        }
        WriteTextFile(write, "Venue.txt");
    }

    private static String[] ReadTextFile(String fileName) {
        ArrayList<String> read = new ArrayList<>();
        try {
            File myObj = new File("test/" + fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                read.add(myReader.nextLine());
            }
            return read.toArray(new String[0]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void WriteTextFile(String[] write, String fileName) {
        BufferedWriter output = null;
        try {
            File file = new File("test/" + fileName);
            output = new BufferedWriter(new FileWriter(file));
            StringBuilder input = new StringBuilder();
            for (String s : write) {
                input.append(s + "\n");
            }

            output.write(input.toString());
            output.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
