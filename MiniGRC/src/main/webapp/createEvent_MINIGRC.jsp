<%@include file="includes/header.jsp"%>
<center>
    <form action="createevent" method="post">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Creation evenement</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Type:</td>
                <td>
                    <input name="type" value="" />
                </td>
                <td>Date de l'evenement (aaaa-mm-jj):</td>
                <td>
                    <input type="date" name="date" value="${date}">
                </td>
            </tr>
            <tr>
                <td>Utilisateur createur:</td>
                <td>
                    <input name="createur" value="${createur}">
                </td>
            </tr>
            <tr>
                <td>Description de l'evenement:</td>
                <td colspan="3">
                    <input name="description" value="" />
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <center>
                        <button style="margin: 30px" type="submit" id="submitButton">Valider</button>
                    </center>
                </td>
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
</center>
<%@include file="includes/footer.jsp"%>