<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <center>
            
                <input type="hidden" id="isOwner" value="${isOwner}"/>
                <input type="hidden" id="isAdmin" value="${isAdmin}"/>
                <table>
                    <tr>
                        <td>
                            <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                                <b>Informations client</b>
                            </center>
                        </td>
                    </tr>
                </table>
				<form action="client?selectedClientId=${client.clientId}" id="edit" method="post" name="edit">
                <table cellpadding="10">
                    <tr>
                        <td>Civilite:</td>
                        <td><input name="client_civilite" value="${client.clientCivilite}"/></td>
                        <td>Date de naissance:</td>
                        <td>
                            <td>Date de naissance (aaaa-mm-jj):</td>
                        <td>
                            <input type="date" name="client_date" value="${client.clientNaissance}">
                        </td>
                        </td>
                    </tr>
                    <tr>
                        <td>Nom:</td>
                        <td><input name="client_nom" value="${client.clientNom}"/></td>
                        <td>Prenom:</td>
                        <td><input name="client_prenom" value="${client.clientPrenom}"/></td>
                    </tr>
                    <tr>
                        <td>Adresse:</td>
                        <td colspan=3><input name="client_adresse" value="${client.clientAdresse}"/></td>
                    </tr>
                    <tr>
                        <td>Telephone:</td>
                        <td><input name="client_telephone" value="${client.clientTelephone}"/></td>
                        <td>E-mail:</td>
                        <td><input name="client_email" value="${client.clientEmail}"/></td>
                    </tr>
                    <tr>
                        <td>
                            <a href="${client.clientFacebook}">Facebook</a>
                        </td>
                        <td>
                            <a href="${client.clientTwitter}">Twitter</a>
                        </td>
                        <td>
                            <a href="${client.clientLinkedin}">LinkedIn</a>
                        </td>
                    </tr>
                    <tr>
                        <td>Prospect/Client:</td>
                        <td>                        <td>
                            <select name="client_type">
                                <option value="prospect">Prospect</option>
                                <option value="client">Client</option>
                            </select></td>
                        <td>Region geographique:</td>
                        <td>                         <select name="client_region">
                                <option value="grand sud">Grand Sud</option>
                                <option value="grand ouest">Grand Ouest</option>
                                <option value="grand est">Grand Est</option>
                                <option value="grand nord">Grand Nord</option>
                            </select>
</td>
                    </tr>
                    <tr>
                        <td>Refus e-mailing?:</td>
                        <td>
                            <input type="checkbox" id="emailRefus" name="isVerified" value="${client.clientEmailrefus}" disabled="disabled" />
                        </td>
                    </tr>
                    </form>
                    </table>
                    
                    <table border="1" cellpadding="10" width="60%">
                        <thead bgcolor="B8D2FF">
                        <tr>
                            <th>Type</th>
                            <th>Date</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="event" items="${eventList}">
                            <tr>
                                <td>
                                    <a href="event?selectedEventId=${event.eventId}">${event.eventType}</a>
                                </td>
                                <td>
                                    <a href="event?selectedEventId=${event.eventId}">
                                        <fmt:formatDate
                                                pattern="yyyy-MM-dd" value="${event.eventDate}"></fmt:formatDate>
                                    </a>
                                </td>
                                <td>
                                    <a href="event?selectedEventId=${event.eventId}">${event.eventDescription}</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                   
                </table>
				<form action="createevent" method="get">
                <table>
                    <tr>
                        <td>
                            <input style="margin: 30px" type="submit" value="Ajouter un evenement"/>
                        </td>
                    </tr>
                </table>
                </form>
                <table>
				<tr>
                        <td>
                            <input form="edit" style="margin: 30px" type="submit" value="Valider les modifications"/>
                        </td>
                    </tr>
                </table>
                 
	<form action="clientlist">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour à la liste des clients" /></td>
			</tr>
		</table>
	</form>
            
        </center>