/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp;
import java.util.*;
import java.lang.Package;
import emp.actsalary;
import emp.salary;
import emp.fulltime_s;
import java.sql.*;
interface bonus
{
int bonus_calculation();
}
abstract class employee
{
String emp_name="",designation="",type_of_employee="",email_id="";
int emp_id,daily_allowance,month_sal;
Long phone_no;
        public void display(employee f[],int count) throws NullPointerException
        {
        int i;
   
         for(i=0;i<count;i++)
          {
             System.out.println(f[i].emp_name+"\t\t"+f[i].emp_id+"\t   "+f[i].designation+"\t    "+f[i].email_id+" \t"+f[i].phone_no +""+f[i].type_of_employee+" "+f[i].month_sal);
          }
    
         }

        public void display(employee p[],employee f[],int scount1,int scount2)throws NullPointerException
        {
        int i;
    
        for(i=0;i<scount1;i++)
        {
        System.out.println(f[i].emp_name+"\t\t"+f[i].emp_id+"\t     "+f[i].designation+"\t    "+f[i].email_id+"\t"+f[i].phone_no +""+f[i].type_of_employee+"\t "+f[i].month_sal);
        }
    
    for(i=0;i<scount2;i++)
    {
 System.out.println(p[i].emp_name+"\t\t"+p[i].emp_id+"\t     "+p[i].designation+"\t    "+p[i].email_id+" "+p[i].phone_no +""+p[i].type_of_employee+"\t\t");
    }
    
    }
    
 abstract int emp_count(int scount);
   
    }

