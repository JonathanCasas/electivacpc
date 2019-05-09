<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="uk-card uk-card-default">
                <div class="uk-card-header">
                    <h4 class="my-0 font-weight-normal">Película y sede seleccionada</h4>
                </div>
                <div class="uk-card-body">
                    <h4 class="card-title pricing-card-title">
                        <small class="text-muted">
                            <a href="/multiplex/${multiplex.id}/pelicula/${pelicula.id}" class="text-muted">${pelicula.nombre}</a></small>
                    </h4>
                    <ul class="list-unstyled mt-3 mb-4">
                        <li>
                            <a href="/multiplex/${multiplex.id}" class="text-muted">${multiplex.nombre}</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix">
        <br>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="uk-card uk-card-default">
                <div class="uk-card-header">
                    <h4 class="my-0 font-weight-normal">Sillas seleccionadas</h4>
                </div>
                <div class="uk-card-body">
                    <c:forEach var="silla" items="${sillas}">
                        <div class="btn btn-outline-primary">
                            ${silla.fila} ${silla.columna} <br>
                            ${silla.tipo}
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="uk-card uk-card-default">
                <div class="uk-card-header">
                    <h4 class="my-0 font-weight-normal">Sillas seleccionadas</h4>
                </div>
                <div class="uk-card-body">
                    <table class="uk-table">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="producto" items="${productos}">
                                <tr>
                                    <td>${producto.nombre}</td>
                                    <td>${producto.cantidad}</td>
                                    <td>${producto.precio}</td>
                                    <td>${producto.total}</td>
                                </tr>   
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <div class="uk-card uk-card-default uk-card-body">
                <a href="/pagar/finalizar" class="btn btn-outline-primary">Finalizar Pago</a>
            </div>
        </div>
    </div>
</div>
