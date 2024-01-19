<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${game.name}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-6">
            <div class="container-img p-3">
                <img src="${listing.image}">
            </div>
        </div>
        <div class="col-6">
            <h1>${listing.model.name}</h1>

            <p class="fs-2">${listing.price}€</p>
        </div>
    </div>

    <h2 class="my-5">Description</h2>

    <div class="text-center description">
        <c:out value="${listing.description}" escapeXml="false"/>
    </div>
</div>

<%@ include file="../footer.jsp" %>
