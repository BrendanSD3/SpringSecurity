<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All </title>
    

<style>
            thead input {
                width: 100%;
                padding: 3px;
                box-sizing: border-box;
            }
        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
        <script>
            $(document).ready(function() {
                $('#tableP').DataTable();
            } );
         function Areyousure()
         {
             
  var txt;
  var person = confirm("Are you sure you want to delete this? " );
  if (person == null || person == "") {
    txt = "User cancelled the prompt.";
  } else {
		window.location.href = "\Security\agent\delete?id=${brewery.brewid}";
	}
  document.getElementById("demo").innerHTML = txt;

             
             
         }
        </script>
    </head>
    <h3>Welcome <security:authentication property="principal.username"/></h3>
        <center>
             <a href="/Security/logout">logout</a>
            <h1>List of Breweries</h1>
             <security:authorize access="hasRole('ADMIN')">
            <h3><a href="\Security\agent\add">Insert a new Record</a></h3>
             </security:authorize>
            
        <table class="display compact hover stripe" id="tableP">
            <thead>
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Name</th>
                    <th align="left">City</th>
                    <th align="left">State</th>
                    <th align="left">Country</th>
                    <th align="left">Website</th>
                    <th align="left">Image</th>
                    <th align="left">Email</th>
                    <th align="left">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${List}" var="brewery"> 
                    <tr>
                        <td>${brewery.brewid}</td>
                        <td>${brewery.name}</td>
                        <td>${brewery.city}</td>
                        <td>${brewery.state}</td>
                        <td>${brewery.country}</td>
                        <td>${brewery.website}</td>
                        <td><img src="/agent/images/${brewery.image}" style="height:50px; width: 50px;" alt="${brewery.image}"></img></td>
                        <td>${brewery.email}</td>
                        <td>
                             <security:authorize access="hasRole('ADMIN')">
                            <button> <a href="\Security\agent\editbrew?id=${brewery.brewid}">Edit</a></button>
                             </security:authorize>
                
                            <button><a href="\Security\agent\display?id=${brewery.brewid}">Display</a></button>
                            
                            <security:authorize access="hasRole('ADMIN')">
                            <button><a href="\Security\agent\delete?id=${brewery.brewid}" onclick="Areyousure()">Delete</a></button>
                            </security:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table></center>
    </body>
