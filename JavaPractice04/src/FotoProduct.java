public class FotoProduct extends Product {

	private static final int DISCOUNT_FOR_NON_DIGITAL = 20;

	private double megapx;

	private boolean digital;

	@Override
	protected int calcDiscount() {
		int def = super.calcDiscount();
		if (!digital) {
			def += DISCOUNT_FOR_NON_DIGITAL;
		}
		return def;
	}

	/**
	 * @return the megapx
	 */
	public double getMegapx() {
		return megapx;
	}

	/**
	 * @param megapx
	 *            the megapx to set
	 */
	public void setMegapx(double megapx) {
		this.megapx = megapx;
	}

	/**
	 * @return the digital
	 */
	public boolean isDigital() {
		return digital;
	}

	/**
	 * @param digital
	 *            the digital to set
	 */
	public void setDigital(boolean digital) {
		this.digital = digital;
	}

}
