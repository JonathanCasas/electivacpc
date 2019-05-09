<div class="container">
    <div class="uk-card uk-card-default uk-card-body">
        <div class="row">
            <div class="col-md-8">
                <form class="uk-form-horizontal uk-margin-large" method="POST" action="/pagar/finalizar">
                    <div class="uk-margin">
                        <label class="uk-form-label" for="form-horizontal-text">Nombre</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" name="nombre" required="" id="form-horizontal-text" type="text" placeholder="Nombre...">
                        </div>
                    </div>
                    <div class="uk-margin">
                        <label class="uk-form-label" for="form-horizontal-text">Dirección</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" name="direccion" required="" id="form-horizontal-text" type="text" placeholder="Dirección...">
                        </div>
                    </div>
                    <div class="uk-margin">
                        <label class="uk-form-label" for="form-horizontal-text">Teléfono</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" name="telefono" required="" id="form-horizontal-text" type="text" placeholder="Teléfono...">
                        </div>
                    </div>
                    <div class="uk-card-footer">
                        <button class="btn btn-outline-success">
                            <span class="uk-margin-small-right" uk-icon="check"></span> Finalizar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
