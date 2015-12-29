<%@include file="includes/header.jsp"%>
<center>
    <table>
        <tr>
            <td>
                <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                    <b>Informations evenement</b>
                </center>
            </td>
        </tr>
    </table>
    <table cellpadding="10">
        <tr>
            <td>Type:</td>
            <td>${event.eventType}</td>
            <td>Date de l'evenement:</td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${event.eventDate}"></fmt:formatDate>
            </td>
        </tr>
        <tr>
            <td>Utilisateur createur:</td>
            <td>${event.eventCreateur}</td>
        </tr>
        <tr>
            <td>Date de derniere modification:</td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${event.eventLastupdate}"></fmt:formatDate>
            </td>
            <td>Derniere modification par:</td>
            <td>${event.eventLastupdater}</td>
        </tr>
        <tr>
            <td>Description de l'evenement:</td>
            <td>${event.eventDescription}</td>
        </tr>
    </table>
</center><%@include file="includes/footer.jsp"%>
