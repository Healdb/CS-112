
package employee;

/**
 *
 * @author healdb
 */
import java.util.Scanner;

public class Company {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the total number of eployees: ");
        int size = input.nextInt();
        Employee[] employeeList = new Employee[size];
        
        for(int i=0;i<employeeList.length;i++){
            Scanner namesInput = new Scanner(System.in);
            System.out.println("Enter the first name of employee #"+(i+1)+": ");
            String firstName = namesInput.nextLine();
            System.out.println("Enter the last name of employee #"+(i+1)+": ");
            String lastName = namesInput.nextLine();
            System.out.println("Enter the monthly salary of employee #"+(i+1)+": ");
            double salary = namesInput.nextDouble();
            employeeList[i]= new Employee(firstName,lastName,salary);
        }
        displayEmployeeData(employeeList);
        Scanner raiseInput = new Scanner(System.in);
        System.out.println("\nEnter the cost of living raise for all employees: ");
        double raise = raiseInput.nextDouble();
        
        for(int x=0;x<employeeList.length;x++){
            double currentMonthlySalary=employeeList[x].getMonthlySalary();
            employeeList[x].setMonthlySalary(currentMonthlySalary*raise+currentMonthlySalary);
        }
        
        displayEmployeeData(employeeList);
    }
    
    public static void displayEmployeeData(Employee[] employeeList){

        double totalPerYear=0;
        double lowestSalary=employeeList[0].getMonthlySalary();
        double highestSalary=0;
        Employee lowestPaid=employeeList[0];
        Employee highestPaid=employeeList[0];

        for(int c=0;c<employeeList.length;c++){     
            double monthlySalary=employeeList[c].getMonthlySalary();
            totalPerYear+=monthlySalary*12;
            if(monthlySalary>highestSalary){
                highestSalary=monthlySalary;
                highestPaid=employeeList[c];
            }
            else if(monthlySalary<lowestSalary){
                lowestSalary=monthlySalary;
                lowestPaid=employeeList[c];
            }
            
        }
        System.out.println("\n");
        System.out.println("Amount spent on salary per year: ");
        System.out.println(totalPerYear);
        System.out.println("Lowest paid employee's name and salary: ");
        System.out.println(lowestPaid.getFirstName()+" "+lowestPaid.getLastName());
        System.out.println(lowestSalary);
        System.out.println("Highest paid employee's name and salary: ");
        System.out.println(highestPaid.getFirstName()+" "+highestPaid.getLastName());
        System.out.println(highestSalary);
    }
}
