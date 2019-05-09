<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="card-header">
                    <h3>Empleados</h3>
                    <a href="/admin/empleados/crear" class="btn btn-outline-primary"><span uk-icon="plus"></span> Agregar</a>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Codigo</th>
                                    <th>Teléfono</th>
                                    <th>Cédula</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="empleado" items="${empleados}">
                                    <tr>
                                        <td>${empleado.nombre}</td>
                                        <td>${empleado.codigo}</td>
                                        <td>${empleado.telefono}</td>
                                        <td>${empleado.cedula}</td>
                                        <td>
                                            <a href="/admin/empleados/${empleado.id}/trasladar" class="btn btn-outline-primary btn-sm">
                                                <span uk-icon="icon: pencil"></span> Trasladar
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
