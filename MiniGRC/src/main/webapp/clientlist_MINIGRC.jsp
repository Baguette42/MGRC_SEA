<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
		<form action="clientlist">
			<tr>
				<td>Nom :</td>
				<td><input name="lastname_searchform" value="" /></td>
				<td>Prenom :</td>
				<td><input name="firstname_searchform" value="" /></td>
				<td class="searchButtonTd">
					<button type="submit" class="searchbutton" name="search_button">Rechercher</button>
				</td>
			</tr>
		</form>
		<tr>
			<td>
				<form action="createclient" method="get">
					<button type="submit" id="createClientButton">Ajouter un client</button>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<center style="font-size: 16px">
					<b>Clients</b>
				</center>
			</td>
		</tr>
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
						<td><a href="client?selectedClientId=${client.clientId}">${client.clientCivilite}</a>
						</td>
						<td><a href="client?selectedClientId=${client.clientId}">${client.clientNom}</a>
						</td>
						<td><a href="client?selectedClientId=${client.clientId}">${client.clientPrenom}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
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

</center>
<%@include file="includes/footer.jsp"%>