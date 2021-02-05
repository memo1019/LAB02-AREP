package edu.escuelaing.arep.Calculadora.SparkWeb;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.escuelaing.arep.Calculadora.Services.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static spark.Spark.*;


public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        post("operacion", (req, res) -> {

            JsonObject jsonObject = new JsonParser().parse(req.body()).getAsJsonObject();
            res.type("application/json");
            return Service.getResult(jsonObject.get("value").getAsJsonArray());
        });

        get("operacion", (req, res) -> {

            String page = FileUtils.readFileToString(new File("src/main/webapp/index.html"), StandardCharsets.UTF_8);
            return page;
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost);
    }
}