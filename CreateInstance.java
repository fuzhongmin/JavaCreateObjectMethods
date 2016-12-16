package creation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 
* @author  作者 E-mail: 
* @date 创建时间：2016年12月15日 下午9:30:23 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

/*下面示范Java创建对象的多种方式*/
public class CreateInstance {
	//方式1： 直接使用new的方式,不带参数 
	public static Worker createWorker(){
		return new Worker();
	}
	
	//方式1： 直接使用new的方式,带参数 
	public static Worker createWorker(String name,int age){
		return new Worker(name,age);
	}
	//方式2： 使用反射机制,不带参数Class对象的newInstance方法调用 
	public static Worker createWorkerViaReflect(){
		Class clazz = null;
		Worker worker = null;
		try{
			clazz = Class.forName("creation.Worker");
			worker = (Worker)clazz.newInstance();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return worker;
	}
	
	//方式3： 使用反射机制,获取无参数Constructor后，调用 newInstance方法
		public static Worker createWorkerViaReflectConstructor(){
			Class clazz = null;
			Worker worker = null;
			try{
				clazz = Class.forName("creation.Worker");
				 // 获取不带参数的构造器  
				Constructor con = clazz.getConstructor();
				// 使用构造器创建对象 
				worker = (Worker)con.newInstance();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch (InstantiationException e) {
				e.printStackTrace();
			}catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return worker;
		}
		
		//方式3： 使用反射机制,获取带参Constructor后，调用 newInstance方法
		public static Worker createWorkerViaReflectConstructorArgs(String name,int age){
			Class clazz = null;
			Worker worker = null;
			try{
				clazz = Class.forName("creation.Worker");
				//获取带参数的构造器  
				Constructor con = clazz.getConstructor(String.class,int.class);
				worker = (Worker)con.newInstance(name,age);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}catch (InstantiationException e) {
				e.printStackTrace();
			}catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return worker;
		}
		

	     //方式4： 使用序列化和反序列化创建对象，这种方式其实是根据既有
	     //的对象进行复制，这个需要事先将可序列化的对象线存到文件里 
	    @SuppressWarnings("resource")  
	    public static Worker createWorkerViaSeriable(String objectPath) 
	    {  
	        ObjectInput input = null;  
	        Worker worker = null;  
	        try {  
	            input = new ObjectInputStream(new FileInputStream(objectPath));  
	            worker = (Worker) input.readObject();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	        return worker;  
	    }  
	    
	    
	     //将创建好的对象存入到文件内  
	    public static void storeObject2File(String objectPath) {  
	        Worker worker = new Worker();  
	        ObjectOutputStream objectOutputStream;  
	        try {  
	            objectOutputStream = new ObjectOutputStream(
	            		new FileOutputStream(objectPath));  
	            objectOutputStream.writeObject(worker);  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {   
	            e.printStackTrace();  
	        }  
	    } 
	    
	   //方式5， 使用对象的 深复制进行复制，创建对象  
	    public static Worker createWorkerViaClone(Worker worker) 
	    {  
	        return (Worker) worker.clone();  
	    }  
		
}
