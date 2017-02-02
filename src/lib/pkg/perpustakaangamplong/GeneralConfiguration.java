/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.pkg.perpustakaangamplong;

/**
 *
 * @author milstrike
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class GeneralConfiguration {
    
    
    public String getDate(){
        String Date = new SimpleDateFormat("dd/MM/YYYY").format(new Date());
        return Date;
    }
    
    public String getReturnDate(){
        String Date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate parsedDate = LocalDate.parse(Date);
        LocalDate addedDate = parsedDate.plusDays(Integer.parseInt(globalVariabel.masaSirkulasiMaksimal));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return addedDate.format(formatter); 
    }
    
    public String getTime(){
        String Time = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss").format(new Date());
        return Time;
    }
    
    public String IDCreator(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
            for (int i = 0; i < 10; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
        String output = sb.toString();
        return output;
    }
    
    public String IDUserCreator(){
        char[] chars = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
            for (int i = 0; i < 10; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
        String output = sb.toString();
        return output;
    }
}
