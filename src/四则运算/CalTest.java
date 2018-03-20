package ��������;

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
        //���������
		char [] instruction = {'+','-','*','/'};
		Random random = new Random();
		//������ɵ���ʽ
		List<String> equations=new ArrayList<String>();
				
		System.out.println("���ɼ�����ʽ��");
		Scanner number = new Scanner(System.in);
        int n=number.nextInt();
        
        for(int i=0;i<n;i++)
        {
        	
        	int ins=random.nextInt(3)+3;//3~5����ʽ����ins���ո���
        	int e=(int) (Math.random()*100+1);
        	StringBuilder equation= new StringBuilder();//��̬�ַ�����������������ʽ
        	equation.append(e);
        	int left=e;
            //ѭ��������ʽ
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
        		//System.out.println(right);������ɵ���
            
        }//�����
        	String ex=equation.toString();
        	equations.add(ex);
	}//for(��Ŀ��)
        
        //ʹ����ǿforѭ���ķ�������
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
