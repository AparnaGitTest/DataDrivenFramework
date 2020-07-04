package Rough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class arrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> priceList=new ArrayList<String>();
		priceList.add("?111");
		priceList.add("?222");
		priceList.add("?244");
		priceList.add("?333");
		priceList.add("?555");
		
		
		ArrayList<Integer> newlist=new ArrayList<Integer>(priceList.size());
		
		//System.out.println(priceList.ge);
		
		for(int i=0;i<priceList.size();i++)
		{
			int price=Integer.valueOf(priceList.get(i).substring(1));
			newlist.add(price);
		}
		System.out.println(newlist);
		ArrayList<Integer> newlist2=(ArrayList<Integer>)newlist.clone();
		
		
		Collections.sort(newlist2);
		System.out.println(newlist);
		System.out.println(newlist2);
	if(newlist.equals(newlist2))
	{
		System.out.println("True");
	}
	else
	{
		System.out.println("false");
	}
		
		
		
	
		
		
		

	}

}
