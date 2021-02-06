package edu.escuelaing.arep.Calculadora.Services;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.DecimalFormat;

import edu.escuelaing.arep.Calculadora.CalculadoraMS.Calculadora;
import  edu.escuelaing.arep.Calculadora.Linkedist.*;

public class Service {

    public static JsonObject getResult(JsonArray numbers) {

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