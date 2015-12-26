<%@include file="includes/header.jsp"%>
<center>
    <form action="create_tag">
        <input type="hidden" id="isOwner" value="${isOwner}"/>
        <input type="hidden" id="isAdmin" value="${isAdmin}" }/>
        <table>
            <tr>
                <td>
                    <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                        <b>Bilan</b>
                    </center>
                </td>
            </tr>
        </table>
        <table cellpadding="10">
            <tr>
                <td>Nombre de clients sans adresse email valide:</td>
                <td>${bilan.clientsMailNonValides}</td>
            </tr>
            <tr>
                <td>Données manquantes pour remplacement:</td>
                <td>${bilan.donnéesManquantes}</td>
            </tr>
            <tr>
                <td>Nombres de mails envoyés:</td>
                <td>${bilan.mailsEnvoyés}</td>
            </tr>
        </table>
    </form>
</center><%@include file="includes/footer.jsp"%>