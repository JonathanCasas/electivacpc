<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
    <h1 class="display-4">Cinema Unimonito</h1>
    <p class="lead">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It?s built with default Bootstrap components and utilities with little customization.</p>
</div>
<div class="container">
    <div class="card-deck mb-3 text-center">
        <c:forEach var="multiplex" items="${multiplexs}">
            <div class="card mb-4 shadow-sm">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">${multiplex.nombre}</h4>
                </div>
                <div class="card-body">
                    <!--h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1-->
                    <ul class="list-unstyled mt-3 mb-4">
                        <li>${multiplex.salasCollection.size()} Salsa</li>
                    </ul>
                    <a href="/multiplex/${multiplex.id}" class="btn btn-lg btn-block btn-outline-primary">Seleccionar</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>