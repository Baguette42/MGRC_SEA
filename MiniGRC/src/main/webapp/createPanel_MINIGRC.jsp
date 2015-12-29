<%@include file="includes/header.jsp"%>
<center>
    <form action="createpanel" method="post">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Creation panel</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Nom du panel:</td>
                <td>
                    <input name="name" value="" />
                </td>
            </tr>
            <tr>
                <td>Age minimum:</td>
                <td>
                    <input type="number" name="min_age" value="">
                </td>
                <td>Age maximum:</td>
                <td>
                    <input type="number" name="max_age" value="">
                </td>
            </tr>
            <tr>
                <td>Zone geographique:</td>
                <td>
                    <select name="region">
                        <option value="grand sud">Grand Sud</option>
                        <option value="grand ouest">Grand Ouest</option>
                        <option value="grand est">Grand Est</option>
                        <option value="grand nord">Grand Nord</option>
                    </select>
                </td>
                <td>Type de profil concerne:</td>
                <td>
                    <select name="type">
                        <option value="prospect">Prospect</option>
                        <option value="client">Client</option>
                        <option value="both">Prospect et client</option>
                    </select>
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
    	<form action="panellist">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour à la liste des panels" /></td>
			</tr>
		</table>
	</form>
</center><%@include file="includes/footer.jsp"%>