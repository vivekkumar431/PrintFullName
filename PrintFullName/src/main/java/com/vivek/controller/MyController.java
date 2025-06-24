package com.vivek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	//Name Page
     @RequestMapping("/")
     public String namePage() {
    	 return "name";
     }
     @RequestMapping("/req1")
     public String printFullName(@RequestParam String fname,@RequestParam String lname,ModelMap model){
    	 String fullname=fname+" "+lname;
    	 model.put("fname", fname);
    	 model.put("lname", lname);
    	 model.put("fullname", fullname);
    	 return "printName";
    	 }
     
     //Bigest Number Page
	  @RequestMapping("/big")
    public String numberPage() {
   	 return "bigNumber";
    }
     @RequestMapping("/req2")
     public String pringNumberPage(@RequestParam int num1,@RequestParam int num2,@RequestParam int num3,ModelMap model1){
    	int biggest =0;
    	if(num1>num2&&num1>num3) {
    		biggest=num1;
    	}
    	else if(num2>num1&&num2>num3) {
    		biggest=num2;
    	}
    	else {
    		biggest=num3;
    	}
    	model1.put("bignum", biggest);
    	 return "printBigNumber";
    	 }
     
     
     //Student Marks Details
     @RequestMapping("/student")
     public String studentPage() {
    	 return "student";
     }
     @RequestMapping("/stu")
     public String printStudentPage(@RequestParam String fname,@RequestParam String lname,@RequestParam String course,@RequestParam int fee,@RequestParam int hno,@RequestParam int hib,@RequestParam int spring,@RequestParam int springboot,ModelMap model){
    	 String fullname=fname+" "+lname;
    	 model.put("fullname", fullname);
    	 model.put("course",course);
    	 model.put("fee",fee);
    	 model.put("hno",hno);
    	 model.put("hib",hib);
    	 model.put("spring",spring);
    	 model.put("springboot",springboot);
    	 int total=hib+spring+springboot;
    	 model.put("total",total);
    	 double percen=total/3;
    	 model.put("percen",percen);
    	 String grade="",pass="";
    	 if(percen>70) {
    		 grade="A Grade";
    		 pass="pass";
    	 }
    	 else if(percen>60&&percen<=70) {
    		 grade="B Grade";
    		 pass="pass";
    	 }
    	 else{
    		 grade="C Grade";
    		 pass="fail";
    	 }
    	 model.put("grade",grade);
    	 model.put("pass",pass);
    	 return "printStudent";
    	 }
     
     //login Page
     @RequestMapping("/login")
       public String loginPage() {
    	   return "login";
       }
     @RequestMapping("/loginpage")
     public String loginPageDemo(@RequestParam String uname,@RequestParam String psw,ModelMap model) {
    	String message="";
    	 if(uname.equals("vivek") && psw.equals("12345")) {
    		 message="Sucess Message";
    	 }
    	 else {
    		 message="Wrong Message";
    	 }
    	 model.put("message", message);
  	   return "loginpage";
     }
     
     //Electric Bill Page
     @RequestMapping("/consumer")
     public String consumerPage() {
  	   return "consumer";
     }
     @RequestMapping("/consumerbill")
     public String consumerBillPage(@RequestParam String cid,@RequestParam String cname,@RequestParam int creading,@RequestParam int preading,ModelMap model) {
    	model.put("cid", cid);
    	model.put("cname",cname);
    	model.put("creading",creading);
    	model.put("preading",preading);
         int units=creading-preading;
         model.put("units",units);
         double rate=0.0;
         if(units>=500) {
        	 rate=7.25;
         }
         else if(units>300 &&units<500) {
        	 rate=3.25;
         }
         else {
        	 rate=1.75;
         }
           double totalbill=units*rate;
           model.put("totalbill", totalbill);
    	return "consumerbill";
     }
     
     //Product Page
     @RequestMapping("/product")
     public String productPage() {
  	   return "product";
     }
     @RequestMapping("/productinvoice")
     public String productInvoicePage(@RequestParam String cid,@RequestParam String cname,@RequestParam long mob,@RequestParam String pname,@RequestParam double price,@RequestParam int quantity,ModelMap model) {
    	model.put("cid", cid);
    	model.put("cname",cname);
    	model.put("mob",mob);
    	model.put("pname",pname);
        model.put("price", price);
        model.put("quantity",quantity);
        double totalAmount=price*quantity;
        model.put("totalAmount",totalAmount);
        double dis=0.0;
        if(totalAmount>=5000) {
        	dis=0.30;
        }
        else if(totalAmount>=2500&&totalAmount<5000) {
        	dis=0.15;
        }
        else {
        	dis=0.1;
        }
        double disAmount=totalAmount*dis;
        model.put("disAmount",disAmount);
        double gst=totalAmount*(0.18);
        model.put("gst", gst);
        double invoicebill=(totalAmount-disAmount)+gst;
        model.put("invoicebill",invoicebill);
    	return "productinvoice";
     }
     
     //Employee Salary Details Page
     @RequestMapping("/emp")
     public String emppage() {
  	   return "emp";
     }
     @RequestMapping("/empinvoice")
     public String empinvoicePage(@RequestParam String eno,@RequestParam String ename,@RequestParam double salary,ModelMap model) {
    	model.put("eno",eno);
    	model.put("ename",ename);
    	model.put("salary",salary);
    	double ta=0.0,da=0.0,hra=0.0,pf=0.0;
    	if(salary>=50000) {
    		ta=0.17;
    		da=0.19;
    		hra=0.21;
    		pf=0.25;
    	}
    	else if(salary>=30000&&salary<50000) {
    		ta=0.12;
    		da=0.13;
    		hra=0.17;
    		pf=0.22;
    	}
    	else {
    		ta=0.07;
    		da=0.09;
    		hra=0.11;
    		pf=0.15;
    	}
    	double taAmount=salary*ta;
    	double daAmount=salary*da;
    	double hraAmount=salary*hra;
    	double pfAmount=salary*pf;
    	
    	model.put("ta",taAmount);
    	model.put("da",daAmount);
    	model.put("hra",hraAmount);
    	model.put("pf",pfAmount);
    	double gsalary=salary+taAmount+daAmount+hraAmount+pfAmount;
    	model.put("gsalary",gsalary);
    	double nsalary=salary;
    	model.put("nsalary",nsalary);
    	return "empinvoice";
     }
     }     
	

