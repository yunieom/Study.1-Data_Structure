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
		

	}

}
