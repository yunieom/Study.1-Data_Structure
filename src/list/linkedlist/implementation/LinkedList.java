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
	//toString 구현
	public String toString() {
		if(head == null) { //head가 빈값이라면, 리스트에 데이터가 없다면
			return "[]";
		}
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) { //head 다음노드가 있다면 반복문 실행하다 tail 노드에서 멈춤(데이터가 null이기 때문)
			str += temp.data + ", ";
			temp = temp.next; 
		}
		str += temp.data;
		
		return str+"]";
	}
	
	//removeFirst 구현
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	//remove 구현
	public Object remove(int k) {
		if(k == 0) {
			return removeFirst();
		}
		Node temp = node(k-1);
		Node tobeDeleted = temp.next;
		temp.next = temp.next.next;
		Object returnData = tobeDeleted.data;
		if(tobeDeleted == tail) {
			tail = temp;
		}
		tobeDeleted = null;
		size--;
		
		return returnData;
	}
	
	//removeLast 구현
	public Object removeLast() {
		return remove(size-1);
	}
	
	//size 구현
	public int size() {
		return size;
	}
	
	//get 구현
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	//indexOf 구현
	public int indexOf(Object data) {
		Node temp = head;
		int index = 0;
		while(temp.data != data) { //찾는 data가 temp의 data가 아니라면 반복문 실행 
			temp = temp.next; // 그럼 temp.next 의 데이터로 가기
			index ++; // temp.next 값으로 넘어갔기 때문에 index +1 해주기 
			if(temp == null) { // 제일 끝에 있는 값으로 갔단 얘기 (입력한 데이터가 끝까지 돌 때까지 리스트에 없음)
				return -1; // 반복문 종료 (-1을 답해주고)
			}
		}
		return index;
	}
	
	//Iterator 구현
	public ListIterator listIterator() { //ListIterator(class) , listIterator(method)
		return new ListIterator(); // ListIterator를 인스턴스화 시켜서 리턴 -> Main.class line 38의 i으로 받음
	}
	class ListIterator{
		private Node next; 
		private Node lastReturned; //lastReturned를 ListIterator() 전역에서 사용할 수 있는 인스턴스 변수로 만들기
		private int nextIndex;
		
		ListIterator() {
			next = head; // 초기화 구문 처음 listIterator 가 생성됐을 때 next라고 하는 인스턴스 변수의 값으로 head값(첫번째 엘리먼트값)으로 지정
		}
		public Object next() {
			lastReturned = next; //next 값을 head값으로 지정한 후 lastReturned를 next로 지정
			next = next.next; // next는 또 다음 인덱스로 이동
			nextIndex++; // next가 이동할 때마다 카운트
			
			return lastReturned.data;
			
		}
		// Iterator hasNext 구현
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		// Iterator add 구현
		public void add(Object input) {
			Node newNode = new Node(input);
			
			if(lastReturned == null) {
				// 처음위치에 추가할 때
				head = newNode; // add 메소드를 사용하면 newNode 새로운 변수가 head를 가르키고
				newNode.next = next; // newNode의 다음값은 next
			} else {
				// 중간위치에 추가할 때
				lastReturned.next = newNode;
				newNode.next = next;
			}

			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		// Iterator remove 구현
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException(); //? 이건 뭐야?
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
		
	}
	
		
		

	
	 
	 
	

	
}
