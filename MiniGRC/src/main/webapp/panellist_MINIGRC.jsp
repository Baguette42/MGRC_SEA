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
                        <form style="margin: 10px" action="createpanel" method="get">
                            <input type="submit" value="Creer un nouveau panel">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table border="1" cellpadding="10" width="60%">
                            <thead bgcolor="B8D2FF">
                            <tr>
                                <th>Nom</th>
                                <th>Creation e-mail</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="panel" items="${panelList}">
                                <tr>
                                    <td>
                                        <a href="createemail?selectedPanelId=${panel.panelId}">${panel.panelNom}</a>
                                    </td>
                                    <td>
                                        <span class="nowrap">
                                            <a href="createemail?selectedPanelId=${panel.panelId}">Creer un e-mail avec ce panel</a>
                                        </span>
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
    	<form action="mainpage">
		<HR>
		<table>
			<tr>
				<td><input style="margin: 30px" type="submit"
					value="Retour à l'accueil" /></td>
			</tr>
		</table>
	</form>
    
</center><%@include file="includes/footer.jsp"%>