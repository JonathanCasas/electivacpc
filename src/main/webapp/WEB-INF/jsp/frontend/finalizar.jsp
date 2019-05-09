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
                        <label class="uk-form-label" for="form-horizontal-text">Direcci�n</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" name="direccion" required="" id="form-horizontal-text" type="text" placeholder="Direcci�n...">
                        </div>
                    </div>
                    <div class="uk-margin">
                        <label class="uk-form-label" for="form-horizontal-text">Tel�fono</label>
                        <div class="uk-form-controls">
                            <input class="uk-input" name="telefono" required="" id="form-horizontal-text" type="text" placeholder="Tel�fono...">
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
