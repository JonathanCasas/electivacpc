<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card">
    <div class="card-header">
        <h4 class="my-0 font-weight-normal">Productos</h4>
    </div>
    <div class="card-body">
        <div class="card-deck mb-3 text-center">
            <c:forEach var="producto" items="${productos}">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h3 class="my-0 font-weight-normal">${producto.nombre}</h3>
                    </div>
                    <div class="card-body">
                        <form class="add_product" id="form-${producto.id}" action="/productos/seleccionar" method="POST">
                            <input type="hidden" name="producto" value="${producto.id}">
                            <h4 class="card-title pricing-card-title">
                                <small class="text-muted">${producto.precio}</small>
                            </h4>
                            <ul class="list-unstyled mt-3 mb-4">
                                <li>Cantidad</li>
                                <li>
                                    <input name="cantidad" min="1" type="number" style="text-align: center" class="uk-input" placeholder="cantidad" value="1">
                                </li>
                            </ul>
                            <button type="submit" class="btn btn-lg btn-block btn-outline-primary">Agregar</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>
</div>
