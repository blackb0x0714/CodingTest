package linkedList;

public class LinkedList {
	
	// 첫번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node{
		
		// 데이터가 저장될 필드
		private Object data;
		// 다음 노드를 가리키는 필드
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// 노드의 내용을 쉽게 출력해서 확인해 볼 수 있는 기능
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		// 노드를 생성합니다.
		Node newNode = new Node(input);
		// 새로운 노드의 다음 노드로 헤드를 지정합니다.
		newNode.next = head;
		// 헤드로 새로운 노드를 지정합니다.
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
}
