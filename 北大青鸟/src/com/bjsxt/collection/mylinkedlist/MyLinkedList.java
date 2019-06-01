package com.bjsxt.collection.mylinkedlist;

/*
 * 自己用代码实现LinkedList
 * 实现crud方法
 * 2019-3-2
 * 
 * 
 */
public class MyLinkedList {
	private Node first;
	private Node last;
	private int size;

	public void add(Object obj) {  //在双链表中增加一个元素
		Node node = new Node();
		if(first == null) {  //首先判断第一个元素是否为空
			node.setPrivious(null);
			node.setObj(obj);
			node.setNext(null);

			first = node;
			last = node;
		}else {  //双链表上有数据，直接在最后一个节点上增加
			node.setPrivious(last);
			node.setObj(obj);
			node.setNext(null);

			last.setNext(node);
			last = node;
		}
		size++;
		
	}

	public void add(int index, Object obj) {  //在指定位置增加一个元素
		//有三种情况，元素位于第一位，元素处于中间，元素位于最后一位
		Node tmp = node(index);
		Node newNode = new Node();
		if(tmp != null) {
			if(tmp == first) {
				newNode.setPrivious(null);
				newNode.setObj(obj);
				newNode.setNext(first);

				first.setPrivious(newNode);
				first = newNode;
				size++;
			}else if(tmp == last) {
				newNode.setPrivious(last);
				newNode.setObj(obj);
				newNode.setNext(null);

				last.setNext(newNode);
				last = newNode;
				size++;
			}else {		
				Node up = tmp.getPrivious();
				newNode.setPrivious(up);
				newNode.setObj(obj);
				newNode.setNext(tmp);

				up.setNext(newNode);
				tmp.setPrivious(newNode);
				size++;
			}
		}
	}

	public Object get(int index) {  //取得指定索引处的元素
		Node tmp = node(index);  //调用封装的遍历双链表方法
		if(tmp == null) {
			return null;
		}
		return tmp.getObj();
	}

	public void remove(int index) {  //删除指定位置的元素,
		Node tmp = node(index);
		if(tmp != null) {
			if(tmp  == first) {  //首先要判断是不是第一个元素
				first = tmp.getNext();
				size--;
			}else if(last == tmp){  //判断元素是不是位于最后一位
				last = tmp.getPrivious();
				size--;
			}else {
				/*first = tmp.getPrivious();  //first,last是成员对象都是有值的，不能随便更改，下面新建两个临时的Node声明，up，down
			     last = tmp.getNext();

			     first.setNext(last);
			     last.setPrivious(first);
			     size--;
				 */
				Node up = tmp.getPrivious();
				Node down = tmp.getNext();

				up.setNext(down);
				down.setPrivious(up);
				size--;
			}
		}
	}

	public void remove(Object obj) {  //删除双链表一个指定的元素
		for(int i=0; i<size; i++) {
			if(obj.equals(get(i))) {
				remove(i);  //用equals（）从头开始遍历比较，找到之后删除第一个元素，循环退出，后面的相同的元素不删;
				break;
			}
		}
	}

	public void set(int index, Object obj) {  //更改指定索引处的元素
		Node tmp = node(index);  //需要考虑三种情况，元素位于第一位，处于中间，位于最后一位
		if(tmp != null) {
			if(first == tmp) {  //第一种情况，修改元素位于第一位的情况
				first.setObj(obj);
			}else if(last == tmp){  //第二种情况，修改元素位于最后一位的情况
				last.setObj(obj);
			}else {  //第三种情况，修改元素位于中间
				first = tmp.getPrivious();
				last = tmp.getNext();

				Node tmp1 = new Node();  //用新的节点将老的节点替换，完成更改操作
				tmp1.setPrivious(first);
				tmp1.setObj(obj);
				tmp1.setNext(last);

				first.setNext(tmp1);
				last.setPrivious(tmp1);
			}
		}
	}

	private Node node(int index) {  //封装遍历双链表
		rangeCheck(index);
		Node tmp = first;
		if(first != null) {
			for(int i=0; i<=index-1; i++) {
				tmp = tmp.getNext();
			}
		}
		return tmp;
	}

	private void rangeCheck(int index) {  //封装传入的参数范围检测
		if(index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("输入的参数不在合法范围内！");
				e.printStackTrace();
			}
		}
	}

	public int size() {  //返回双链表的长度
		return size;
	}

	public static void main(String[] args) {
		MyLinkedList mll = new MyLinkedList();
		mll.add("1");
		mll.add("2");
		mll.add("3");
		mll.add("4");
		mll.add("3");

		mll.add(4, "aaa");;

		for (int i=0; i<mll.size(); i++) {
			System.out.print(mll.get(i) + "\t");
		}
		System.out.println();

		mll.remove(0);
		for (int i=0; i<mll.size(); i++) {
			System.out.print(mll.get(i) + "\t");
		}
	}
}
