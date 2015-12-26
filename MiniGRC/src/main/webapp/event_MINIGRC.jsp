<%@include file="includes/header.jsp"%>
<center>
    <table>
        <tr>
            <td>
                <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                    <b>Informations évènement</b>
                </center>
            </td>
        </tr>
    </table>
    <table cellpadding="10">
        <tr>
            <td>Type:</td>
            <td>${event.type}</td>
            <td>Date de l'évènement:</td>
            <td>
                <fmt:formatDate pattern="dd/MM/yyyy" value="${client.date}"></fmt:formatDate>
            </td>
        </tr>
        <tr>
            <td>Utilisateur créateur:</td>
            <td>${event.createur}</td>
        </tr>
        <tr>
            <td>Date de dernière modification:</td>
            <td>
                <fmt:formatDate pattern="dd/MM/yyyy" value="${client.date}"></fmt:formatDate>
            </td>
            <td>Dernière modification par:</td>
            <td>${event.modifieur}</td>
        </tr>
        <tr>
            <td>Description de l'évènement:</td>
            <td>${event.description}</td>
        </tr>
    </table>
</center><%@include file="includes/footer.jsp"%>
