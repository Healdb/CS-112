/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author healdb
 */
public class Employee {

    private double monthlySalary;
    private String firstName;
    private String lastName;
    
    public Employee(String firstName, String lastName, double monthlySalary){
        this.firstName=firstName;
        this.lastName=lastName;
        this.monthlySalary=monthlySalary;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public double getMonthlySalary(){
        return this.monthlySalary;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setMonthlySalary(double monthlySalary){
        if(monthlySalary>0){
            this.monthlySalary=monthlySalary;
        }
    }
}
