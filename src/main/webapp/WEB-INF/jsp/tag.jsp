<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%-- Importe l'objet UrlRoute pour pouvoir l'utiliser partout dans les JSP --%>
<%@ page import="fr.benjamin.exam_springboot_benjamin.mapping.UrlRoute" %>



<%-- Renomme de manière plus simple le "pageContext.request.contextPath" --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

