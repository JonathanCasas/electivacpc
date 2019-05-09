<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="uk-card uk-card-default uk-card-small">
                <div class="uk-card-header">
                    <h4>Empleado</h4>
                </div>
                <div class="uk-card-body">
                    <dl class="uk-description-list">
                        <dt>Nombre</dt>
                        <dd>${empleado.nombre}</dd>
                        <dt>Código</dt>
                        <dd>${empleado.codigo}</dd>
                        <dt>Teléfono</dt>
                        <dd>${empleado.telefono}</dd>
                        <dt>Cédula</dt>
                        <dd>${empleado.cedula}</dd>
                    </dl>          
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="uk-card uk-card-default uk-card-small">
                <div class="uk-card-header">
                    <h4>Traslado de empleado</h4>
                </div>
                <div class="uk-card-body">
                    <form action="/admin/empleados/${empleado.id}/trasladar/store" method="POST">
                        <div class="row">
                            <div class="col-md-12">
                                Trasladar de <b>${multiplex.nombre}</b>
                            </div>
                            <div class="col-md-12 uk-margin-top">
                                A
                            </div>
                            <div class="col-md-12 uk-margin-top">
                                <div class="uk-margin">
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
                            <div class="col-md-12 uk-margin-top">
                                <button class="uk-button uk-button-primary">
                                    <span uk-icon="check"></span> Trasladar
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
