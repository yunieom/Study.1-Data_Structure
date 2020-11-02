package list.arraylist.implementation;

import java.util.ListIterator;

public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100]; //최대 100개의 데이터를 수용할 수 있는 배열 Object 생성 (Array)
	//*하지만 자바안에 있는 ArrayList 100개 데이터가 넘으면 자바가 알아서 리스트의 크기를 늘려준다.
	
	// addLast method 구현
	public boolean addLast(Object element) {
		elementData[size] = element; // elementData 배열의 값은 0으로 시작해서(line 4), 
		//addLast의 입력값으로 들어오는 element라는 인자의 값( new object[100] line 5 -> Object element line 8-> element line 9)이 elementData 0번 인덱스에 저장되고 line 11을 거쳐 1번 2번 인덱스에 값이 저장된다.
		size++;
		return true;
	}
	
	// add method 구현
	public boolean add(int index, Object element) {
		for (int i = size-1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	
	// addFirst method 구현
	public boolean addFirst(Object element) {
		return add(0, element);
	}
	
	// toString 구현
	public String toString() {
		String str= "[";
		for(int i=0; i<size; i++) {
			str += elementData[i];
			if(i < size-1) {
				str += ",";	
			}
			
		}
		return str + "]";
				
	}
	
	// remove 구현
	public Object remove (int index) {
		Object removed = elementData[index];
		for(int i= index+1; i<size; i++) {
			elementData[i-1]=elementData[i];
		}
		size--;
		elementData[size] = null;
		return removed;
	}
	
	// removeFirst 구현
	public Object removeFirst() {
		return remove(0);
	}
	public Object removeLast() {
		return remove(size-1);
	}
	
	// get 구현
	public Object get(int index) {
		return elementData[index];
	}
	
	// size 구현
	public int size() {
		return size;
	}
	
	// 해당 요소의 밸류로 인덱스 찾는 indexOf 구현 
	public int indexOf (Object o) {
		for (int i=0; i<size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
	
	// Iterlator next, hasNext, add 구현
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	class ListIterator {
		private int nextIndex = 0;
		
		// hasNext 구현
		public boolean hasNext() {
			return nextIndex < size();
		}
		// next 구현 
		public Object next() {
			//Object returnData = elementData[nextIndex];
			//nextIndex++;
			//return returnData;
			
			return elementData[nextIndex++];
		}
		
		// previous 구현 
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		// hasPrevious 구현
		public boolean hasPrevious() {
			return nextIndex>0;
		}
		
		// add 구현
		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);
		}
		
		//remove 구현
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
		
	}
	
	
	
	
	

	

}
