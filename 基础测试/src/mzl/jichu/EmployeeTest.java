package mzl.jichu;

public class EmployeeTest {
	public static void main(String[] args) {
        //使用构造器创建两个对象
		Employee empOne = new Employee( "小三");
		Employee empTwo = new Employee("小四" );
          
		//调用这两个对象的成员方法、
		empOne.empAge(23);
		empOne.empDesignation("客服");
		empOne.empSalary(400);
		empOne.printEmployee();

		empTwo.empAge(27);
		empTwo.empDesignation("客服");
		empTwo.empSalary(500);
		empTwo.printEmployee();
		
	}

}
