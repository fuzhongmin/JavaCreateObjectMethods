package creation;
/** 
* @author  ���� E-mail: 
* @date ����ʱ�䣺2016��12��15�� ����9:51:53 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class CreationTest {

	public static void main(String[] args) {
		//1.ʹ��new ��ʽ��������  
        Worker worker1 = CreateInstance.createWorker();
        System.out.println("worker1: " + worker1);
        Worker worker2 = CreateInstance.createWorker("Louis", 23); 
        System.out.println("worker2: " + worker2);
        
        //2.ʹ�÷�����ƽ��д�����  
        //a.ʹ�÷�����ƣ��������� Class ����� newInstance() ���� 
        Worker worker3 = CreateInstance.createWorkerViaReflect();
        System.out.println("worker3: " + worker3);
        
        //b.ʹ�÷������ �����������Ĺ��캯�������¶���  
        Worker worker4 = CreateInstance.createWorkerViaReflectConstructor();
        System.out.println("worker4: " + worker4);
      
        //c.ʹ�÷������ ���������Ĺ��캯�������¶���  
        Worker worker5 = CreateInstance.createWorkerViaReflectConstructorArgs("Louis", 25);
        System.out.println("worker5: " + worker5);
        
      //3. ʹ�����л��ͷ����л� ���д��������ʵ�����Ƕ���ĸ�ԭ  
        //��һ���������lou.dat�ļ���  
        CreateInstance.storeObject2File("lou.dat");
        Worker worker6 = CreateInstance.createWorkerViaSeriable("lou.dat");
        System.out.println("worker6: " + worker6);
        
       //4.���ö�������clone���� 
        Worker worker7 = CreateInstance.createWorkerViaClone(worker2);
        System.out.println("worker7: " + worker7);
        
        worker7.setName("James");
        System.out.println("worker7: " + worker7);
        System.out.println("worker2: " + worker2);
	}

}
