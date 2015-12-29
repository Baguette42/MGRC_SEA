<%@include file="includes/header.jsp" %>
<center>
	<table cellpadding="10">
		<center>
			<tr>
				<td>
					<form action="panellist" method="get">
						<button type="submit" id="panelListButton">Acceder a la liste des panels existants</button>
					</form>
				</td>
				<td>
					<form action="clientlist" method="get">
						<button type="submit" id="clientListButton">Acceder a
							l'ensemble des fiches clients</button>
					</form>
				</td>
			</tr>
			<td>
				<form action="eventlist" method="get">
					<button type="submit" id="eventListButton">Acceder aux evenements</button>
				</form>
			</td>
			<td>
				<form action="bilan" method="get">
					<button type="submit" id="bilanButton">Acceder au bilan</button>
				</form>
			</td>
			</tr>
		</center>

		<tr>
			<td><center style="font-size: 16px">
				<b>Derniers evenements clients</b>
			</center></td>
			<td><center style="font-size: 16px">
				<b>Nouveaux clients depuis la derniere connexion</b>
			</center></td>

		</tr>
		<tr>
			<td>
				<table border="1" cellpadding="10" width="40%">
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
							<td><a href="event?selectedEventId=${event.eventId}">${event.eventType}</a></td>
							<td><a href="event?selectedEventId=${event.eventId}"><fmt:formatDate
								pattern="dd/MM/yyyy" value="${event.eventDate}"></fmt:formatDate></a></td>
							<td><a href="event?selectedEventId=${event.eventId}">${event.eventDescription}</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</td>
			<td>
				<table border="1" cellpadding="10" width="40%">
					<thead bgcolor="B8D2FF">
					<tr>
						<th>Civilite</th>
						<th>Nom</th>
						<th>Prenom</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="client" items="${clientList}">
						<tr>
							<td><a href="client?selectedclientId=${client.clientId}">${client.clientCivilite}</a></td>
							<td><a href="client?selectedclientId=${client.clientId}">${client.clientNom}</a></td>
							<td><a href="client?selectedclientId=${client.clientId}">${client.clientPrenom}</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</center>
<%@include file="includes/footer.jsp" %>
