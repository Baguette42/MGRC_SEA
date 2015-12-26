<%@include file="includes/header.jsp"%>
<center>
    <form action="create_panel">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Création panel</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Nom du panel:</td>
                <td>
                    <input name=panel_name value="" />
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
                        <td>Zone géographique:</td>
                        <td>
                            <input name=event_type value="" />
                        </td>
                        <td>Type de profil concerné:</td>
                        <td>
                            <select name="client_type">
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
       </center><%@include file="includes/footer.jsp"%>