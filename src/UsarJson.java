import com.google.gson.*;

public class UsarJson {

    public JsonObject convertirAJson(String json) {
        JsonParser parser = new JsonParser();
        return parser.parse(json).getAsJsonObject();
    }

    public double obtenerTasa(JsonObject jsonObject, String moneda) {
        JsonObject tasas = jsonObject.getAsJsonObject("conversion_rates");
        return tasas.get(moneda).getAsDouble();
    }

}
