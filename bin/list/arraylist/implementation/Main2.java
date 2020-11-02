package list.arraylist.implementation;

public class Main2 {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		
		
		numbers.addLast(10); //ArrayList 클래스에 있는 addLast 호출. elementData 배열 0번 인덱스 
		numbers.addLast(20); //ArrayList 클래스에 있는 addLast 호출. elementData 배열 1번 인덱스 
		numbers.addLast(30); //ArrayList 클래스에 있는 addLast 호출. elementData 배열 2번 인덱스 
		numbers.addLast(40); //ArrayList 클래스에 있는 addLast 호출. elementData 배열 3번 인덱스
		
		numbers.add(1, 15); // 1번인덱스에 데이터 "15" 를 저장
		numbers.addFirst(5); // elementData 배열 맨 첫번째 인덱스에 element(data) 5를 저장.
		
		System.out.println(numbers); //5,10,15,20,30,40 
		
		System.out.println(numbers.remove(1)); // 10(삭제된 데이터)
		System.out.println(numbers); // 10이 삭제된 나머지 요소들의 배열. 5,15,20,30,40
		
		numbers.removeFirst(); // 인덱스 0번인 5 삭제
		System.out.println(numbers); //[15,20,30,40]
		numbers.removeLast(); // 마지막 인덱스 4 삭제
		System.out.println(numbers); // 15,20,30
		
		System.out.println(numbers.get(0)); // ArrayList는 get을 구현하는데 굉장히 유용하다.
		System.out.println(numbers.get(1));
		System.out.println(numbers.get(2));
		System.out.println(numbers.get(3));
		
		System.out.println(numbers.size()); // 배열의 크기
		System.out.println(numbers.indexOf(20)); // 인덱스 1번에 있기 때문에 1
		System.out.println(numbers.indexOf(30)); // 인덱스 2번에 있기 때문에 2
		System.out.println(numbers.indexOf(70)); // 배열에 존재하지 않는 데이터이기 때문에 -1(ArrayList.java line 81 에서 -1 return 하도록 설정해놓음.
		
		
		ArrayList.ListIterator li = numbers.listIterator();
		/*
		System.out.println(li.next()); // 인덱스 0번 : 15
		System.out.println(li.next()); // 인덱스 1번 : 20
		System.out.println(li.next()); // 인덱스 2번 : 30
		System.out.println(li.next()); // null (원소가 더이상 없음)
		System.out.println(li.next()); // null (원소가 더이상 없음)
		*/
		
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		
		/*
		System.out.println(li.previous()); // 인덱스 2번 : 30
		System.out.println(li.previous()); // 인덱스 1번 : 20
		System.out.println(li.previous()); // 인덱스 0번 : 15
		//System.out.println(li.previous()); 배열의 인덱스가 -1이 되버려 오류가난다. 
		*/
		
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		
		/*
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) { // 원소 값이 30인 경우를 만나면
				li.add(35); //35를 add 해라.
			}
		}
		System.out.println(numbers); // [15,20,30,35]
		*/
		
		while(li.hasNext()) {
			int number = (int)li.next();
			if(number == 30) { // 원소 값이 30인 경우를 만나면
				li.remove(); // 지워라. 
			}
		}
		System.out.println(numbers); // [15,20] 
		
	}

}
