<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
		<form action="search">
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
					<th>Civilité</th>
					<th>Nom</th>
					<th>Prénom</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a class="clientrow" href="client?selectedclientId=1">M.</a>
					</td>
					<td><a class="clientrow" href="client?selectedclientId=1">Flantier</a>
					</td>
					<td><a class="clientrow" href="client?selectedclientId=1">Noël</a>
					</td>
				</tr>
				<c:forEach var="client" items="${clientList}">
					<tr>
						<td><a href="client?selectedclientId=${client.id}">${client.civilite}</a>
						</td>
						<td><a href="client?selectedclientId=${client.id}">${client.nom}</a>
						</td>
						<td><a href="client?selectedclientId=${client.id}">${client.prenom}</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</tr>
</table>
    
</center><%@include file="includes/footer.jsp"%>