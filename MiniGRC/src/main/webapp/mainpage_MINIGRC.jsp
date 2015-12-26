<%@include file="includes/header.jsp" %>
<center>
	<table cellpadding="10">
<center>
		<tr>
    			<td>
				<form action="panellist" method="get">
					<button type="submit" id="panelListButton">Acc�der � la liste des panels existants</button>
				</form>
			</td>
			<td>
				<form action="clientlist" method="get">
					<button type="submit" id="clientListButton">Acc�der �
						l'ensemble des fiches clients</button>
				</form>
			</td>
		</tr>
    		<td>
				<form action="eventlist" method="get">
					<button type="submit" id="eventListButton">Acc�der aux �v�nements</button>
				</form>
			</td>
			<td>
				<form action="bilan" method="get">
					<button type="submit" id="bilanButton">Acc�der au bilan</button>
				</form>
			</td>
		</tr>
		</center>

		<tr>
			<td><center style="font-size: 16px">
					<b>Derniers �v�nements clients</b>
				</center></td>
			<td><center style="font-size: 16px">
					<b>Nouveaux clients depuis la derni�re connexion</b>
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
					<tr>
						<td><a class="eventrow" href="event?selectedEventId=1">Test</a></td>
						<td><a class="eventrow" href="event?selectedEventId=1">10/02/2012</a></td>
						<td><a class="eventrow" href="event?selectedEventId=1">Super
								�v�nement</a></td>

					</tr>
					<c:forEach var="event" items="${eventList}">
						<tr>
							<td><a href="event?selectedEventId=${event.id}">${event.type}</a></td>
							<td><a href="event?selectedEventId=${event.id}"><fmt:formatDate
										pattern="dd/MM/yyyy" value="${event.date}"></fmt:formatDate></a></td>
							<td><a href="event?selectedEventId=${event.id}">${event.description}</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
      </td>
      <td>
			<table border="1" cellpadding="10" width="40%">
				<thead bgcolor="B8D2FF">
					<tr>
						<th>Civilit�</th>
						<th>Nom</th>
						<th>Pr�nom</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a class="clientrow" href="client?selectedclientId=1">M.</a></td>
						<td><a class="clientrow" href="client?selectedclientId=1">Flantier</a></td>
						<td><a class="clientrow" href="client?selectedclientId=1">No�l</a></td>

					</tr>
					<c:forEach var="client" items="${clientList}">
						<tr>
							<td><a href="client?selectedclientId=${client.id}">${client.civilite}</a></td>
							<td><a href="client?selectedclientId=${client.id}">${client.nom}</a></td>
							<td><a href="client?selectedclientId=${client.id}">${client.prenom}</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
</td>
		</tr>

	</table>
</center>
<%@include file="includes/footer.jsp" %>
