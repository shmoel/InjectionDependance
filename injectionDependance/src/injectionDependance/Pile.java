package injectionDependance;

import java.util.LinkedList;
import java.util.List;

public class Pile<T> {
	 private List<T> stk;
	 int i=0;
	 public Pile()
	 {
		 this.stk = new LinkedList();
	 }
	 public Pile(List<T> u)
	 {
		 this.stk = u;
	 }
	 public void empiler(T t)
	 {
		 this.stk.add(t);
	 }
	 
	 public T depiler()
	 {
		 i++;
		 
		 return this.stk.get(this.stk.size()-i);
	 }
}
