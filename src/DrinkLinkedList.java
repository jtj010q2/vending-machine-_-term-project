public class DrinkLinkedList{
	private static class Node{
		Drink data;
		Node next;
		
		public Node(Drink data) {
			this.data = data;
			this.next = null;
		}
	}
	private Node head;
	
	public void add(Drink data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
	}
	
	public void drop(String name) {
		if (head == null)
			return;
		
		if (head.data.name.equals(name)) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while (current.next != null && !current.next.data.name.equals(name)) {
			current = current.next;
		}
		
		if (current.next != null) {
			current.next = current.next.next;
		}
	}
	
	public int itemCount() {
		
		int value = 0;
		Node current = head;
		while (current != null) {
			value++;
			current = current.next;
		}
		
		return value;
	}
	
	public boolean soldout() {
		return head == null;
	}
}

