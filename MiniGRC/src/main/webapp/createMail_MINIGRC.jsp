<%@include file="includes/header.jsp"%>
<center>
    <form action="createemail" name="email_creation" method="post">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Creation mail</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Reference nom client:</td>
                <td>
                    &ltnom&gt
                </td>
                <td>Reference prenom client:</td>
                <td>
                    &ltprenom&gt
                </td>
            </tr>
            <tr>
                <td>Reference age client:</td>
                <td>
                    &ltage&gt
                </td>
                <td>Reference region geographique client:</td>
                <td>
                    &ltregion&gt
                </td>
            </tr>
            <tr>
                <td colspan="4">
            	 <textarea rows="30" cols="80" name="message">
                     Bonjour &ltnom&gt,

                     Cordialement,
                     MiniGRC
                 </textarea>
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