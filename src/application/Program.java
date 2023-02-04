package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CorporateAccounting;
import entities.PersonalAccounting;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter number tax payers: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Tax payer #"+(i+1)+" data:");
			System.out.print("Personal or Corpoate (p/c)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			if(type == 'p')
			{
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				list.add(new PersonalAccounting(name, annualIncome, health));
			}
			else
			{
				System.out.print("Number of employees: ");
				int number = sc.nextInt();
				list.add(new CorporateAccounting(name,annualIncome,number));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0;
		
		for(TaxPayer payers : list) 
		{
			System.out.println(payers);
		}
		
		for(TaxPayer payers :list)
		{
			sum += payers.taxPayment();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: %.2f", sum);
		sc.close();
	}

}
