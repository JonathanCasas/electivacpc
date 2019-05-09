<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card">
    <div class="card-header">
        <h3 class="my-0 font-weight-normal">${pelicula.nombre}</h3>
    </div>
    <div class="card-body">
        <div class="card">
            <table class="table">
                <thead>
                    <c:forEach var="sillasUI" items="${sillas}">
                        <tr>
                            <c:forEach var="sillaUI" items="${sillasUI}">
                                <td>
                                    <button 
                                        class="btn btn-block btn-outline-primary silla ${sillaUI.estado?"":"disabled"}" 
                                        silla="${sillaUI.id}"
                                        peliculaSala="${pelicula.id}"
                                        multiplex="${multiplex.id}">
                                        ${sillaUI.fila} ${sillaUI.columna}<br>
                                        ${sillaUI.tipo}
                                    </button>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </thead>
            </table>
        </div>
    </div>
</div>