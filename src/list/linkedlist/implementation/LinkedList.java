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
	//addFirst 구현. head에 data넣기 
	public void addFirst(Object input) {
		Node newNode = new Node(input); // line 7의 Node 클래스가 객체화 될 것이고 그 클래스의 생성자인 node 메소드 (line 12)에 input이 들어갈 것이다.
		//위 코드 실행하고 나면 첫 노드의 데이터는 30. (Main.java 의 line 6 에서 30을 input 값으로 넣어줬다. next는 null.
		newNode.next = head; // 새로만들어진 노드의 넥스트 값으로 head값 지정
		head = newNode; // head값이 새로만들어진 노드값
		size++; // 새로만들어진 노드를 가르키고 있으므로 총 들어있는 값이 2개. 그러므로 사이즈를 1증가 시켜준다.
		
		if(head.next == null) { // head의 next가 null이라면 = 값이 존재하지 않는다면,
			tail = head; // 마지막 노드(tail)는 head와 같다.
		}
	}
	//addLast 구현. tail에 data넣기
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) { //list에 data가 없을 경우 헤드에 넣나 테일에 넣나 무의미함 그렇기 때문에
			addFirst(input); //addFirst 메소드로 data 추가. data가 없을때 else 함수를 타면 tail.next(line 40)가 말이 안됨.
		} else { //size 가 0보다 큰 경우: list에 data가 있는 경우 
			tail.next = newNode; //새로 추가한 데이터를 인식시켜주기 tail의 next로 인식 시키고
			tail = newNode; // 바로 윗줄에서 언급한 newNode를 다시 tail로 인식 시킨다.
			size++; // 새로 데이터를 추가했으므로 사이즈 1 증가 
		}
	}
	//인덱스별로 data 값을 보기위한 Node 구현
	Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	//add 구현
	public void add(int k, Object input) {
		if(k == 0) { //0번째 인덱스에 data를 넣는 경우 = list에 data가 없을 경우 
			addFirst(input); // addFirst 구현
		} else { // 0번째 인덱스가 아닌 다른 인덱스자리에 data를 넣는 경우 k번째 -1 인덱스의 노드값을 알아내서 k번째 인덱스의 노드값을 알아서 k+1 한다.
			Node temp1 = node(k-1); // k-1 번째 노드를 temp1에 담고 
			Node temp2 = temp1.next; // k번째 노드를 temp2에 담고
			Node newNode = new Node(input); // 추가할 노드인 newNode 생성
			temp1.next = newNode; //temp1의 다음 노드는 추가할 노드인 newNode
			newNode.next = temp2; // newNode의 다음 노드는 기존의 k번째 노드의 값. 즉 (k+1이 된다)
			size++;
			if(newNode.next == null) { //만약 newNode 다음 값이 null이라면 = 값이 존재하지 않는다면
				tail = newNode; // 마지막 노드(tail)는 newNode이다. k+1로 기존값을 미뤄줄 필요가 없음. 즉 addLast의 경우가 되는 것.
			}
		}
		
	}
	

	
}
