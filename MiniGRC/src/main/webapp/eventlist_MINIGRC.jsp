<%@include file="includes/header.jsp" %>
<center>
    <table cellpadding="10">
        <form>
            <tr>
                <td>Type :</td>
                <td>
                    <input name="name_searchform" value="" />
                </td>
                <td>Description:</td>
                <td>
                    <input name="author_firstname_searchform" value="" />
                </td>
                <td class="searchButtonTd">
                    <input
					type="button"
					class="searchbutton" name="search_button" value="Rechercher" />
                </td>
            </tr>
        </form>
        <tr>
            <table cellpadding="10">
                <tr>
                    <td>
                        <center style="font-size: 16px">
                            <b>Evènements clients</b>
                        </center>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
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
                                        <a class="eventrow" href="event?selectedEventId=1">Test</a>
                                    </td>
                                    <td>
                                        <a class="eventrow" href="event?selectedEventId=1">10/02/2012</a>
                                    </td>
                                    <td>
                                        <a class="eventrow" href="event?selectedEventId=1">Super
								évènement</a>
                                    </td>
                                </tr>
                                <c:forEach var="event" items="${eventList}">
                                    <tr>
                                        <td>
                                            <a href="event?selectedEventId=${event.id}">${event.type}</a>
                                        </td>
                                        <td>
                                            <a href="event?selectedEventId=${event.id}">
                                                <fmt:formatDate
										pattern="dd/MM/yyyy" value="${event.date}"></fmt:formatDate>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="event?selectedEventId=${event.id}">${event.description}</a>
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