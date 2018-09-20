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
	private JSONParser parser = new JSONParser();
	private GenericList<Ingredient> IngL = new GenericList<Ingredient>();
	private Config cfg = new Config();
	
	public JsonLoader() {
		ingredientLoader();
		configLoader();
	}
	private void ingredientLoader() {

		try {
			FileReader fr = new FileReader("settings.json");
			Object obj = parser.parse(fr);
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray arr = (JSONArray) jsonObject.get("ingredients");
			Iterator<JSONArray> it = arr.iterator();
			Ingredient ing;
			while (it.hasNext()) {
				ing = new Ingredient();
				JSONObject pair = (JSONObject) ((Map) it.next());
				ing.setType((String) pair.get("Type"));
				ing.setName((String) pair.get("Name"));
				ing.setColor((String) pair.get("Color"));
				ing.setiD( (Long) pair.get("ID"));
				this.IngL.add(ing);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void configLoader() {
		try {
			Object obj = parser.parse(new FileReader("settings.json"));
			JSONObject jsonObject = (JSONObject) obj;
			cfg.setOrderFreq((Long) jsonObject.get("OrderFreq"));
			cfg.setMinOrderGen((Long) jsonObject.get("minOrderGen"));
			cfg.setMaxOrderGen((Long) jsonObject.get("maxOrderGen"));
			cfg.setMaxIceCream((Long) jsonObject.get("maxIceCream"));
			cfg.setMaxToppings((Long) jsonObject.get("maxToppings"));
			cfg.setProbability((Long) jsonObject.get("probability"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public GenericList<Ingredient> getIngL() {
		return IngL;
	}

	public Config getCfg() {
		return cfg;
	}

}
