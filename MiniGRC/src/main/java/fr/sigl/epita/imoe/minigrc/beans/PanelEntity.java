package fr.sigl.epita.imoe.minigrc.beans;

import javax.persistence.*;

/**
 * Created by Chaf on 12/27/2015.
 */
@Entity
@Table(name = "panel", schema = "public", catalog = "minigrc")
public class PanelEntity {
    private int panelId;
    private String panelNom;
    private String panelAgemini;
    private String panelAgemaxi;
    private String panelRegion;
    private String panelProfil;

    @Id
    @Column(name = "panel_id")
    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    @Basic
    @Column(name = "panel_nom")
    public String getPanelNom() {
        return panelNom;
    }

    public void setPanelNom(String panelNom) {
        this.panelNom = panelNom;
    }

    @Basic
    @Column(name = "panel_agemini")
    public String getPanelAgemini() {
        return panelAgemini;
    }

    public void setPanelAgemini(String panelAgemini) {
        this.panelAgemini = panelAgemini;
    }

    @Basic
    @Column(name = "panel_agemaxi")
    public String getPanelAgemaxi() {
        return panelAgemaxi;
    }

    public void setPanelAgemaxi(String panelAgemaxi) {
        this.panelAgemaxi = panelAgemaxi;
    }

    @Basic
    @Column(name = "panel_region")
    public String getPanelRegion() {
        return panelRegion;
    }

    public void setPanelRegion(String panelRegion) {
        this.panelRegion = panelRegion;
    }

    @Basic
    @Column(name = "panel_profil")
    public String getPanelProfil() {
        return panelProfil;
    }

    public void setPanelProfil(String panelProfil) {
        this.panelProfil = panelProfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PanelEntity that = (PanelEntity) o;

        if (panelId != that.panelId) return false;
        if (panelNom != null ? !panelNom.equals(that.panelNom) : that.panelNom != null) return false;
        if (panelAgemini != null ? !panelAgemini.equals(that.panelAgemini) : that.panelAgemini != null) return false;
        if (panelAgemaxi != null ? !panelAgemaxi.equals(that.panelAgemaxi) : that.panelAgemaxi != null) return false;
        if (panelRegion != null ? !panelRegion.equals(that.panelRegion) : that.panelRegion != null) return false;
        if (panelProfil != null ? !panelProfil.equals(that.panelProfil) : that.panelProfil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = panelId;
        result = 31 * result + (panelNom != null ? panelNom.hashCode() : 0);
        result = 31 * result + (panelAgemini != null ? panelAgemini.hashCode() : 0);
        result = 31 * result + (panelAgemaxi != null ? panelAgemaxi.hashCode() : 0);
        result = 31 * result + (panelRegion != null ? panelRegion.hashCode() : 0);
        result = 31 * result + (panelProfil != null ? panelProfil.hashCode() : 0);
        return result;
    }
}
