<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:forEach var="emp" items="${EMP_REPO_LIST}" >
     ${emp}<br/>
</c:forEach>

</body>
</html>
