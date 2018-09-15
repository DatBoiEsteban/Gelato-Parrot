package lists;

public class Ingredient {

	private String type;
	private String name;
	private int color;
	private int iD;

	public String getType() {
		return type;
	}

	public void setType(String pType) {
		this.type = pType;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int pColor) {
		this.color = pColor;
	}

	public int getID() {
		return iD;
	}

	public void setID(int pID) {
		this.iD = pID;
	}

	public String toString() {
		return "Name: " + name + ", Type: " + type + ", Color in HEX: " + color + ", ID: " + iD + ".";
	}

}