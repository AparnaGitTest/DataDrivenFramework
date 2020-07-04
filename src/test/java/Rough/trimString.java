package Rough;

import org.openqa.selenium.By;

public class trimString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "25% off";
		
		//System.out.println(result.substring(0, result.indexOf('%')));
		
		int MRP=3199;
		int noOfElement=3;
		
		int percent=20;
		double priceAsPerItem=(MRP*noOfElement);
		double percentDeduct=(priceAsPerItem/100)*percent;
		int finalPrice=(int) (priceAsPerItem-percentDeduct);
		System.out.println(priceAsPerItem);
		System.out.println(percentDeduct);
		System.out.println(finalPrice);
		
	}

}
