<%@include file="includes/header.jsp"%>
<center>
    <form action="createmail" name="email_creation">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Création mail</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Référence nom client:</td>
                <td>
                    &ltnom&gt
                </td>
                <td>Référence prenom client:</td>
                <td>
                    &ltprenom&gt
                </td>
            </tr>
            <tr>
                <td>Référence age client:</td>
                <td>
                    &ltage&gt
                </td>
                <td>Référence region geographique client:</td>
                <td>
                    &ltregion&gt
                </td>
            </tr>
            <tr>
            	<td colspan="4">
            	 <textarea rows="30" cols="80" form="email_creation">Bonjour &ltnom&gt,
            	 
Cordialement,
MiniGRC</textarea>
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