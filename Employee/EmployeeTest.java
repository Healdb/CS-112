
 *
 * @author healdb
 */
public class employeeTest {
    public static void main(String[] args){
        Employee Bob= new Employee("Bob","Smith",100.0);
        Employee John= new Employee("John","Smith",200.0);
        
        System.out.println(Bob.getMonthlySalary()*12.0);
        System.out.println(John.getMonthlySalary()*12.0);
        
        Bob.setMonthlySalary(Bob.getMonthlySalary()*.1+Bob.getMonthlySalary());
        John.setMonthlySalary(John.getMonthlySalary()*.1+John.getMonthlySalary());
        
        System.out.println(Bob.getMonthlySalary()*12.0);
        System.out.println(John.getMonthlySalary()*12.0);
    }
}
