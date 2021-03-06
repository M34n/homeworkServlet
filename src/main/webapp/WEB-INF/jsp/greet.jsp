<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
   <script type="text/javascript">
       $(document).ready(function() {
           $('#getState').click(function (){
               $.ajax({
                   type: "get",
                   url: "main?ajax=true",
                   success: function(msg){$('#output').text(msg);}
               });
           });
           $('#putState').click(function (){
                $.ajax({
                type: "put",
                url: "main",
                success: function(msg){$('#output').text(msg);}
                });
           });
           $('#postState').click(function (){
                $.ajax({
                type: "post",
                url: "main",
                success: function(msg){$('#output').text(msg);}
                });
           });
           $('#deleteState').click(function (){
               $.ajax({
               type: "delete",
                   url: "main",
               success: function(msg){
                   $('#output').text(msg);
               }
               });
           });
        });
   </script>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>JSP Page</title>
</head>
<body>
   <input type="button" value="Get" id="getState"/>
   <input type="button" value="Put" id="putState"/>
   <input type="button" value="Post" id="postState"/>
   <input type="button" value="Delete" id="deleteState"/>

   <div id="output">
        ${defaultText}
   </div>

   <c:forEach var="buttonAvaliable" items='${buttons}'>
       <c:out value="${buttonAvaliable}"/><p/>
   </c:forEach>
   <c:set var="sign" value="made by Petr Kozlov"/>
   <c:out value='${sign}'/>
</body>
</html>