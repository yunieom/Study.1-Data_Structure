package list.arraylist.implementation;

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
	

}
