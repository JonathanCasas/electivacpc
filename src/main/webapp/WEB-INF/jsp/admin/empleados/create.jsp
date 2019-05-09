<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <form action="/admin/empleados/store" method="POST" class="uk-form-horizontal uk-margin-large">
                    <div class="card-header">
                        <h3 class="cart-title">Nuevo empleado</h3>
                    </div>
                    <div class="card-body">
                        <div class="container">
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">Nombre</label>
                                <div class="uk-form-controls">
                                    <input required="" class="uk-input" id="form-horizontal-text" name="nombre" type="text" placeholder="Nombre ...">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">Código</label>
                                <div class="uk-form-controls">
                                    <input class="uk-input" id="form-horizontal-text" name="codigo" required="" type="text" placeholder="codigo ...">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">Teléfono</label>
                                <div class="uk-form-controls">
                                    <input class="uk-input" id="form-horizontal-text" required="" name="telefono" type="text" placeholder="telefono ...">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-text">Cédula</label>
                                <div class="uk-form-controls">
                                    <input class="uk-input" id="form-horizontal-text" required="" name="cedula" type="text" placeholder="cedula ...">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <label class="uk-form-label" for="form-horizontal-select">Multiplex</label>
                                <div class="uk-form-controls">
                                    <select class="uk-select" name="multiplex" id="form-horizontal-select" required="">
                                        <option value="">Seleccione</option>
                                        <c:forEach var="multiplex" items="${multiplexs}">
                                            <option value="${multiplex.id}">${multiplex.nombre}</option>    
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="uk-button uk-button-primary">
                            <span uk-icon="check"></span>
                            Guardar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>