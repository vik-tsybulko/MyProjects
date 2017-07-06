import java.util.Scanner;

public class Program4 {

	private static final int MAX_PRODUCTS = 2;
	private static final int MAX_DEALS = 1;

	private Map<Integar, Product> deals;

	/**
	 * Program4's entry point
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		new Program4().allActions();
	}

	private void allActions() {
		input();
		System.out.println("================================");
		output();
	}

	private void output() {
		for (Deal deal : deals) {
			System.out.println("Deal " + deal.getDate());
			System.out.println("    " + deal.getBuyer().getName()
					+ " buys from " + deal.getSeller().getName());

			for (Product product : deal.getProducts()) {
				System.out.println("        " + product.getTitle() + " "
						+ product.getQuantity() + " x " + product.getPrice()
						+ " = " + product.getCost());
			}

			System.out.println("Sum: " + deal.getSum());
			System.out.println("----------------------------");

			outputParty(deal.getBuyer());
			outputParty(deal.getSeller());
		}
	}

	private void outputParty(Party party) {
		System.out.println(party.getName() + ":");
		System.out.println("Address: " + party.getAddress());
		for (int i = 0; i < party.getKeys().length; i++) {
			System.out.println("  " + party.getKeys()[i] + " = "
					+ party.getValues()[i]);
		}
	}

	private void input() {
		deals = new Deal[MAX_DEALS];

		for (int i = 0; i < deals.length; i++) {
			System.out.print((i + 1) + " of " + deals.length + ": ");
			deals[i] = inputDeal();
		}
	}

	private Deal inputDeal() {
		System.out.println("Input deal ->");

		System.out.print("  Seller -> ");
		Party seller = inputParty();

		System.out.print("  Buyer -> ");
		Party buyer = inputParty();

		Product[] products = new Product[MAX_PRODUCTS];
		for (int i = 0; i < products.length; i++) {
			products[i] = inputProduct();
		}

		Deal deal = new Deal(buyer, seller, products);
		return deal;
	}

	private Product inputProduct() {
		System.out.println("  Input product ->");

		String productType = keyboard("    1 - Foto, 2 - Botinki");

		String title = keyboard("    Name");
		String price = keyboard("    Price");
		String quan = keyboard("    Quantity");

		Product product = null;

		if (productType.equals("1")) {
			String megapx = keyboard("    Megapixel");
			String digital = keyboard("    True - Digital, False - Non-Digital");

			FotoProduct fotoProduct = new FotoProduct();
			fotoProduct.setDigital(Boolean.valueOf(digital));
			fotoProduct.setMegapx(Double.valueOf(megapx));

			product = fotoProduct;
		} else if (productType.equals("2")) {
			String size = keyboard("    Size");
			String color = keyboard("    Color");

			BotinkiProduct botinkiProduct = new BotinkiProduct();
			botinkiProduct.setSize(Integer.valueOf(size));
			botinkiProduct.setColor(color);

			product = botinkiProduct;
		} else {
			System.err.println("Unknown product");
			System.exit(-1);
		}

		product.setTitle(title);
		product.setPrice(Double.valueOf(price));
		product.setQuantity(Integer.valueOf(quan));

		return product;
	}

	private Party inputParty() {
		String partyName = keyboard("    Party name");
		String address = keyboard("    Party address");

		String[] keys = new String[2];
		String[] values = new String[2];

		for (int i = 0; i < values.length; i++) {
			keys[i] = keyboard("    Key" + (i + 1));
			values[i] = keyboard("    Value" + (i + 1));
		}

		Party party = new Party();
		party.setName(partyName);
		party.setAddress(address);
		party.setKeys(keys);
		party.setValues(values);
		return party;
	}

	private String keyboard(String message) {
		System.out.print(message + ": ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}

}
