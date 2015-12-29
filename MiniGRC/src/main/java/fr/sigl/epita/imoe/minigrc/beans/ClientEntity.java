package fr.sigl.epita.imoe.minigrc.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Chaf on 12/27/2015.
 */
@Entity
@Table(name = "client", schema = "public", catalog = "minigrc")
public class ClientEntity implements Serializable {
    private int clientId;
    private String clientNom;
    private String clientPrenom;
    private String clientCivilite;
    private Date clientNaissance;
    private String clientAdresse;
    private String clientTelephone;
    private String clientEmail;
    private String clientFacebook;
    private String clientTwitter;
    private String clientLinkedin;
    private String clientProfil;
    private String clientRegion;
    private boolean clientEmailrefus;
    private Date clientDatecreation;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="client_client_id_seq")
    @SequenceGenerator(name="client_client_id_seq", sequenceName="client_client_id_seq", allocationSize = 1)
    @Column(name = "client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "client_nom")
    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    @Basic
    @Column(name = "client_prenom")
    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    @Basic
    @Column(name = "client_civilite")
    public String getClientCivilite() {
        return clientCivilite;
    }

    public void setClientCivilite(String clientCivilite) {
        this.clientCivilite = clientCivilite;
    }

    @Basic
    @Column(name = "client_naissance")
    public Date getClientNaissance() {
        return clientNaissance;
    }

    public void setClientNaissance(Date clientNaissance) {
        this.clientNaissance = clientNaissance;
    }

    @Basic
    @Column(name = "client_adresse")
    public String getClientAdresse() {
        return clientAdresse;
    }

    public void setClientAdresse(String clientAdresse) {
        this.clientAdresse = clientAdresse;
    }

    @Basic
    @Column(name = "client_telephone")
    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    @Basic
    @Column(name = "client_email")
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Basic
    @Column(name = "client_facebook")
    public String getClientFacebook() {
        return clientFacebook;
    }

    public void setClientFacebook(String clientFacebook) {
        this.clientFacebook = clientFacebook;
    }

    @Basic
    @Column(name = "client_twitter")
    public String getClientTwitter() {
        return clientTwitter;
    }

    public void setClientTwitter(String clientTwitter) {
        this.clientTwitter = clientTwitter;
    }

    @Basic
    @Column(name = "client_linkedin")
    public String getClientLinkedin() {
        return clientLinkedin;
    }

    public void setClientLinkedin(String clientLinkedin) {
        this.clientLinkedin = clientLinkedin;
    }

    @Basic
    @Column(name = "client_profil")
    public String getClientProfil() {
        return clientProfil;
    }

    public void setClientProfil(String clientProfil) {
        this.clientProfil = clientProfil;
    }

    @Basic
    @Column(name = "client_region")
    public String getClientRegion() {
        return clientRegion;
    }

    public void setClientRegion(String clientRegion) {
        this.clientRegion = clientRegion;
    }

    @Basic
    @Column(name = "client_emailrefus")
    public boolean isClientEmailrefus() {
        return clientEmailrefus;
    }

    public void setClientEmailrefus(boolean clientEmailrefus) {
        this.clientEmailrefus = clientEmailrefus;
    }

    @Basic
    @Column(name = "client_datecreation")
    public Date getClientDatecreation() {
        return clientDatecreation;
    }

    public void setClientDatecreation(Date clientDatecreation) {
        this.clientDatecreation = clientDatecreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (clientEmailrefus != that.clientEmailrefus) return false;
        if (clientNom != null ? !clientNom.equals(that.clientNom) : that.clientNom != null) return false;
        if (clientPrenom != null ? !clientPrenom.equals(that.clientPrenom) : that.clientPrenom != null) return false;
        if (clientCivilite != null ? !clientCivilite.equals(that.clientCivilite) : that.clientCivilite != null)
            return false;
        if (clientNaissance != null ? !clientNaissance.equals(that.clientNaissance) : that.clientNaissance != null)
            return false;
        if (clientAdresse != null ? !clientAdresse.equals(that.clientAdresse) : that.clientAdresse != null)
            return false;
        if (clientTelephone != null ? !clientTelephone.equals(that.clientTelephone) : that.clientTelephone != null)
            return false;
        if (clientEmail != null ? !clientEmail.equals(that.clientEmail) : that.clientEmail != null) return false;
        if (clientFacebook != null ? !clientFacebook.equals(that.clientFacebook) : that.clientFacebook != null)
            return false;
        if (clientTwitter != null ? !clientTwitter.equals(that.clientTwitter) : that.clientTwitter != null)
            return false;
        if (clientLinkedin != null ? !clientLinkedin.equals(that.clientLinkedin) : that.clientLinkedin != null)
            return false;
        if (clientProfil != null ? !clientProfil.equals(that.clientProfil) : that.clientProfil != null) return false;
        if (clientRegion != null ? !clientRegion.equals(that.clientRegion) : that.clientRegion != null) return false;
        if (clientDatecreation != null ? !clientDatecreation.equals(that.clientDatecreation) : that.clientDatecreation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (clientNom != null ? clientNom.hashCode() : 0);
        result = 31 * result + (clientPrenom != null ? clientPrenom.hashCode() : 0);
        result = 31 * result + (clientCivilite != null ? clientCivilite.hashCode() : 0);
        result = 31 * result + (clientNaissance != null ? clientNaissance.hashCode() : 0);
        result = 31 * result + (clientAdresse != null ? clientAdresse.hashCode() : 0);
        result = 31 * result + (clientTelephone != null ? clientTelephone.hashCode() : 0);
        result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
        result = 31 * result + (clientFacebook != null ? clientFacebook.hashCode() : 0);
        result = 31 * result + (clientTwitter != null ? clientTwitter.hashCode() : 0);
        result = 31 * result + (clientLinkedin != null ? clientLinkedin.hashCode() : 0);
        result = 31 * result + (clientProfil != null ? clientProfil.hashCode() : 0);
        result = 31 * result + (clientRegion != null ? clientRegion.hashCode() : 0);
        result = 31 * result + (clientEmailrefus ? 1 : 0);
        result = 31 * result + (clientDatecreation != null ? clientDatecreation.hashCode() : 0);
        return result;
    }
}
