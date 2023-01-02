/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.praktikumpbo.crudmahasiswasederhana;

import javax.swing.SwingUtilities;
import views.MahasiswaFrame;

/**
 *
 * @author Putri
 */
public class CRUDMahasiswaSederhana {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           
            public void run() {
                MahasiswaFrame form = new MahasiswaFrame();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }
}
