package list.linkedlist.implementation;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{ // 하나의 element가 하나의 object이기 때문에 그 객체를 정의 => Node라는 이름의 이너클래스
		private Object data;
		private Node next; // 누가 다음 노드인가에 대한 정보를 저장하기 위해 next 변수 생성
		
		//생성자
		public Node(Object input) { // input: 생성자의 매개변수. 노드가 처음 생성될 때 값을 가져야 되는데, input에 저장될 것이다. 
			this.data = input;
			this.next = null;
		}
		public String toString() {
			// 테스트용도로 sysout 으로 node를 출력할 때 그 데이터 값이 무엇인가를 출력하기 위해서 toString 구현  
			return String.valueOf(this.data); 
		}
		
	}

	
}
