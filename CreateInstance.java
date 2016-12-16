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
* @author  ���� E-mail: 
* @date ����ʱ�䣺2016��12��15�� ����9:30:23 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

/*����ʾ��Java��������Ķ��ַ�ʽ*/
public class CreateInstance {
	//��ʽ1�� ֱ��ʹ��new�ķ�ʽ,�������� 
	public static Worker createWorker(){
		return new Worker();
	}
	
	//��ʽ1�� ֱ��ʹ��new�ķ�ʽ,������ 
	public static Worker createWorker(String name,int age){
		return new Worker(name,age);
	}
	//��ʽ2�� ʹ�÷������,��������Class�����newInstance�������� 
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
	
	//��ʽ3�� ʹ�÷������,��ȡ�޲���Constructor�󣬵��� newInstance����
		public static Worker createWorkerViaReflectConstructor(){
			Class clazz = null;
			Worker worker = null;
			try{
				clazz = Class.forName("creation.Worker");
				 // ��ȡ���������Ĺ�����  
				Constructor con = clazz.getConstructor();
				// ʹ�ù������������� 
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
		
		//��ʽ3�� ʹ�÷������,��ȡ����Constructor�󣬵��� newInstance����
		public static Worker createWorkerViaReflectConstructorArgs(String name,int age){
			Class clazz = null;
			Worker worker = null;
			try{
				clazz = Class.forName("creation.Worker");
				//��ȡ�������Ĺ�����  
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
		

	     //��ʽ4�� ʹ�����л��ͷ����л������������ַ�ʽ��ʵ�Ǹ��ݼ���
	     //�Ķ�����и��ƣ������Ҫ���Ƚ������л��Ķ����ߴ浽�ļ��� 
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
	    
	    
	     //�������õĶ�����뵽�ļ���  
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
	    
	   //��ʽ5�� ʹ�ö���� ��ƽ��и��ƣ���������  
	    public static Worker createWorkerViaClone(Worker worker) 
	    {  
	        return (Worker) worker.clone();  
	    }  
		
}
