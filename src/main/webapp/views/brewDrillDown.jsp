<%-- 
    Document   : allAgents
    Created on : Feb 3, 2020, 7:19:34 PM
    Author     : brend
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>brew</title>
    <a href="\Security\agent\viewall">home</a>
    </head>
    <body>
        <table style="width:100%">
            <tr>
             <th align="left">ID</th>
             <th align="left">Name</th>
             <th align="left">Country</th>
             <th align="left">Phone</th>
             <th align="left">Email</th>
             <th align="left">Latitude</th>
             <th align="left">Longitude</th>
             <th align="left">Last Modified</th>
                        </tr>
            
                <tr>
                    <td>${brew.brewid} </td>
                    <td>${brew.name}</td>
                    <td>${brew.country}</td>
                    <td>${brew.phone}</td>
                    <td>${brew.email}</td>
                    <td>${brew.latitude}</td>
                    <td>${brew.longitude}</td>
                    <td>${brew.lastMod}</td>
                    <%---<td>  <a href="\AgentsCRUD\agent\edit?id=${foundagent.agentId}">edit</a></td>---%>
                   
                </tr>
           
        </table>
    </body>
</html>