class fulltime extends employee implements bonus
{
    int bonus_amt=0;
fulltime(){
type_of_employee="fulltime";
}
fulltime(String name,String design,String email,int id,Long pno,int allow,int month)
{
emp_name=name;
designation=design;
email_id=email;
emp_id=id;
phone_no=pno;
daily_allowance=allow;
month_sal=month;
}
@Override
 int emp_count(int scount1)
{
    return scount1;
}
    @Override
 public int bonus_calculation()
 {
     int temp;
     temp=daily_allowance/2;
     bonus_amt=temp*30;
     return bonus_amt;
   
 }
}
class parttime extends employee
{
parttime(){
type_of_employee="parttime";
}
parttime(String name,String design,String email,int id,Long pno,int allow,int month)
{
emp_name=name;
designation=design;
email_id=email;
emp_id=id;
phone_no=pno;
daily_allowance=allow;
month_sal=month;
}
@Override
 int emp_count(int scount2)
{
    return scount2;
}
}
public class emp
{
    public static void main(String arg[])
{
     
    
    //package classes
salary sam=new salary();
fulltime_s full=new fulltime_s();
parttime_s par=new parttime_s();

    //emp classes
int scount1=0,scount2=0;
employee[] e=new fulltime[10];
fulltime[] f=new fulltime[10];
parttime[] p=new parttime[10];
int opt,n,i,count1=0,count2=0;
String name="",design="",type="",email="";
 int id,allowance = 0,o;
 Long pno;
Scanner s=new Scanner(System.in);
Random rand;
        rand = new Random();
        
        
    ArrayList<String> array1 = new ArrayList<>();    //Array List
    ArrayList<String> array2 = new ArrayList<>();    //Array List
    
      HashSet<String> hset1 =  new HashSet<>(); //Hashset 
      HashSet<String> hset2 =  new HashSet<>(); //Hashset 

do
{
System.out.println("\n*** 1.New employee 2.View employee database 3.Employees working in company\t4.Bonus calcualtion\t5.Salary calculation\t6.All employees designation\t7.<Quit> ***\n");
System.out.println("Please give your option :");
opt=s.nextInt();
 switch(opt)
 {
 case 1: //main case 1
do{
System.out.println("\n1.fulltime employee\n2.parttime employee\n3.exit\n");
System.out.println("Your option\n");
o=s.nextInt();
        switch(o)
        {
        case 1:
            int opt2 = 0;
            System.out.println("How many employee you want add :");
            n=s.nextInt();
{
    
    for(i=0;i<n;i++){
        count1++;
        scount1=scount1+count1;
        System.out.println("Employee no : "+count1);
        System.out.print("\nType employee name :");
        name=s.next();
        array1.add(name);
        id=rand.nextInt(1287731)+1;
        System.out.print("\nThe "+name+" id is : "+id);
        System.out.print("\n\nEmployee designation :");
      
            System.out.println("Please select the following Designation:\n");
            System.out.println("1.Software Develping");
            System.out.println("2.Software Testing");
            System.out.println("3.Software Marketing");
            System.out.println("4.Hardware Design");
            System.out.println("5.Hardware manufacturing");
            System.out.println("6.Hardware Assembly");
            System.out.println("7.Hardware Testing");
            System.out.println("Your choice\t :");
            opt2=s.nextInt();
            switch(opt2)
            {
                    case 1:
                        design="Software Developing";
                    break;
                    case 2:
                        design="Software Testing";
                    break;
                    case 3:
                        design="Software Marketing";
                    break;
                    case 4:
                        design="Hardware Design";
                    break;
                    case 5:
                        design="Hardware manufacturing";
                    break;
                    case 6:
                        design="Hardware Assembly";
                    break;
                    case 7:
                        design="Hardware Testing";
                    break;
                                               
            }
   
        System.out.print("\nType employee email-id :");
        email=s.next();
            if("Software Developing".equals(design))
                allowance=1500;
             if("Software Testing".equals(design))
                allowance=800;
             if("Software Marketing".equals(design))
                allowance=700;
             if("Hardware Design".equals(design))
                allowance=2000;
             if("Hardware manufacturing".equals(design))
                allowance=1500;       
             if("Hardware Assembly".equals(design))
                allowance=900;
             if("Hardware Testing".equals(design))
                allowance=1000;
        System.out.print("\nType employee phone no :");
        pno=s.nextLong();
        hset1.add(design);
        f[i]=new fulltime(array1.get(i),design,email,id,pno,allowance,sam.salary_calc(allowance));
        
         try{  
    //step1 load the driver class  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //step2 create  the connection object  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tceit");  
      
    //step3 create the statement object  
    Statement stmt=con.createStatement();  
      
    //step4 execute query  
        String sql1="insert into fulltime values('" +id+ "','" +array1.get(i)+ "','"+design+"','"+email+"','"+pno+"','"+sam.salary_calc(allowance)+"')";
        stmt.executeUpdate(sql1);
    con.close();  
      
    }catch(Exception ee){ System.out.println(ee);}  
        
        
        
        System.out.println("\n****Employee details are stored in database successfully***\n");
       
    }
}
        break;
        case 2:
            System.out.println("How many employee you want add :");
            n=s.nextInt();

            for(i=0;i<n;i++)
            {
        count2++;
        scount2=scount2+count2;
        System.out.println("Employee no : "+count2);
        System.out.print("\nType employee name :");
        name=s.next();
         array2.add(name);
        id=rand.nextInt(1287731)+1;
        System.out.print("\nThe "+name+" id is : "+id);
        System.out.print("\n\nEmployee designation :");
      
            System.out.println("Please select the following Designation:\n");
            System.out.println("1.Data Maintenance");
            System.out.println("2.Application Develop");
            System.out.println("3.Server room cleaning");
                      opt2=s.nextInt();
            switch(opt2)
            {
                    case 1:
                        design="Data Maintenance";
                    break;
                    case 2:
                        design="Application Develop";
                    break;
                    case 3:
                        design="Server room cleaning";
                    break;
                                              
            }
        System.out.print("\nType employee email-id :");
        email=s.next();
        if("Data Maintenance".equals(design))
                allowance=400;
        if("Application Develop".equals(design))
                allowance=900;
        if("Server room cleaning".equals(design))
                allowance=300;
        System.out.print("\nType employee phone no :");
        pno=s.nextLong();
         hset2.add(design);
        p[i]=new parttime(array2.get(i),design,email,id,pno,allowance,sam.salary_calc(allowance));
        try{  
    //step1 load the driver class  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
      
    //step2 create  the connection object  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tceit");  
      
    //step3 create the statement object  
    Statement stmt=con.createStatement();  
      
    //step4 execute query  
        String sql2="insert into parttime values('" +id+ "','" +array2.get(i)+ "','"+design+"','"+email+"','"+pno+"','"+sam.salary_calc(allowance)+"')";
        stmt.executeUpdate(sql2);
    con.close();  
      
    }catch(Exception ee){ System.out.println(ee);}  
        
        
        
        System.out.println("\n****Employee details are stored in database successfully***\n");
            }
        break;
}
}while(o!=3);
break;
case 2: //main case 2

do{
System.out.println("\n1.fulltime employee\n2.parttime employee\n3.Overall employee\n4.exit\n");
System.out.println("Your option\n");
o=s.nextInt();
    switch(o)
{
        case 1:
System.out.println("\n\nEmployee name\tEmployee id\tDesignation\t\tE-mail\tContact no\tApprox month salary\n");
System.out.println("------------------------------------------------------------------------------------------\n");
try{
f[0].display(f,scount1);
}
catch(NullPointerException q)
{
    System.out.println("No data found these kind of employee\n");
}
        break;
        case 2:
System.out.println("\n\nEmployee name\tEmployee id\tDesignation\t\tE-mail\tContact no\tApprox month salary\n");
System.out.println("-------------------------------------------------------------------------------------------\n");
try{
p[0].display(p,scount2);
}
catch(NullPointerException q2)
{
    System.out.println("No data found these kind of employee\n");
}
        break;
        case 3:
            
System.out.println("\n\nEmployee name\tEmployee id\tDesignation\t\tE-mail\tContact no\n");
System.out.println("-----------------------------------------------------------------------------\n");
try{
f[0].display(p,f,scount2,scount1);
}
catch(NullPointerException w)
{
     System.out.println("No data found these kind of employee\n");
}
        break;
}
}while(o!=4);
break;

case 3: //main case 3
    do{
System.out.println("\n1.Overall employee in comapany\n2.fulltime employee in company\n3.parttime employee..\n4.exit\n");
System.out.println("Your option\n");
o=s.nextInt();
    switch(o)
{
        case 1:
            System.out.println("Totaly(fulltime & parttime): "+(scount1+scount2)+" employees are working in our comapany");
        break;
        case 2:
           System.out.println("The "+ f[0].emp_count(scount1)+" fulltime employees working in our company");
        break;
        case 3:
            System.out.println("The "+ p[0].emp_count(scount2)+" parttime employees working in our company");
        break;
}
}while(o!=4);
break;
case 4://main case 4
    int j;
    System.out.println("Employee name\tEmployee id\tBonus amount\n");
    System.out.println("--------------------------------------------------");
    for(j=0;j<scount1;j++){
   System.out.println(f[j].emp_name+"\t\t"+f[j].emp_id+"\t\t"+f[j].bonus_calculation());
       }
break;
case 5:
    int att;
        do
        {
            System.out.println("1.fulltime\t2.parttime\t3.exit\n ");
            System.out.println("\nyour option");
            o=s.nextInt();
            switch(o)
            {
                case 1:
                    for(i=0;i<scount1;i++)
                    {
                  
                    System.out.println("Type the employee attend hours");
                    att=s.nextInt();
                    full.fulltime_calc(att,f[i].daily_allowance);
                    }
                break;
                case 2:
                     for(i=0;i<scount2;i++)
                    {
                    System.out.println("Type the employee attend hours");
                    att=s.nextInt();
                    full.fulltime_calc(att,p[i].daily_allowance);
                    }
                break;
            }
            
        }
        while(o!=3);
break;
 case 6:

     do{
         System.out.println("1.View full designation\t2. View amount of designation present in our company\t3.exit\n");
         System.out.println("Your option\t");
         o=s.nextInt();
         switch(o)
         {
             case 1:
                 if(hset1.isEmpty()==true && hset2.isEmpty()==true)
                 {
                     System.out.println("The technical error, error is hashset is empty set");
                 }
                 else{
     System.out.println("The available fulltime employee in the following designation");
     System.out.println(hset1);
     System.out.println("\n");
      System.out.println("The available parttime employee in the following designation");
     System.out.println(hset2);
                 }
             break;
             case 2:
                 System.out.println("\nThe fulltime designation "+hset1.size());
                 System.out.println("\nThe fulltime designation "+hset2.size());
             break; 
         }
     }
     while(o!=3);
     
 break;
}
}
while(opt!=7);
 array1.clear();
 array2.clear();
 hset1.clear();
 hset2.clear();
}
}
