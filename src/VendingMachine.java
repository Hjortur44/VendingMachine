public class VendingMachine {
	private final int capacity = 10;
	private int stock = 0;
	private boolean coinInserted = false;

	// Create with no bottles in stock
	VendingMachine() {}

	// Create with x bottles
	VendingMachine(int x) throws CapacityExceededException,
	                             NegativeOrZeroParameterException {

		if(x < 0) throw new NegativeOrZeroParameterException();
		else if(x > capacity) throw new CapacityExceededException();
		else stock = x;
	}

	void refill(int x) throws CapacityExceededException,
	                          CurrentlyCoinInsertedException,
	                          NegativeOrZeroParameterException {

		if(x < 0) throw new NegativeOrZeroParameterException();
		else if(x + stock > capacity) throw new CapacityExceededException();
		else if(coinInserted) throw new CurrentlyCoinInsertedException();
		else stock += x;
	}

	void insertCoin() throws MoreThanOneCoinInsertedException,
	                         EmptyStockException {

		if(coinInserted) throw new MoreThanOneCoinInsertedException();
		else if(stock < 1) throw new EmptyStockException();
		else coinInserted = true;
	}

	Bottle requestBottle() throws NoCoinInsertedException {
		coinInserted = false;
		return new Bottle();
	}

	@Override
	public String toString() {
		return this.capacity + " " + this.stock + " " + this.coinInserted;
	}
}
