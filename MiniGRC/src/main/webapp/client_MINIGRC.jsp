<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <center>
            <form action="createevent" method="post">
                <input type="hidden" id="isOwner" value="${isOwner}"/>
                <input type="hidden" id="isAdmin" value="${isAdmin}"/>
                <table>
                    <tr>
                        <td>
                            <center style="font-size: 16px; margin: 20px 10px 60px 10px">
                                <b>Informations client</b>
                            </center>
                        </td>
                    </tr>
                </table>
                <table cellpadding="10">
                    <tr>
                        <td>Civilite:</td>
                        <td>${client.clientCivilite}</td>
                        <td>Date de naissance:</td>
                        <td>
                            <fmt:formatDate pattern="dd/MM/yyyy" value="${client.clientNaissance}"></fmt:formatDate>
                        </td>
                    </tr>
                    <tr>
                        <td>Nom:</td>
                        <td>${client.clientNom}</td>
                        <td>Prenom:</td>
                        <td>${client.clientPrenom}</td>
                    </tr>
                    <tr>
                        <td>Adresse:</td>
                        <td colspan=3>${client.clientAdresse}</td>
                    </tr>
                    <tr>
                        <td>Telephone:</td>
                        <td>${client.clientTelephone}</td>
                        <td>E-mail:</td>
                        <td>${client.clientEmail}</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="${client.clientFacebook}">Facebook</a>
                        </td>
                        <td>
                            <a href="${client.clientTwitter}">Twitter</a>
                        </td>
                        <td>
                            <a href="${client.clientLinkedin}">LinkedIn</a>
                        </td>
                    </tr>
                    <tr>
                        <td>Prospect/Client:</td>
                        <td>${client.clientProfil}</td>
                        <td>Region geographique:</td>
                        <td>${client.clientRegion}</td>
                    </tr>
                    <tr>
                        <td>Refus e-mailing?:</td>
                        <td>
                            <input type="checkbox" id="emailRefus" name="isVerified" value="${client.clientEmailrefus}" disabled="disabled" />
                        </td>
                    </tr>
                    <table border="1" cellpadding="10" width="60%">
                        <thead bgcolor="B8D2FF">
                            <tr>
                                <th>Type</th>
                                <th>Date</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <a class="eventrow" href="edit?selectedEventId=1">Test</a>
                                </td>
                                <td>
                                    <a class="eventrow" href="edit?selectedEventId=1">10/02/2012</a>
                                </td>
                                <td>
                                    <a class="eventrow" href="edit?selectedEventId=1">Super Evenement</a>
                                </td>
                            </tr>
                            <c:forEach var="event" items="${eventList}">
                                <tr>
                                    <td>
                                        <a href="edit?selectedEventId=${event.id}">${event.type}</a>
                                    </td>
                                    <td>
                                        <a href="edit?selectedEventId=${event.id}">
                                            <fmt:formatDate
										pattern="dd/MM/yyyy" value="${event.date}"></fmt:formatDate>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="edit?selectedEventId=${event.id}">${event.description}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </table>
                <table>
                    <tr>
                        <td>
                                <input style="margin: 30px" type="submit" value="Ajouter un evenement"/>
                        </td>
                    </tr>
                </table>
            </form>
        </center>