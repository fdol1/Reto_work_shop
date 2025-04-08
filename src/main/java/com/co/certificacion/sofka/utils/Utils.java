package com.co.certificacion.sofka.utils;

/**
 * Esta permite crear funciones que aporten al funcionamiento agil del robot de pruebas
 */

import com.co.certificacion.sofka.exceptions.Exceptions;
import com.co.certificacion.sofka.model.DatosProductoModel;
import com.co.certificacion.sofka.model.InfoPersonalModel;
import com.co.certificacion.sofka.model.InicioDeSesionModel;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.co.certificacion.sofka.utils.Constantes.*;

public class Utils {

    private Utils() {
        throw new Exceptions(ErrorMessage.IMPOSIBLE_INSTANT.getMessage());
    }

    public static DatosProductoModel setDatosProductoModel(DataTable datosScenario) {

        List<Map<String, String>> datosProductoList = datosScenario.asMaps(String.class, String.class);
        List<DatosProductoModel> datosProductoModelList = new ArrayList<>();

        for (Map<String, String> map : datosProductoList) {
            DatosProductoModel model = new DatosProductoModel();

            model.setProducto(map.get(KEY_PRODUCTO));
            model.setPrecio(map.get(KEY_PRECIO));

            datosProductoModelList.add(model);
        }

        return datosProductoModelList.get(0);
    }

    public static InicioDeSesionModel setDatosInicioSesionModel(DataTable datosScenario) {

        List<Map<String, String>> datosInicioList = datosScenario.asMaps(String.class, String.class);
        List<InicioDeSesionModel> datosInicioModelList = new ArrayList<>();

        for (Map<String, String> map : datosInicioList) {
            InicioDeSesionModel model = new InicioDeSesionModel();

            model.setUsuario(map.get(KEY_USUARIO));
            model.setClave(map.get(KEY_CLAVE));

            datosInicioModelList.add(model);
        }

        return datosInicioModelList.get(0);
    }

    public static InfoPersonalModel setInfoPersonalModel(DataTable datosScenario) {

        List<Map<String, String>> datosInfoPersonalList = datosScenario.asMaps(String.class, String.class);
        List<InfoPersonalModel> datosInfoPersonalModelList = new ArrayList<>();

        for (Map<String, String> map : datosInfoPersonalList) {
            InfoPersonalModel model = new InfoPersonalModel();

            model.setNombre1(map.get(KEY_NOMBRE1));
            model.setNombre2(map.get(KEY_NOMBRE2));
            model.setCodigoPostal(map.get(KEY_CODIGO_POSTAL));

            datosInfoPersonalModelList.add(model);
        }

        return datosInfoPersonalModelList.get(0);
    }


}
