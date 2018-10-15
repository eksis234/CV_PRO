/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import view.cv_kandidat;
import java.sql.SQLException;
public interface controller_laporan { 
    public void Tampilkan(cv_kandidat lp) throws SQLException;
}
