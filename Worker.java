package creation;

import java.io.Serializable;

/** 
* @author  作者 E-mail: 
* @date 创建时间：2016年12月15日 下午9:21:14 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class Worker implements Serializable, Cloneable {
	private static final long serialVersionUID = 1;
	private String name;
	private int age;
	
	public Worker() {
		this.name = new String("");
		this.age = 0;
	}
	
	public Worker(String name,int age){
		this.name = new String(name);
		this.age = age;
	}
	
	public void work(){
		System.out.println(name + "is working");
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = new String(name);
	}
	public Worker clone()
	{
		Worker worker = null;
		try
		{
			worker = (Worker)super.clone();
			String name = worker.getName();
			worker.setName(name);
			 
		}catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return worker;
	}
	
	public String toString(){
		return name + "," + age;
	}
}
