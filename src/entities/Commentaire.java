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
public class Commentaire {

    private int idCommentaire;

    private String description;

    private Date dateCommentaire;

    private int Projetid;

    private int Membreid;

    public Commentaire() {
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public int getProjetid() {
        return Projetid;
    }

    public void setProjetid(int Projetid) {
        this.Projetid = Projetid;
    }

    public int getMembreid() {
        return Membreid;
    }

    public void setMembreid(int Membreid) {
        this.Membreid = Membreid;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", description=" + description + ", dateCommentaire=" + dateCommentaire + ", Projetid=" + Projetid + ", Membreid=" + Membreid + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idCommentaire;
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.dateCommentaire);
        hash = 37 * hash + this.Projetid;
        hash = 37 * hash + this.Membreid;
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
        final Commentaire other = (Commentaire) obj;
        if (this.idCommentaire != other.idCommentaire) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.dateCommentaire, other.dateCommentaire)) {
            return false;
        }
        if (this.Projetid != other.Projetid) {
            return false;
        }
        if (this.Membreid != other.Membreid) {
            return false;
        }
        return true;
    }
    

}
