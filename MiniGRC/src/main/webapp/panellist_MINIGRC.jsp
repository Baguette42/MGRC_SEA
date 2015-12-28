<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <tr>
            <table cellpadding="10">
                <tr>
                    <td>
                        <center style="font-size: 16px">
                            <b>Panels existants</b>
                        </center>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form style="margin: 10px" action="createpanel" method="post">
                            <input type="submit" value="Créer un nouveau panel">
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <table border="1" cellpadding="10" width="60%">
                                <thead bgcolor="B8D2FF">
                                    <tr>
                                        <th>Nom</th>
                                        <th>Création e-mail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Test</td>
                                        <td>
                                            <a class="eventrow" href="createemail?selectedEventId=1">Créer un e-mail avec ce panel</a>
                                        </td>
                                    </tr>
                                    <c:forEach var="panel" items="${panelList}">
                                        <tr>
                                            <td>
                                                <a href="createemail?selectedPanelId=${panel.id}">${panel.name}</a>
                                            </td>
                                            <td>
                                                <a class="eventrow" href="createemail?selectedPanelId=${panel.id}">Créer un e-mail avec ce panel</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </td>
                        <td></td>
                    </tr>
                </table>
            </tr>
        </table>
    </center><%@include file="includes/footer.jsp"%>