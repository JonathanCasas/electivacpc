<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal"><a href="/" style="color: #000">Cinema Unimonito</a></h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">Multiplex</a>
        <a class="p-2 text-dark" href="/productos">Snacks</a>
        <div class="p-2 dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span uk-icon="cart"></span>
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="/pagar">Pagar</a>
                <form action="/pagar/cancelar" method="POST" class="dropdown-item">
                    <button class="btn btn-outline-primary">Cancelar</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<div class="row">
    <div class="col-md-12">
        ${message}
    </div>
</div>