package edu.escuelaing.arep.Calculadora.SparkWeb;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.escuelaing.arep.Calculadora.Services.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static spark.Spark.*;


public class SparkWebApp {
    /**
     *Es la clase principal que llama la pagina web y pone a correr el servicio en esta pagina
     * @param args argumentos para correr
     * */

    public static void main(String[] args) {
        port(getPort());


        get("operacion", (req, res) -> {

            String page = FileUtils.readFileToString(new File("src/main/resources/operacion.html"), StandardCharsets.UTF_8);
            return page;
        });
        post("operacion", (req, res) -> {

            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            res.type("application/json");
            return Service.Servicio(jsonObject.get("value").getAsJsonArray());
        });
    }
    /**
     *se encarga de retornar el puerto por el cual esta corriendo el servidor
     * @return int obtiene el intero del puerto que se corre
     * */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost);
    }
}