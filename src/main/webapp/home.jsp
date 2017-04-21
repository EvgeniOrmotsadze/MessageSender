<%@ page import="com.logi3pl.server.service.MemoryCache" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/css/style.css">
  <title>Messages Service</title>
</head>

<body>
<div class="main">
<h2>Display Android Messages</h2>

      <table id="tb" class="tables" style="margin-top: 15px;">
          <tbody>
          <th> N </th>
          <th> Text </th>
          </tbody>
          <% MemoryCache memoryCache = MemoryCache.getInstance();
             for(int i=0; i < memoryCache.getSize(); i++){%>
                  <tr><td> <%=memoryCache.getMessage(i).getMessageNumber() %> </td>
                      <td> <%=memoryCache.getMessage(i).getText()%> </td></tr>
           <% } %>
          <tr></tr>
      </table>
</body>
</html>
