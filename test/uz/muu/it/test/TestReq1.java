package uz.muu.it.test;

import applications.VendingMachine;
import junit.framework.TestCase;

public class TestReq1 extends TestCase {
	VendingMachine vm;
	protected void setUp() throws Exception {
		super.setUp();
		vm = new VendingMachine();
		try{
			vm.addBeverage("Coke", 0.50);
			vm.addBeverage("Water", 0.30);
			vm.addBeverage("Beer", 1.00);

			vm.refillColumn(1, "Coke", 1);
			vm.refillColumn(2, "Beer", 10);
			vm.refillColumn(3, "Coke", 15);
			vm.refillColumn(3, "Coke", 10);
			vm.refillColumn(4, "Water", 20);


			vm.rechargeCard(12, 5.5);
			vm.rechargeCard(21, 10.0);
			vm.rechargeCard(12, 10.5);
			vm.rechargeCard(99, 0.75);
		}catch(Exception e){

		}
	}
	
	public void testPriceBeverage() {
		double expectedPrice = vm.getPrice("Water");
		assertEquals(expectedPrice, 0.30);


	}

	public void testPriceBeverageNotExist() {
		double expectedPrice = vm.getPrice("Ayron");
		assertEquals(expectedPrice, -1.0);


	}

	public void testRechargeCredit() {
		assertEquals(16.0, vm.getCredit(12));
	}

	public void testRechargeCreditNotExist() {
		vm.rechargeCard(12, 5.5);
		try {
			vm.getCredit(25);
		} catch (AssertionError ae){
			fail("Card must not exist");
		}


	}

	public void testAvailableCans() {
		assertEquals(vm.availableCans("Water"), 20);
	}

	public void testAvailableCans2() {
		assertEquals(vm.availableCans("Coke"), 26);
	}

	public void testAvailableCansNotExist() {
		assertEquals(vm.availableCans("Ayron"), -1);
	}

	public void testSell() {
		assertEquals(vm.sell("Coke", 12), 0);
		assertEquals(vm.getCredit(12), 15.5);
	}

	public void testSell2() {
		vm.sell("Coke", 12);
		assertEquals(vm.sell("Beer", 21), 1);
		assertEquals(vm.getCredit(21), 9.0);
	}

	public void testSell3() {
		assertEquals(vm.sell("Water", 88), -1);
	}
	
}
