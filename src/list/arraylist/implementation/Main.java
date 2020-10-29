package list.arraylist.implementation;

import java.util.ArrayList;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		
		// 데이터 추가
		numbers.add(1,50); 
		System.out.println("1. " + numbers);
		
		// 데이터 삭제
		numbers.remove(1);
		System.out.println("2. "+ numbers);
		
		// 데이터 가져오기
		numbers.get(2);
		System.out.println("3. " + numbers.get(2));
		
		// 데이터 사이즈(크기)
		numbers.size();
		System.out.println("4. " + numbers.size());
		
		// iterator method 
		// Iterator : 인터페이스 타입 
		Iterator it = numbers.iterator();
		int value = 0;
        System.out.println("iterator");
        while (it.hasNext()) {
        	value = (int) it.next();
            if (value == 30) {
                it.remove(); //value 가 30이면 numbers 에서 지워라. 
            }
            System.out.println("5. " + value); //while 문이 안끝나서 그런지 여기선 아직도 30이 나옴. 
        }
        System.out.println("5.1 " + value); //40이 마지막 순서일 땐 40이, 50이 마지막 데이터일 땐 50이 출력됨.. 왜? 
        System.out.println("5.2 " + numbers); // 여기선 numbers의 30 데이터가 삭제되어 출력.
        
        for(int value1 : numbers) {
        	System.out.println("6. " + value1);
        }
        for(int i=0; i<numbers.size(); i++) {
        	System.out.println("7. " + numbers.get(i));
        }
        System.out.println("8. " + numbers);
	}

}
 