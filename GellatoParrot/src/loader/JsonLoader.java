package loader;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import lists.GenericList;
import lists.Ingredient;
import lists.Nodo;
import main.Config;

public class JsonLoader {
	public static GenericList<Object> ingredientLoader() {
		JSONParser parser = new JSONParser();
		GenericList<Object> IngL = new GenericList<Object>();

		try {

			Object obj = parser.parse(new FileReader("settings.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arr = (JSONArray) jsonObject.get("ingredients");
			Iterator it = arr.iterator();
			Ingredient ing;
			while (it.hasNext()) {
				ing = new Ingredient();
				JSONObject pair = (JSONObject) ((Map) it.next());
				ing.setType((String) pair.get("Type"));
				ing.setName((String) pair.get("Name"));
				ing.setColor((String) pair.get("Color"));
				ing.setID(Integer.parseInt((String) pair.get("ID")));
				Nodo<Object> ingN = new Nodo<Object>();
				ingN.setValor(ing);
				IngL.add(ingN);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return IngL;
	}

	public static Config configLoader() {
		Config cfg = new Config();
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("settings.json"));
			JSONObject jsonObject = (JSONObject) obj;
			cfg.setOrderFreq((int) jsonObject.get("OrderFreq"));
			cfg.setMinOrderGen((int) jsonObject.get("minOrderGen"));
			cfg.setMaxOrderGen((int) jsonObject.get("maxOrderGen"));
			cfg.setMaxIceCream((int) jsonObject.get("maxIceCream"));
			cfg.setMaxToppings((int) jsonObject.get("maxToppings"));
			cfg.setProbability((int) jsonObject.get("probability"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cfg;

	}

}
