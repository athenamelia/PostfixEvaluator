/**
* Single node in a linked list
*
* @author atayloe
* @version 4 Feb 2019
*/

public class LinkedListNode<T>{

	/** Variable to hold the data in the node */
	public T data;

	/** Variable to hold the node that comes after this one */
	public LinkedListNode<T> next;


	/**
	* Constructor; creates an empty node
	*/
	public LinkedListNode(){}


	/**
	* Constructor; creates a node with data
	* 
	* @param d the data to give the node initially
	*/
	public LinkedListNode(T d){
		data = d;
	}

	public T getData(){
		return data;
	}

	public LinkedListNode<T> getNext(){
		return next;
	}

	public void setData(T d){
		data = d;
	}

	public void setNext(LinkedListNode<T> n){
		next = n;
	}

	public String toString() {
		return data.toString();
	}


}