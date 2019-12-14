/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;

import emp.*;

class fulltime_s extends actsalary
{
int tot_salary;
fulltime_s()
{
    total_hrs=6*22;
}
void fulltime_calc(int att,int allowance)
{
   attend_hrs=att;
   try
   {
  attend_avg=(attend_hrs/total_hrs)*100;
   }
   catch(ArithmeticException a){}
  System.out.println("Your attendance average : "+attend_avg +" %");
  if(attend_avg==100)
  {
      tot_salary=allowance*22;
      System.out.println("Your Monthly salary is : "+tot_salary);
  }  
  else if(attend_avg<96 && attend_avg>94)
  {
      tot_salary=allowance*20;
      System.out.println("Your Monthly salary is : "+tot_salary);
  }
  else if(attend_avg<=90 && attend_avg>86 )
  {
      tot_salary=allowance*15;
      System.out.println("Your Monthly salary is : "+tot_salary);
  }
  else if(attend_avg<80 && attend_avg>70 )
  {
      tot_salary=allowance*10;
      System.out.println("Your Monthly salary is : "+tot_salary);
  }
  else if(attend_avg>6 && attend_avg<7)
  {
      tot_salary=allowance*4;
      System.out.println("Your Monthly salary is : "+tot_salary);
  }
  else
  {
      System.out.println("Salary");
  }
}
}
