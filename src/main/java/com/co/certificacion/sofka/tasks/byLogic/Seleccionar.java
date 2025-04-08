package com.co.certificacion.sofka.tasks.byLogic;

import com.co.certificacion.sofka.interactions.SeleccionarProducto;
import com.co.certificacion.sofka.tasks.IrAlCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.co.certificacion.sofka.utils.Constantes.LLAVE_TITULO_PRODUCTO;

public class Seleccionar implements Task {

    public Seleccionar() {
    }

    public static Seleccionar ProductoOrdenado() {
        return Tasks.instrumented(Seleccionar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                SeleccionarProducto.porTitulo(actor.recall(LLAVE_TITULO_PRODUCTO)),
                IrAlCarrito.paraVerProductos()
        );
    }
}