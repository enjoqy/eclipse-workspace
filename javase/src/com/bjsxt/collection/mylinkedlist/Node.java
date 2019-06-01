package com.bjsxt.collection.mylinkedlist;

public class Node {
	private Node privious;
	private Object obj;
	private Node next;
	public Node getPrivious() {
		return privious;
	}
	public void setPrivious(Node privious) {
		this.privious = privious;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
