public abstract class Product {

	private static final int DEF_DISCOUNT = 10;

	private String title;

	private double price;

	private int quantity;

	public double getCost() {
		double realCost = quantity * price;
		return realCost - realCost * calcDiscount() / 100;
	}

	protected int calcDiscount() {
		if (quantity > DEF_DISCOUNT) {
			return 10;
		} else {
			return 0;
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
