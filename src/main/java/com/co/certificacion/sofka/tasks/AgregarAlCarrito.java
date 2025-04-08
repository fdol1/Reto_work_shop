package com.co.certificacion.sofka.tasks;

import com.co.certificacion.sofka.interactions.SeleccionarProducto;
import com.co.certificacion.sofka.model.DatosProductoModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiProductos.LBL_TITULO_PRODUCTO;
import static com.co.certificacion.sofka.utils.Constantes.LLAVE_PRECIO_PRODUCTO;
import static com.co.certificacion.sofka.utils.Constantes.LLAVE_TITULO_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarrito implements Task {

    private final DatosProductoModel datosProductoModel;

    public AgregarAlCarrito(DatosProductoModel datosProductoModel) {
        this.datosProductoModel = datosProductoModel;
    }

    public static AgregarAlCarrito elProducto(DatosProductoModel datosProductoModel) {
        return Tasks.instrumented(AgregarAlCarrito.class, datosProductoModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TITULO_PRODUCTO,isVisible()).forNoMoreThan(15).seconds(),
                SeleccionarProducto.porTitulo(datosProductoModel.getProducto())
        );
        actor.remember(LLAVE_TITULO_PRODUCTO,datosProductoModel.getProducto());
        actor.remember(LLAVE_PRECIO_PRODUCTO,datosProductoModel.getPrecio());

    }
}