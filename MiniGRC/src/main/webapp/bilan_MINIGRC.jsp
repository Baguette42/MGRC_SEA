<%@include file="includes/header.jsp"%>
<center>
    <form action="mainpage">
        <input type="hidden" id="isOwner" value="${isOwner}"/>
        <input type="hidden" id="isAdmin" value="${isAdmin}" }/>
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Bilan</b>
                    </center>
                </td>
            </tr>
        </table>
		<table cellpadding="10">
			<tr>
				<td>Nombre de clients sans adresse email valide:</td>
				<td>${bilan.clientsMailNonValides}</td>
			</tr>
			<tr>
				<td>Donn�es manquantes pour remplacement:</td>
				<td>${bilan.donn�esManquantes}</td>
			</tr>
			<tr>
				<td>Nombres de mails envoy�s:</td>
				<td>${bilan.mailsEnvoy�s}</td>
			</tr>

			<tr>
		</table>
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour � l'accueil" /></td>
			</tr>
		</table>
	</form>
</center><%@include file="includes/footer.jsp"%>