package loader;

import java.nio.file.FileSystems;
import java.io.*;
import lists.*;

public class IngredientLoader {
	public IngredientsList ingredients = new IngredientsList();

	public void file() throws Exception {
		FileReader fr = new FileReader("inventory.json");
		int i;
		while ((i = fr.read()) != -1) {
			System.out.println((char) i);
		}

	}
}
