package fr.sigl.imoe.servlet.tp.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Objet métier représentant un événement.
 *
 * @author Chris
 */
public class Evenement implements Serializable {
    /**
     * UID de version pour la sérialisation.
     */
    public static final long serialVersionUID = 3413475441624576180L;
    /**
     * Identifiant technique.
     */
    private String id;
    /**
     * Titre de l'événement
     */
    private String titre;
    /**
     * Date de début de l'événement.
     */
    private Date dateDebut;
    /**
     * Date de fin de l'événement.
     */
    private Date dateFin;
    /**
     * Type d'événement
     */
    private TypeEvenement type;
    /**
     * Description de l'événement
     */
    private String description;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }
    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }
    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }
    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }
    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    /**
     * @return the type
     */
    public TypeEvenement getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(TypeEvenement type) {
        this.type = type;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
