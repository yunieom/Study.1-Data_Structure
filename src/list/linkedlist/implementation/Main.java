package list.linkedlist.implementation;

public class Main {
	public static void main(String[] args) {
        LinkedList numbers = new LinkedList(); //인스턴스화
        numbers.addFirst(30);
        numbers.addFirst(20);
        numbers.addFirst(10);
        System.out.println(numbers.node(0));// 맨 마지막으로(제일최근) addFirst가 실행된 10이 호출
        System.out.println(numbers.node(1));// 두번째 마지막으로 addFirst가 실행된 20이 호출
        System.out.println(numbers.node(2));// 세번째 마지막으로 addFirst가 실행된 30이 호출
        
        numbers.addLast(40);        
        numbers.addLast(50);        
        numbers.addLast(60);   
        System.out.println(numbers.node(3)); // 제일 처음 addLast가 실행된 40이 호출
        System.out.println(numbers.node(4)); // 두번째 처음 addLast가 실행된 50이 호출
        System.out.println(numbers.node(5)); // 세번째 처음 addLast가 실행된 60이 호출
        
        numbers.add(1, 15); // 1번 인덱스에 값 15 을 넣겠다.
        System.out.println(numbers); // toString 메소드 구현으로 리스트를 볼 수 있다.
        
        System.out.println(numbers.removeFirst()); //첫번째 데이터 10 삭제
        System.out.println(numbers); 
        
        System.out.println(numbers.remove(1)); // 인덱스 1번 (2번째 데이터) 20 삭제
        System.out.println(numbers);
        
        System.out.println(numbers.removeLast()); //마지막 데이터 60 삭제
        System.out.println(numbers);
    }
}
