<html>
<%--<header>hello xiao chuan</header>--%>
<frameset rows="12%,88%">
    <frame src="views/header.jsp">
<frameset cols="25%,75%" >
    <frame src="${pageContext.request.contextPath}/views/navigation.jsp">
    <frame src="${pageContext.request.contextPath}/views/content.jsp">
</frameset>
</frameset>
</html>
