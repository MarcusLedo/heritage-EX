package entities;

public class ImportedProduct extends Product{
	private Double customFees;

	public ImportedProduct(String name, Double price, Double customFees) {
		super(name, price);
		this.customFees = customFees;
	}
	
	public ImportedProduct() {
		super();
	}
	
	public void setCustomFee(Double customFee) {
		this.customFees = customFee;
	}
	
	public Double getCustomFee() {
		return customFees;
	}
	
	public Double totalPrice() {
		return getDefaultPrice() + customFees;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $" + String.format("%.2f", totalPrice())
				+ "(Customs fee: $" + String.format("%.2f", customFees) + ")";
	}

}
