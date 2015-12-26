<%@include file="includes/header.jsp" %>
<center>
    <table>
        <form action="mainpage" method="post">
            <tr>
                <center style="font:arial; font-size:20px;margin:30px">
                    <b>MiniGRC</b>
                </center>
            </tr>
            <tr>
                <td>Identifiant :</td>
                <td>
                    <input name="login_form" value=""/>
                </td>
            </tr>
            <tr>
                <td>Mot de passe :</td>
                <td>
                    <input type="password" name="password_form" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                <center>
                    <input style="font:arial;margin:10px;margin: 0 auto 0 0" type="submit" name="submit_button" value="Connexion"/>
                </center>
                </td>
            </tr>
        </form>
    </table>
    <center/><%@include file="includes/footer.jsp" %>