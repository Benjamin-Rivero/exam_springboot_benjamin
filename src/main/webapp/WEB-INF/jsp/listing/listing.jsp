<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="${listing.title}"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container mt-5">
    <div class="row">
        <div class="col-6">
            <div class="container-img p-3">
                <img src="${listing.image}">
            </div>
        </div>
        <div class="col-6">
            <h4>${listing.title}</h4>

            <p class="fs-2">${listing.model.brand.name} ${listing.model.name}</p>
            <p class="fs-2">${listing.price}€</p>
            <p>Kilometrage : ${listing.mileage}  km</p>
            <p>Année de production : ${listing.producedYear}</p>
        </div>
    </div>

    <h2 class="my-5">Description</h2>

    <div class="text-center description">
        <c:out value="${listing.description}" escapeXml="false"/>
    </div>
</div>

<%@ include file="../footer.jsp" %>
