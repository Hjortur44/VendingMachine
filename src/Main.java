
public class Main {

	public static void main(String[] args) {
		try {
			VendingMachine ven = new VendingMachine(5);
			System.out.println(ven);
		} catch (CapacityExceededException | NegativeOrZeroParameterException e) {
			e.printStackTrace();
		}
	}
}
