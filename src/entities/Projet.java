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
public class Projet {

    private int idProjet;

    private String titre;

    private String description;

    private String typeFinancement;

    private Date dateProjet;

    private Date deadlineProjet;

    private String fichierProjet;

    private int MembreId;

    private String imageProjet;

    private String videoProjet;

    private int idcat;

    public Projet() {
    }

    public Projet(String titre, String description, String typeFinancement, Date dateProjet, Date deadlineProjet, String fichierProjet, int MembreId, String imageProjet, String videoProjet, int idcat) {

        this.titre = titre;
        this.description = description;
        this.typeFinancement = typeFinancement;
        this.dateProjet = dateProjet;
        this.deadlineProjet = deadlineProjet;
        this.fichierProjet = fichierProjet;
        this.MembreId = MembreId;
        this.imageProjet = imageProjet;
        this.videoProjet = videoProjet;
        this.idcat = idcat;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
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

    public String getTypeFinancement() {
        return typeFinancement;
    }

    public void setTypeFinancement(String typeFinancement) {
        this.typeFinancement = typeFinancement;
    }

    public Date getDateProjet() {
        return dateProjet;
    }

    public void setDateProjet(Date dateProjet) {
        this.dateProjet = dateProjet;
    }

    public Date getDeadlineProjet() {
        return deadlineProjet;
    }

    public void setDeadlineProjet(Date deadlineProjet) {
        this.deadlineProjet = deadlineProjet;
    }

    public String getFichierProjet() {
        return fichierProjet;
    }

    public void setFichierProjet(String fichierProjet) {
        this.fichierProjet = fichierProjet;
    }

    public int getMembreId() {
        return MembreId;
    }

    public void setMembreId(int MembreId) {
        this.MembreId = MembreId;
    }

    public String getImageProjet() {
        return imageProjet;
    }

    public void setImageProjet(String imageProjet) {
        this.imageProjet = imageProjet;
    }

    public String getVideoProjet() {
        return videoProjet;
    }

    public void setVideoProjet(String videoProjet) {
        this.videoProjet = videoProjet;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idProjet;
        hash = 83 * hash + Objects.hashCode(this.titre);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.typeFinancement);
        hash = 83 * hash + Objects.hashCode(this.dateProjet);
        hash = 83 * hash + Objects.hashCode(this.deadlineProjet);
        hash = 83 * hash + Objects.hashCode(this.fichierProjet);
        hash = 83 * hash + this.MembreId;
        hash = 83 * hash + Objects.hashCode(this.imageProjet);
        hash = 83 * hash + Objects.hashCode(this.videoProjet);
        hash = 83 * hash + this.idcat;
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
        final Projet other = (Projet) obj;
        if (this.idProjet != other.idProjet) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.typeFinancement, other.typeFinancement)) {
            return false;
        }
        if (!Objects.equals(this.dateProjet, other.dateProjet)) {
            return false;
        }
        if (!Objects.equals(this.deadlineProjet, other.deadlineProjet)) {
            return false;
        }
        if (!Objects.equals(this.fichierProjet, other.fichierProjet)) {
            return false;
        }
        if (this.MembreId != other.MembreId) {
            return false;
        }
        if (!Objects.equals(this.imageProjet, other.imageProjet)) {
            return false;
        }
        if (!Objects.equals(this.videoProjet, other.videoProjet)) {
            return false;
        }
        if (this.idcat != other.idcat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projet{" + "idProjet=" + idProjet + ", titre=" + titre + ", description=" + description + ", typeFinancement=" + typeFinancement + ", dateProjet=" + dateProjet + ", deadlineProjet=" + deadlineProjet + ", fichierProjet=" + fichierProjet + ", MembreId=" + MembreId + ", imageProjet=" + imageProjet + ", videoProjet=" + videoProjet + '}';
    }

}
