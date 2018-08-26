package lists;

public class Ingredient {
	private String Name;
	private String Type;
	private String Color;
	private int ID;

	public String getName() {
		return Name;
	}

	public void setName(String pName) {
		Name = pName;
	}

	public String getType() {
		return Type;
	}

	public void setType(String pType) {
		Type = pType;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String pColor) {
		Color = pColor;
	}

	public int getID() {
		return ID;
	}

	public void setID(int pID) {
		ID = pID;
	}
	public String toString() {
		return "Name: " + Name + ", Type: " + Type + ", Color in HEX: " + Color + ", ID: " + ID + ".";
	}
}
