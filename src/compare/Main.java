package compare;

import list.arraylist.implementation.ArrayList;
import list.linkedlist.implementation.LinkedList;

public class Main {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.addLast(10);
		a.addLast(20);
		a.addLast(30);
		a.addLast(40);
		a.addFirst(50);
		//ArrayList의 경우 인덱스로 데이터 위치를 기억하기 때문에 그 인덱스에 넣기 위해서는 원래 각자 자리에 있던 요소들을 다 인덱스 +1 씩 해줘야 한다 -> 시간이 오래 걸림
		
		a.get(2);
		//인덱스를 이미 알고 있기 때문에 바로 해당 인덱스 주소로 이동. 어느 주소로 접근하던간에 동일한 속도를 보장받는다. -> 소요시간 빠름
		
		ArrayList.ListIterator ai = a.listIterator();
		while(ai.hasNext()) {
			if((int)ai.next() == 20) {
				ai.add(25); // ArrayList class에서 배열을 100으로 이미 최대값을 지정해줬기 때문에 101부터는 오류가 발생한다.
				//단 자바에서는 ArrayList가 기본적으로 정해져있는 사이즈가 다 차게 되면 기존 사이즈의 2배의 배열을 만들어준다. 그러고 기존 데이터 카피해서 가져감. 그래서 바로 윗 내용이 보완됨 (Dynamic Array)
			}
		}
		
		
		LinkedList l = new LinkedList();
		l.addLast(10);
		l.addLast(20);
		l.addLast(30);
		l.addLast(40);
		l.addFirst(50);
		//연결점만 찾아서 그부분의 연결만 바꿔서 진행된다. -> 시간이 오래 소요되지 않음
		
		l.get(2);
		//받은 인덱스만큼 처음부터 연결로 이동을 해야하기 때문에 데이터가 많은 경우 굉장히 오랜 시간이 소요된다.
		
		LinkedList.ListIterator li = l.listIterator();
		while(li.hasNext()) {
			if((int)li.next() == 20) {
				li.add(25); // 링크로 연결이 되어있기 때문에 메모리가 허용되는 한은 무한한 데이터를 추가할 수 있다. 
			}
		}

	}

}
