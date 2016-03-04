/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author kouki
 */
public class Probleme {

    private int idProbleme;

    private String titre;

    private String description;

    private Date dateProbleme;

    private Date deadlineProbleme;

    private String fichierProbleme;

    private int MembreId;

    public Probleme() {
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

    @Override
    public String toString() {
        return "Probleme{" + "idProbleme=" + idProbleme + ", titre=" + titre + ", description=" + description + ", dateProbleme=" + dateProbleme + ", deadlineProbleme=" + deadlineProbleme + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idProbleme;
        hash = 47 * hash + Objects.hashCode(this.titre);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.dateProbleme);
        hash = 47 * hash + Objects.hashCode(this.deadlineProbleme);
        hash = 47 * hash + Objects.hashCode(this.fichierProbleme);
        hash = 47 * hash + this.MembreId;
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
        if (this.MembreId != other.MembreId) {
            return false;
        }
        return true;
    }
    

}
