/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class SerbaGuna {
    
 
    public enum pesan{
      save("Berhasil Disimpan"), update("Berhasil Diperbaharui"), 
      delete("Berhassil Dihapus"), cancle("Batal Dihapus"),
      find("Berhasil Ditemukan");  
        
      private String isine;
      
      private pesan(String isine){
          this.isine = isine;
      }
      public String getPesan(){
          return isine;
      }
    }
    
    public void filterHuruf(KeyEvent a){
            if(Character.isAlphabetic(a.getKeyChar())){
                a.consume();
                JOptionPane.showMessageDialog(null,"inputan berupa angka");
            }
        }

    public void filterAngka(KeyEvent b){
            if(Character.isDigit(b.getKeyChar())){
                b.consume();
               JOptionPane.showMessageDialog(null,"Inputan berupa huruf");
            }
        }
    
    public void filterPass(String pass){
        Pattern ptn = Pattern.compile("^([A-Z|0-9|a-z\\+_\\-]+)+[^\\w\\+_\\-]+$");
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

}
