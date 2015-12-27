package fr.sigl.epita.imoe.minigrc.beans;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Chaf on 12/27/2015.
 */
@Entity
@Table(name = "evenement", schema = "public", catalog = "minigrc")
public class EvenementEntity {
    private int eventId;
    private String eventType;
    private Date eventDate;
    private String eventCreateur;
    private Date eventLastupdate;
    private String eventLastupdater;
    private String eventDescription;

    @Id
    @Column(name = "event_id")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "event_type")
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "event_date")
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Basic
    @Column(name = "event_createur")
    public String getEventCreateur() {
        return eventCreateur;
    }

    public void setEventCreateur(String eventCreateur) {
        this.eventCreateur = eventCreateur;
    }

    @Basic
    @Column(name = "event_lastupdate")
    public Date getEventLastupdate() {
        return eventLastupdate;
    }

    public void setEventLastupdate(Date eventLastupdate) {
        this.eventLastupdate = eventLastupdate;
    }

    @Basic
    @Column(name = "event_lastupdater")
    public String getEventLastupdater() {
        return eventLastupdater;
    }

    public void setEventLastupdater(String eventLastupdater) {
        this.eventLastupdater = eventLastupdater;
    }

    @Basic
    @Column(name = "event_description")
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvenementEntity that = (EvenementEntity) o;

        if (eventId != that.eventId) return false;
        if (eventType != null ? !eventType.equals(that.eventType) : that.eventType != null) return false;
        if (eventDate != null ? !eventDate.equals(that.eventDate) : that.eventDate != null) return false;
        if (eventCreateur != null ? !eventCreateur.equals(that.eventCreateur) : that.eventCreateur != null)
            return false;
        if (eventLastupdate != null ? !eventLastupdate.equals(that.eventLastupdate) : that.eventLastupdate != null)
            return false;
        if (eventLastupdater != null ? !eventLastupdater.equals(that.eventLastupdater) : that.eventLastupdater != null)
            return false;
        if (eventDescription != null ? !eventDescription.equals(that.eventDescription) : that.eventDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventId;
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (eventDate != null ? eventDate.hashCode() : 0);
        result = 31 * result + (eventCreateur != null ? eventCreateur.hashCode() : 0);
        result = 31 * result + (eventLastupdate != null ? eventLastupdate.hashCode() : 0);
        result = 31 * result + (eventLastupdater != null ? eventLastupdater.hashCode() : 0);
        result = 31 * result + (eventDescription != null ? eventDescription.hashCode() : 0);
        return result;
    }
}
