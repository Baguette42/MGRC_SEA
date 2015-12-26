<%@include file="includes/header.jsp"%>
<center>
    <table>
        <tr>
            <td>
                <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                    <b>Informations �v�nement</b>
                </center>
            </td>
        </tr>
    </table>
    <table cellpadding="10">
        <tr>
            <td>Type:</td>
            <td>${event.type}</td>
            <td>Date de l'�v�nement:</td>
            <td>
                <fmt:formatDate pattern="dd/MM/yyyy" value="${client.date}"></fmt:formatDate>
            </td>
        </tr>
        <tr>
            <td>Utilisateur cr�ateur:</td>
            <td>${event.createur}</td>
        </tr>
        <tr>
            <td>Date de derni�re modification:</td>
            <td>
                <fmt:formatDate pattern="dd/MM/yyyy" value="${client.date}"></fmt:formatDate>
            </td>
            <td>Derni�re modification par:</td>
            <td>${event.modifieur}</td>
        </tr>
        <tr>
            <td>Description de l'�v�nement:</td>
            <td>${event.description}</td>
        </tr>
    </table>
</center><%@include file="includes/footer.jsp"%>
