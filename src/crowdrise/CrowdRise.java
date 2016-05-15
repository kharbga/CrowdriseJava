/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdrise;

import GUI.JProfil;
import dao.NotificationDAO;
import dao.ProfilDAO;
import entities.Profil;
import java.util.Date;

/**
 *
 * @author kouki
 */
public class CrowdRise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JProfil profil = new JProfil();
        profil.setVisible(true);
//        NotificationDAO ndao = new NotificationDAO() ;
//        System.out.println(ndao.findAll());
          Profil p1 = new Profil(0, "Adel", "Ayedi", new Date(28/03/2016), "kjqkd", "lhjh", "lgjhj", "lgljg");
           ProfilDAO pdao = new ProfilDAO();
           pdao.update(p1);
//        System.out.println(pdao.findById(104));

    }

}
