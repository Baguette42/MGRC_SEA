<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <center>
            <form action="createclient" method="post">
                <table>
                    <tr>
                        <td>
                            <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                                <b>Ajout d'un client</b>
                            </center>
                        </td>
                    </tr>
                </table>
                <table cellpadding="10">
                    <tr>
                        <td>Civilite:</td>
                        <td>
                            <select name="client_civilite">
                                <option value="Monsieur">Monsieur</option>
                                <option value="Madame">Madame</option>
                            </select>
                        </td>
                        <td>Date de naissance (aaaa-mm-jj):</td>
                        <td>
                            <input type="date" name="client_date" value="">
                        </td>
                    </tr>
                    <tr>
                        <td>Nom:</td>
                        <td><input name="client_nom" value="" /></td>
                        <td>Prenom:</td>
                        <td><input name="client_prenom" value="" /></td>
                    </tr>
                    <tr>
                        <td>Adresse:</td>
                        <td colspan=3><input name="client_adresse" value="" /></td>
                    </tr>
                    <tr>
                        <td>Telephone:</td>
                        <td><input name="client_telephone" value="" /></td>
                        <td>E-mail:</td>
                        <td><input name="client_email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Facebook:</td>
                        <td><input name="client_facebook" value="" /></td>
                        <td>Twitter:</td>
                        <td><input name="client_twitter" value="" /></td>
                    </tr>
                    <tr>
                        <td>LinkedIn:</td>
                        <td><input name="client_linkedin" value="" /></td>
                    </tr>
                    <tr>
                        <td>Prospect/Client:</td>
                        <td>
                            <select name="client_type">
                                <option value="prospect">Prospect</option>
                                <option value="client">Client</option>
                            </select>
                        </td>
                        <td>Region geographique:</td>
                        <td>
                            <select name="client_region">
                                <option value="grand sud">Grand Sud</option>
                                <option value="grand ouest">Grand Ouest</option>
                                <option value="grand est">Grand Est</option>
                                <option value="grand nord">Grand Nord</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Refus e-mailing?:</td>
                        <td><input type="checkbox" name="client_emailing" id="emailRefus"/></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td>
                            <input style="margin: 30px" type="submit" value="Valider"/>
                        </td>
                    </tr>
                </table>
            </form>
            	<form action="clientlist">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour � la liste des clients" /></td>
			</tr>
		</table>
	</form>
        </center>