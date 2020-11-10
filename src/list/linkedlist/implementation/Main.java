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
        
        System.out.println(numbers.size());
        System.out.println(numbers.get(2)); // 2번째 인덱스 값 가져오기
        
        System.out.println(numbers);
        System.out.println(numbers.indexOf(30)); //30데이터가 있는 인덱스 -> 1
        
        LinkedList.ListIterator i = numbers.listIterator();
        
        i.add(5); //i 가 한번도 사용되지 않았을 때. add를 하면 head 자리에 input data(5)가 입력된다.
        System.out.println(numbers); // [5,15,30,40,50]
        
        while(i.hasNext()) {
        	if((int)i.next() == 30) { // 30인 데이터를 찾아 지우기. 단 linkedList의 단점이 나오는데 처음(head)부터 반복문을 돌기때문에 길이가 긴 리스트의 경우 시간이 오래걸리는 비효율 적인 remove 방법이다.
        		i.remove();
        	}
        }
        System.out.println(numbers);
        
        //System.out.println(i.next()); // 첫번째 데이터 값
        //System.out.println(i.next()); // 두번째 데이터 값
        //System.out.println(i.next()); // 세번째 데이터 값
        
        // 사이즈의 값이 넥스트 인덱스보다 크다면 next를 실행했을 때 가져올 데이터가 있다.
        // 사이즈의 값이 넥스트 인덱스와 같다면, 작다면 next를 실행했을 때 가져올 데이터는 null.
        System.out.println(i.hasNext()); // 다섯번째 값이 있나?(while문에서 i가 next가 true인 경우는 다 돌고나옴. -> false
        
        
        
        
        
       
    }
}
