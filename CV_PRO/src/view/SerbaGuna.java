/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import model.Personaldata;
import org.jdesktop.swingx.JXDatePicker;
import tools.Setting;

/**
 *
 * @author Lenovo
 */
public class SerbaGuna {
    
    private Setting setting;
    
 /**
  * Enumerasi untuk menyimpan isi pesan
  */
    public enum pesan{
      save("Berhasil Disimpan"), update("Berhasil Diperbaharui"), 
      delete("Berhasil Dihapus"), cancel("Batal Dihapus"),
      find("Berhasil Ditemukan"), kosong("Terdapat Field Yang Kosong");  
        
      private String isine;
      
      private pesan(String isine){
          this.isine = isine;
      }
      public String getPesan(){
          return isine;
      }
    }

    public SerbaGuna() {
        setting = new Setting();
    }
    
    
    
    /**
     * Method untuk menyaring input agar tidak dapat memasukan huruf
     * @param a (KeyEvent)
     */
    public void filterHuruf(KeyEvent a){
            if(Character.isAlphabetic(a.getKeyChar())){
                a.consume();
                JOptionPane.showMessageDialog(null,"inputan berupa angka");
            }
        }

    /**
     * Method untuk menyaring input agar tidak dapat memasukan angka
     * @param b (KeyEvent)
     */
    public void filterAngka(KeyEvent b){
            if(Character.isDigit(b.getKeyChar())){
                b.consume();
               JOptionPane.showMessageDialog(null,"Inputan berupa huruf");
            }
        }
    
    /**
     * Method untuk mengecek input password apakah berisi minimal sebuah huruf besar, huruf kecil, karakter, dan angka
     * @param pass (String) input password
     */
    public void filterPass(String pass){
//        Pattern ptn = Pattern.compile("^([A-Z|0-9|a-z\\+_\\-]+)+[^\\w\\+_\\-]+$");
        Pattern ptn = Pattern.compile("^([A-Z|a-z\\+_\\-]+)([0-9\\+_\\-]+)([!-~\\+_\\-]+)([^\\w\\+_\\-]+)$");
        Matcher matcher = ptn.matcher(pass);
        if(pass.length()>=8 && !pass.substring(0, 1).equals(" ")){
            if(matcher.matches()){
                JOptionPane.showMessageDialog(null, "Penulisan pass "+ pass + " benar" );
            }
            else{
                JOptionPane.showMessageDialog(null, "Penulisan Pass "+ pass + " salah" );
            }
        }else {
            JOptionPane.showMessageDialog(null, "Penulisan Pass minimal "+ pass + " salah.\nPassword terdiri dari (A-Z or 0-9 or a-z) dan karakter" );
        }
    }
    
    /**
     * Method untuk mengecek apakah input email mengandung simbol "@"
     * @param mail 
     */
    public void cekEmail(String mail){                                    
        Pattern ptn = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Matcher matcher = ptn.matcher(mail);
        if(matcher.matches()){
            JOptionPane.showMessageDialog(null, "Penulisan email "+ mail + " benar" );
        }
        else{
            JOptionPane.showMessageDialog(null, "Penulisan email "+ mail + " salah" );
        }
    }
    
    /**
     * Method untuk mendapatkan tanggal sesuai format yyyy/MM/dd
     * @param date - JXDatePicker
     * @return String hasil format tanggal
     */
    public String getDateFormat(JXDatePicker date){
        String result = date.getDate().toString();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        result = formater.format(date.getDate());
        return result;
    }
    
    /**
     * Method untuk merubah format date
     * @param date (String) tanggal data
     * @param picker (JXDatePicker)
     * @param type (Class) class view yang digunakan
     * @return mengembalikan nilai date yang telah diubah formatnya
     */
    public String pickDate(String date, JXDatePicker picker, Class type){
        Date dateHolder;
        date = date.substring(0, 10);
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateHolder = formater.parse(date);
            picker.setDate(dateHolder);
        } catch (ParseException ex) {
            Logger.getLogger(type.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    public String dateToString(Date date){
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        return formater.format(date);
    }
    
    public String generatePassword(Personaldata personalData){
        String birthDate = dateToString(personalData.getDateofbirth());
        String[] splitDate = birthDate.split("/");
        return personalData.getIdpersonal() + splitDate[0] + splitDate[1] + splitDate[2].substring(2,4);
    }
    
    public String generateUsername(Personaldata personalData){
        String userName = personalData.getIdpersonal()+"";
        String nol = "";
        for(int i = 0; i < 5; i++) nol = nol + "0";
        return "USER" + nol.substring(0,nol.length()-userName.length()) + userName;
    }
    
    private Message setMessage(Message message, Personaldata personalData) throws MessagingException{
        message.setSubject("Registration");
        message.setText("Dear " + personalData.getName() + ", " + "thank you for your registration" + "\n" +
                "Your Username is : " + generateUsername(personalData) + "\n" +
                "Your Password is : " + generatePassword(personalData) + "\n" + "\n" +
                "Regards Metrodata HR Team");
        System.out.println(generateUsername(personalData));
        System.out.println(generatePassword(personalData));
        return message;
    }
    
//    public boolean sendMessage(Personaldata personalData){
//        boolean hasil = false;
//        Properties props = new Properties();
//        props.put("mail.smpt.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//        
//        Session session = Session.getInstance(props,new javax.mail.Authenticator(){
//            protected PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(setting.getEmail(),setting.getPassword());
//            }
//        });
//        
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(setting.getEmail()));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(personalData.getEmail()));
//            message = setMessage(message,personalData);
//            Transport.send(message);
//            hasil = true;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return hasil;
//    }

}
