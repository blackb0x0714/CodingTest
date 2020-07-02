package linkedList;

public class ReviewClass {

	private Node head;
	private Node tail;
	private int size = 0;

	public class Node {

		private Object data;
		private Object next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}

	}
	

}
