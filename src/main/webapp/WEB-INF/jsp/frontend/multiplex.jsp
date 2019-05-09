<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal">${multiplex.nombre}</h4>
    </div>
    <div class="card-body">
        <c:forEach var="peliculaSala" items="${peliculas}">
            <div class="card">
                <div class="card-header">
                    <h3 class="my-0 font-weight-normal">${peliculaSala.nombre}</h3>
                </div>
                <div class="card-body">
                    <h4 class="card-title pricing-card-title">
                        <small class="text-muted">${peliculaSala.sala}</small>
                    </h4>
                    <a 
                        href="/multiplex/${multiplex.id}/pelicula/${peliculaSala.id}" 
                        class="btn btn-lg btn-block btn-outline-primary">Seleccionar</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>