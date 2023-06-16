import applications.*;

public class Main {
	public static void main(String[] args){
		VendingMachine vm = new VendingMachine();

		vm.addBeverage("Coke", 0.50);
		vm.addBeverage("Water", 0.30);
		vm.addBeverage("Beer", 1.00);
		System.out.println(vm.getPrice("Water"));
		vm.refillColumn(1, "Coke", 1);
		vm.refillColumn(2, "Beer", 10);
		vm.refillColumn(3, "Coke", 15);
		vm.refillColumn(3, "Coke", 10);
		vm.refillColumn(4, "Water", 20);

		System.out.println("number of Beverage: "+vm.availableCans("Coke"));

		System.out.println("Price of Beverage: "+vm.getPrice("Coke"));

		vm.rechargeCard(12, 5.5);
		vm.rechargeCard(21, 10.0);
		vm.rechargeCard(12, 10.5);
		vm.rechargeCard(99, 0.75);
		System.out.println("1 + "+vm.sell("Coke", 12));
		System.out.println("2 + "+vm.sell("Water", 12));
		System.out.println("8 + "+vm.sell("Coke", 21));
		System.out.println("9 + "+vm.sell("Coke", 12));
		System.out.println("10 + "+vm.sell("Coke", 99));
		System.out.println("11 + "+vm.sell("Coke", 99));



		System.out.println("3 + "+vm.availableCans("Coke"));
		System.out.println("4 + "+vm.availableCans("Beer"));
		System.out.println("5 + "+ vm.availableCans("Water"));

		System.out.println("6 + "+vm.getCredit(12));
		System.out.println("7 + "+vm.getCredit(21));
		System.out.println("8 + "+vm.getCredit(99));

	}
}


