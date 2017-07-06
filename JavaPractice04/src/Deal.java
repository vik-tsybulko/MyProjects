import java.util.Date;

public class Deal {

	private final Date date = new Date();

	private final Party buyer;

	private final Party seller;

	private final Collection <Product> products = new LinkedList <Product>();
	//методы в коллекциях
    // products.add(new Product) - добавляет елемент в коллекцию
    // products.remove(pr) - удаляет елемент из коллекции
    // products.isEmpty () - есть ли внутри елементы или нет
    // products.size() - позволяет узнать сколько внесено елементов
    /* пробежка по коллекции
    либо с помощью сокращенного варианта цикла фор
    for (Product p: products){...}

     */
	public Deal(Party buyer, Party seller, Product[] products) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.products = products;
	}

	public double getSum() {
		double result = 0;
		for (Product product : products) {
			result += product.getCost();
		}
		return result;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the buyer
	 */
	public Party getBuyer() {
		return buyer;
	}

	/**
	 * @return the seller
	 */
	public Party getSeller() {
		return seller;
	}

	/**
	 * @return the products
	 */
	public Product[] getProducts() {
		return products;
	}
}
