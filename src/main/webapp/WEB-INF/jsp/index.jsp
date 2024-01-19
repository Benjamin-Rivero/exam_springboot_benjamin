<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Pas ouf les JSP"/>
<jsp:include flush="true" page="${contextPath}/WEB-INF/jsp/base.jsp"/>

<div class="container">
    <h1></h1>

    <h2 class="my-5">Les dernières annonces</h2>
    <div class="row">
        <c:forEach items="${listings}" var="listing">
                    <a class="col-3 mt-2 main-game-card" href="${s:mvcUrl('AppListing#show').arg(0, listing.slug).build()}">
                        <div class="game-card">
                            <div class="game-card-img">
                                <img alt="${listing.title}" src="${listing.image}">
                            </div>
                            <div class="d-flex justify-content-between">
                                <p>${listing.model.name}</p>
                                <p>${listing.price}€</p>
                            </div>
                        </div>
                    </a>
                </c:forEach>


<%@ include file="footer.jsp" %>
