/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author kouki
 */
public class Solution {

    private int idSolution ;

    private String titre ;

    private double salaire ;

    private String description ;

    private String fichierSolution ;

    private String etat ;

    private int MembreId ;

    private int ProblemeId ;

    public int getIdSolution() {
        return idSolution;
    }

    public void setIdSolution(int idSolution) {
        this.idSolution = idSolution;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFichierSolution() {
        return fichierSolution;
    }

    public void setFichierSolution(String fichierSolution) {
        this.fichierSolution = fichierSolution;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getMembreId() {
        return MembreId;
    }

    public void setMembreId(int MembreId) {
        this.MembreId = MembreId;
    }

    public int getProblemeId() {
        return ProblemeId;
    }

    public void setProblemeId(int ProblemeId) {
        this.ProblemeId = ProblemeId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idSolution;
        hash = 59 * hash + Objects.hashCode(this.titre);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salaire) ^ (Double.doubleToLongBits(this.salaire) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.fichierSolution);
        hash = 59 * hash + Objects.hashCode(this.etat);
        hash = 59 * hash + this.MembreId;
        hash = 59 * hash + this.ProblemeId;
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
        final Solution other = (Solution) obj;
        if (this.idSolution != other.idSolution) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (Double.doubleToLongBits(this.salaire) != Double.doubleToLongBits(other.salaire)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.fichierSolution, other.fichierSolution)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (this.MembreId != other.MembreId) {
            return false;
        }
        if (this.ProblemeId != other.ProblemeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Solution{" + "idSolution=" + idSolution + ", titre=" + titre + ", salaire=" + salaire + ", description=" + description + ", fichierSolution=" + fichierSolution + ", etat=" + etat + '}';
    }
    
    
    
}
