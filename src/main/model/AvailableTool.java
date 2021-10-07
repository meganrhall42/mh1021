package main.model;

public enum AvailableTool {

	LADW("lawd", "Werner", ToolType.LADDER), 
	CHNS("chns", "Stihl", ToolType.CHAINSAW),
	JAKR("jakr", "Ridgid", ToolType.JACKHAMMER), 
	JAKD("jakd", "DeWalt", ToolType.JACKHAMMER);
	
	private String toolCode;
	private String brand;
	private ToolType type;

	AvailableTool() { }
	
	AvailableTool(String toolCode, String brand, ToolType type) {
		this.toolCode = toolCode;
		this.brand = brand;
		this.type = type;
	}

	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ToolType getType() {
		return type;
	}

	public void setType(ToolType type) {
		this.type = type;
	}
	
	
}
