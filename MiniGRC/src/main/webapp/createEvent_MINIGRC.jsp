<%@include file="includes/header.jsp"%>
<center>
    <form action="create_event">
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Cr�ation �v�nement</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Type:</td>
                <td>
                    <input name=event_type value="" />
                </td>
                <td>Date de l'�v�nement:</td>
                <td>
                    <input type="date" name="event_date" value="">
                    </td>
                </tr>
                <tr>
                    <td>Utilisateur cr�ateur:</td>
                    <td>${event.createur}</td>
                </tr>
                <tr>
                    <td>Description de l'�v�nement:</td>
                    <td colspan="3">
                        <input name=event_type value="" />
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
    </center>
<%@include file="includes/footer.jsp"%>