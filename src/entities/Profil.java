/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sedki
 */
public class Profil {
    private int id ;
    private String Nom ;
    private String Prenom ;
    private Date dateNaissance ;
    private String Pseudo ;
    private String Image ;
    private String Adresse ;
    private String Profession ;

    public Profil(int id, String Nom, String Prenom, Date dateNaissance, String Pseudo, String Image, String Adresse, String Profession) {
        this.id = id;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.dateNaissance = dateNaissance;
        this.Pseudo = Pseudo;
        this.Image = Image;
        this.Adresse = Adresse;
        this.Profession = Profession;
    }

    public Profil() {
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String Pseudo) {
        this.Pseudo = Pseudo;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.Nom);
        hash = 97 * hash + Objects.hashCode(this.Prenom);
        hash = 97 * hash + Objects.hashCode(this.dateNaissance);
        hash = 97 * hash + Objects.hashCode(this.Pseudo);
        hash = 97 * hash + Objects.hashCode(this.Image);
        hash = 97 * hash + Objects.hashCode(this.Adresse);
        hash = 97 * hash + Objects.hashCode(this.Profession);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profil other = (Profil) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.dateNaissance, other.dateNaissance)) {
            return false;
        }
        if (!Objects.equals(this.Pseudo, other.Pseudo)) {
            return false;
        }
        if (!Objects.equals(this.Image, other.Image)) {
            return false;
        }
        if (!Objects.equals(this.Adresse, other.Adresse)) {
            return false;
        }
        if (!Objects.equals(this.Profession, other.Profession)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profil{" + "id=" + id + ", Nom=" + Nom + ", Prenom=" + Prenom + ", dateNaissance=" + dateNaissance + ", Pseudo=" + Pseudo + ", Image=" + Image + ", Adresse=" + Adresse + ", Profession=" + Profession + '}';
    }
    
    
        
}
