package model;

public class Element {
	private Integer atomicNumber;
	private String elementName;
	private Integer period;
	private Integer group;
	private Integer weight;
	private String elementSymbol;

	public String getElementSymbol() {
		return elementSymbol;
	}

	public void setElementSymbol(String elementSymbol) {
		this.elementSymbol = elementSymbol;
	}

	public Integer getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(Integer atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
