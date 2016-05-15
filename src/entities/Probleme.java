/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.Objects;
 
public class Probleme {

    private int idProbleme;

    private String titre;

    private String description;

    private Date dateProbleme;

    private Date deadlineProbleme;

    private String fichierProbleme;
    
    private String categorie;

    private int MembreId;

    public Probleme() {
    }

    public Probleme(int idProbleme, String titre, String description, Date deadlineProbleme, String fichierProbleme, String categorie) {
        this.idProbleme = idProbleme;
        this.titre = titre;
        this.description = description;
        this.deadlineProbleme = deadlineProbleme;
        this.fichierProbleme = fichierProbleme;
        this.categorie = categorie;
    }
     

    public int getIdProbleme() {
        return idProbleme;
    }

    public void setIdProbleme(int idProbleme) {
        this.idProbleme = idProbleme;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateProbleme() {
        return dateProbleme;
    }

    public void setDateProbleme(Date dateProbleme) {
        this.dateProbleme = dateProbleme;
    }

    public Date getDeadlineProbleme() {
        return deadlineProbleme;
    }

    public void setDeadlineProbleme(Date deadlineProbleme) {
        this.deadlineProbleme = deadlineProbleme;
    }

    public String getFichierProbleme() {
        return fichierProbleme;
    }

    public void setFichierProbleme(String fichierProbleme) {
        this.fichierProbleme = fichierProbleme;
    }

    public int getMembreId() {
        return MembreId;
    }

    public void setMembreId(int MembreId) {
        this.MembreId = MembreId;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Probleme{" + "idProbleme=" + idProbleme + ", titre=" + titre + ", description=" + description + ", dateProbleme=" + dateProbleme + ", deadlineProbleme=" + deadlineProbleme + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idProbleme;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.deadlineProbleme);
        hash = 67 * hash + Objects.hashCode(this.fichierProbleme);
        hash = 67 * hash + Objects.hashCode(this.categorie);
        hash = 67 * hash + this.MembreId;
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
        final Probleme other = (Probleme) obj;
        if (this.idProbleme != other.idProbleme) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.deadlineProbleme, other.deadlineProbleme)) {
            return false;
        }
        if (!Objects.equals(this.fichierProbleme, other.fichierProbleme)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (this.MembreId != other.MembreId) {
            return false;
        }
        return true;
    }

    

     
    

}
