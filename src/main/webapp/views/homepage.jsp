<%-- 
    Document   : homepage
    Created on : May 1, 2020, 1:49:49 PM
    Author     : brend
--%>

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
        <title>Home</title>
    </head>
    <body>
       
        
     
    <security:authorize access="isAuthenticated()">
      <a href="/Security/logout">logout</a>
    </security:authorize>
       <security:authorize access="hasRole('ADMIN')">
            <h1>Some only admin content </h1>
            <a href="/Security/agent/view">Admin page</a>
       </security:authorize>
        <security:authorize access="hasRole('USER')">
            <h2>some User specific Content</h2>
            Welcome <security:authentication property="principal.username"/>
       </security:authorize>
          <security:authorize access="!isAuthenticated()">
          <a href="/Security/login">Login</a>
    </security:authorize>
    </body>
</html>
