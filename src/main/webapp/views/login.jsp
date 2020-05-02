<%-- 
    Document   : login
    Created on : Apr 29, 2020, 4:07:55 PM
    Author     : brend
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
    <form name="f" action="" method="POST">
        <table>
                <tr>
                    <td>Username:</td>
                    <td><input type='text' name='username' /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type='password' name='password'></td>
                </tr>
                <tr>
                    <td colspan="2">&nbsp;</td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit">&nbsp;<input name="reset" type="reset"></td>
                </tr>
            </table>
        </form>