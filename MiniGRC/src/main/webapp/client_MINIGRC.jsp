<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <center>
            <form action="createevent" method="post">
                <input type="hidden" id="isOwner" value="${isOwner}"/>
                <input type="hidden" id="isAdmin" value="${isAdmin}" }/>
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
                        <td>Civilité:</td>
                        <td>${client.civilite}</td>
                        <td>Date de naissance:</td>
                        <td>
                            <fmt:formatDate pattern="dd/MM/yyyy" value="${client.date}"></fmt:formatDate>
                        </td>
                    </tr>
                    <tr>
                        <td>Nom:</td>
                        <td>${client.nom}</td>
                        <td>Prénom:</td>
                        <td>${client.prenom}</td>
                    </tr>
                    <tr>
                        <td>Images*:</td>
                    </tr>
                    <tr>
                        <td>Adresse:</td>
                        <td colspan=3>${client.adresse}</td>
                    </tr>
                    <tr>
                        <td>Telephone:</td>
                        <td>${client.telephone}</td>
                        <td>E-mail:</td>
                        <td>${client.email}</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="${client.facebook}">Facebook</a>
                        </td>
                        <td>
                            <a href="${client.twitter}">Twitter</a>
                        </td>
                        <td>
                            <a href="${client.linkedin}">LinkedIn</a>
                        </td>
                    </tr>
                    <tr>
                        <td>Prospect/Client:</td>
                        <td>${client.status}</td>
                        <td>Region geographique:</td>
                        <td>${client.region}</td>
                    </tr>
                    <tr>
                        <td>Refus e-mailing?:</td>
                        <td>
                            <input type="checkbox" id="emailRefus" name="isVerified" value="${client.emailRefus}" disabled="disabled" />
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
                                    <a class="eventrow" href="edit?selectedEventId=1">Super
								évènement</a>
                                </td>
                            </tr>
                            <c:forEach var="event" items="${client.events}">
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
                                <input style="margin: 30px" type="submit" value="Ajouter un évènement"/>
                        </td>
                    </tr>
                </table>
            </form>
        </center>