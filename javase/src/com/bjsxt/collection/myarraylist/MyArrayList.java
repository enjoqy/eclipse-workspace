package com.bjsxt.collection.myarraylist;

/*实现一个ArrayList
 * 实现crud方法
 * 2019-3-4
 */
public class MyArrayList {

	private Object[] elementData;
	private int size;

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int initialCapacity) {  //初始化容量
		if(initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}

	public void add(Object obj) {  //增加操作
		//数组扩容
		ensureCapacity();
		elementData[size++] = obj;
	}

	public void add(int index, Object obj) {  //在指定索引处，增加一个元素
		rangeCheck(index);
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index] = obj;
		size++;
	}

	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}

	public void remove(int index) {  //删除指定索引处的元素
		rangeCheck(index);
		if(index == 0) {
			System.arraycopy(elementData, 1, elementData, 0, size-index);
			size--;
		}else if(index == size) {
			System.arraycopy(elementData, 0, elementData, 0, size-1);
			size--;
		}else {
			System.arraycopy(elementData, index+1, elementData, index, size-index);
			size--;
		}
	}

	public Object get(int index) {  //取得指定索引处的元素操作
		rangeCheck(index);   //封装的传入的参数范围检测
		return elementData[index];
	}

	public int size() {
		return size;
	}

	private void rangeCheck(int index) {  //封装的传入的参数范围检测
		if(index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void ensureCapacity() {  //封装的数组扩容
		if(size >= elementData.length) {
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			//			for(int i=0; i<elementData.length; i++) {  //和这个方法一样的效果
			//				newArray[i] = elementData[i];
			//			}
		}
	}

	public static void main(String[] args) {
		MyArrayList mal = new MyArrayList();
		mal.add("1");
		mal.add("2");
		mal.add("3");
		mal.add("4");
		mal.add("5");
		mal.add("6");

		for(int i=0; i<mal.size();i++) {
			System.out.print(mal.get(i) +"\t");
		}
		
		System.out.println("\n" + mal.size());
		
		mal.remove(5);
		for(int i=0; i<mal.size();i++) {
			System.out.print(mal.get(i) +"\t");
		}
	}
}
