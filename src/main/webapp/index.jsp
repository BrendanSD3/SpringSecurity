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
            <h1>Some admin content </h1>
            <a href="/Security/agent/viewall">View all brews</a>
            
            <a href="/Security/agent/view">Admin page</a>
       </security:authorize>
        <security:authorize access="hasRole('USER')">
            <h2>some User specific Content</h2>
            Welcome <security:authentication property="principal.username"/>
              <a href="/Security/agent/viewall">View all brews</a>
       </security:authorize>
          <security:authorize access="!isAuthenticated()">
              <h1>Welcome to the Brewery website!</h1>
              <h2>This website has some security features</h2>
              <button><a href="/Security/login">Login</a></button>
              <br><br>
              <button><a href="/Security/register">Register</a></button>
    </security:authorize>
    </body>
</html>
