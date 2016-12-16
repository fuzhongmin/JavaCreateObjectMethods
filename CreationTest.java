package creation;
/** 
* @author  作者 E-mail: 
* @date 创建时间：2016年12月15日 下午9:51:53 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class CreationTest {

	public static void main(String[] args) {
		//1.使用new 方式创建对象  
        Worker worker1 = CreateInstance.createWorker();
        System.out.println("worker1: " + worker1);
        Worker worker2 = CreateInstance.createWorker("Louis", 23); 
        System.out.println("worker2: " + worker2);
        
        //2.使用反射机制进行创建：  
        //a.使用反射机制，不带参数 Class 對象的 newInstance() 方法 
        Worker worker3 = CreateInstance.createWorkerViaReflect();
        System.out.println("worker3: " + worker3);
        
        //b.使用反射机制 ：不带参数的构造函数创建新对象  
        Worker worker4 = CreateInstance.createWorkerViaReflectConstructor();
        System.out.println("worker4: " + worker4);
      
        //c.使用反射机制 ：带参数的构造函数创建新对象  
        Worker worker5 = CreateInstance.createWorkerViaReflectConstructorArgs("Louis", 25);
        System.out.println("worker5: " + worker5);
        
      //3. 使用序列化和反序列化 进行创建，这个实际上是对象的复原  
        //将一个对象存入lou.dat文件内  
        CreateInstance.storeObject2File("lou.dat");
        Worker worker6 = CreateInstance.createWorkerViaSeriable("lou.dat");
        System.out.println("worker6: " + worker6);
        
       //4.利用对象的深层clone功能 
        Worker worker7 = CreateInstance.createWorkerViaClone(worker2);
        System.out.println("worker7: " + worker7);
        
        worker7.setName("James");
        System.out.println("worker7: " + worker7);
        System.out.println("worker2: " + worker2);
	}

}
