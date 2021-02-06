package edu.escuelaing.arep.Calculadora.Services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;

import edu.escuelaing.arep.Calculadora.CalculadoraMS.Calculadora;
import  edu.escuelaing.arep.Calculadora.Linkedist.*;

public class Service {

    /**
     *se encarga de dar el resultado de la media y la desviacion estandar por medio de un servicio a la pagina web creada con JSON
     * @param numbers recibe un arreglo de la pagina web la cual se encarga de verificar y sacar los valores
     * @return JsonObject objeto JSON conectado a la pagina
     * */

    public static JsonObject Servicio(JsonArray numbers) {

        Linkedist<Double> linkedList = new Linkedist();

        for(JsonElement number:numbers) {

            linkedList.addNode(Double.parseDouble(String.valueOf(number)));
        }

        DecimalFormat decimal = new DecimalFormat("0.00");

        String Media = decimal.format(Calculadora.Media(linkedList));
        String Desviacion_estandar = decimal.format(Calculadora.Desviacion_estandar(linkedList));

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("Media", String.valueOf(Media));
        jsonObject.addProperty("Desviacion_estandar", String.valueOf(Desviacion_estandar));
        return jsonObject;
    }
}