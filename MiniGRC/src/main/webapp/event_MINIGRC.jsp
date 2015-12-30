<%@include file="includes/header.jsp"%>
<center>
    <table>
        <tr>
            <td>
                <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                    <b>Informations evenement</b>
                </center>
            </td>
        </tr>
    </table>
    <form action="event?selectedEventId=${event.eventId}" id="edit" method="post" name="edit">
		<table cellpadding="10">
			<tr>
				<td>Type:</td>
				<td><input name="event_type" value="${event.eventType}" /></td>
				<td>Date de l'evenement:</td>
				<td><input type="date" name="event_date"
					value="${event.eventDate}"></td>
			</tr>
			<tr>
				<td>Utilisateur createur:</td>
				<td>${event.eventCreateur}</td>
			</tr>
			<tr>
				<td>Date de derniere modification:</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${event.eventLastupdate}"></fmt:formatDate></td>
				<td>Derniere modification par:</td>
				<td>${event.eventLastupdater}</td>
			</tr>
			<tr>
				<td>Description de l'evenement:</td>
				<td><input name="event_description"
					value="${event.eventDescription}" /></td>
			</tr>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Valider les modifications" /></td>
			</tr>

		</table>
	</form>
        	<form action="eventlist">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour à la liste des évènements" /></td>
			</tr>
		</table>
	</form>
</center><%@include file="includes/footer.jsp"%>
