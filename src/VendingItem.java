
public class VendingItem {
	Drink[] menu = {
			new Drink(200, "믹스커피",10),
	        new Drink(300, "고급믹스커피",10),
	        new Drink(450, "물",10),
	        new Drink(500, "캔커피",10),
	        new Drink(550, "이온음료",10),
	        new Drink(700, "고급캔커피",10),
	        new Drink(750, "탄산음료",10),
	        new Drink(800, "특화음료",10)
	};
	
	public boolean Purchase(int stock) {
		
		Drink select = menu[stock];
		
		if (select.quantity > 0) {
			select.quantity -=1;
			System.out.println("구매성공");
			return true;
		}
		else {
			System.out.println("품절");
			return false;
		}
	}
}
