package mzl.jichu;

public class EmployeeTest {
	public static void main(String[] args) {
        //ʹ�ù�����������������
		Employee empOne = new Employee( "С��");
		Employee empTwo = new Employee("С��" );
          
		//��������������ĳ�Ա������
		empOne.empAge(23);
		empOne.empDesignation("�ͷ�");
		empOne.empSalary(400);
		empOne.printEmployee();

		empTwo.empAge(27);
		empTwo.empDesignation("�ͷ�");
		empTwo.empSalary(500);
		empTwo.printEmployee();
		
	}

}
