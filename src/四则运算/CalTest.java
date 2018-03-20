package 四则运算;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class CalTest {

	public static void main(String[] args) throws ScriptException  {
		
		CalTest test = new CalTest();
		
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        //运算符数组
		char [] instruction = {'+','-','*','/'};
		Random random = new Random();
		//存放生成的算式
		List<String> equations=new ArrayList<String>();
				
		System.out.println("生成几个算式？");
		Scanner number = new Scanner(System.in);
        int n=number.nextInt();
        
        for(int i=0;i<n;i++)
        {
        	
        	int ins=random.nextInt(3)+3;//3~5个算式，用ins接收个数
        	int e=(int) (Math.random()*100+1);
        	StringBuilder equation= new StringBuilder();//动态字符串，接收四则运算式
        	equation.append(e);
        	int left=e;
            //循环生成算式
            for(int j=0;j<ins;j++)
            {
            	
            	char c=instruction[random.nextInt(4)];
            	int right=(int) (Math.random()*100+1);
            	if(c=='+') 
            	{
            		e=e+right;
            		//left=right;
            	}
            	if(c=='-')
            	{
            		//
            		if(left-right<0)
            		{
            			right=(int) (Math.random()*e+1);
            			
            		}
            		e=e-right;
            		//left=right;
            	}
            	if(c=='*')
            	{
            		e=e*right; 
            		//left=right;
            	}
            	if(c=='/')
            	{
            		do {
            			right=(int) (Math.random()*e+1);
            		}while(left%right!=0);
            		e=e/right;
            	}
            	left=right;
        		equation.append(c);
        		equation.append(right);
        		//System.out.println(right);随机生成的数
            
        }//运算符
        	String ex=equation.toString();
        	equations.add(ex);
	}//for(题目数)
        
        //使用增强for循环的方法遍历
        try {  
	        FileWriter fw = new FileWriter("lilei.txt");  
	        BufferedWriter bw = new BufferedWriter(fw);  
	        bw.append("201571030114"); 
	        bw.newLine();
	        for(String e:equations) {
	     	   e=e+"="+se.eval(e.toString());
	     	   System.out.println(e);
	     	   bw.write(e.toString()); 
	     	   bw.newLine();
	         }
	         bw.close();  
	 	       fw.close(); 
	        //e=e+"="+se.eval(e.toString());
	    } catch (Exception ee) {  
	        // TODO Auto-generated catch block  
	        ee.printStackTrace();  
	    }  
        
	}
}
