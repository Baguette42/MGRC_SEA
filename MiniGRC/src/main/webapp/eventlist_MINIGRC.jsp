<%@include file="includes/header.jsp" %>
<center>
	<table cellpadding="10">
		<form action="eventlist">
			<tr>
				<td>Type :</td>
				<td><input name="type_searchform" value="" /></td>
				<td>Date (aaaa-mm-jj):</td>
				<td><input name="date_searchform" value="" /></td>
				<td class="searchButtonTd">
					<button type="submit" class="searchbutton" name="search_button">Rechercher</button>
				</td>
			</tr>
		</form>
		<!--
        <tr>
			<td>
				<form action="createevent" method="get">
					<button type="submit" id="createEventButton">Ajouter un evenement</button>
				</form>
			</td>
		</tr>
		-->

		<tr>
			<table cellpadding="10">
				<tr>
					<td>
						<center style="font-size: 16px">
							<b>Evenements</b>
						</center>
					</td>
				</tr>
				<tr>
					<td colspan="2">
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
										<td><a href="event?selectedEventId=${event.eventId}">${event.eventType}</a>
										</td>
										<td><a href="event?selectedEventId=${event.eventId}">
												<fmt:formatDate pattern="yyyy-MM-dd"
													value="${event.eventDate}"></fmt:formatDate>
										</a></td>
										<td><a href="event?selectedEventId=${event.eventId}">${event.eventDescription}</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
					<td></td>
				</tr>
			</table>
		</tr>
	</table>
	<form action="mainpage">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour à l'accueil" /></td>
			</tr>
		</table>
	</form>
</center><%@include file="includes/footer.jsp"%>