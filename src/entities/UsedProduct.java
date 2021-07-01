package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	
	private static DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate manufactureDate;
	
	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public UsedProduct() {
		super();
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	@Override
	public String priceTag() {
		return getName() + "(used) $" + String.format("%.2f", getDefaultPrice())
				+ "(Manufacture date: " + manufactureDate.format(myFormat) + ")";
	}
	
}
