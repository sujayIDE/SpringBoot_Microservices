package in.ashokit.bean;

public class OrderService {
	InventoryService inventoryService;

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	public void placeOrder() {
		boolean flag=inventoryService.checkInventory();
		
		if(flag)
		{
			System.out.println("Order placed....");
		}else {
			System.out.println("Sorry, out of stock..");
		}
	}
	
}
