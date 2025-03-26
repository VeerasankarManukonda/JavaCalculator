package ShadowFox;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n📌 Select an Operation:");
			System.out.println("1. Basic Arithmetic (+, -, *, /)");
			System.out.println("2. Scientific Calculations (√, ^)");
			System.out.println("3. Unit Conversions (Temperature, Currency)");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1 -> basicArithmetic(scanner);
			case 2 -> scientificCalculations(scanner);
			case 3 -> unitConversions(scanner);
			case 4 -> {
				System.out.println("Exiting Calculator. Thank you!");
				scanner.close();
				return;
			}
			default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void basicArithmetic(Scanner scanner) {
		System.out.print("\nEnter first number: ");
		double num1 = scanner.nextDouble();
		System.out.print("Enter second number: ");
		double num2 = scanner.nextDouble();
		System.out.print("Choose operation (+, -, *, /): ");
		char op = scanner.next().charAt(0);

		double result;
		switch (op) {
		case '+' -> result = num1 + num2;
		case '-' -> result = num1 - num2;
		case '*' -> result = num1 * num2;
		case '/' -> {
			if (num2 == 0) {
				System.out.println("❌ Error: Division by zero is not allowed.");
				return;
			}
			result = num1 / num2;
		}
		default -> {
			System.out.println("Invalid operator.");
			return;
		}
		}
		System.out.println("✅ Result: " + result);
	}

	// 🔹 Scientific Calculations
	public static void scientificCalculations(Scanner scanner) {
		System.out.println("\n1. Square Root (√x)");
		System.out.println("2. Power (x^y)");
		System.out.print("Enter choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1 -> {
			System.out.print("Enter a number: ");
			double num = scanner.nextDouble();
			if (num < 0) {
				System.out.println("❌ Error: Cannot compute square root of negative number.");
				return;
			}
			System.out.println("✅ Square Root: " + Math.sqrt(num));
		}
		case 2 -> {
			System.out.print("Enter base (x): ");
			double base = scanner.nextDouble();
			System.out.print("Enter exponent (y): ");
			double exp = scanner.nextDouble();
			System.out.println("✅ Power Result: " + Math.pow(base, exp));
		}
		default -> System.out.println("Invalid choice.");
		}
	}

	public static void unitConversions(Scanner scanner) {
		System.out.println("\n1. Temperature Conversion (Celsius ↔ Fahrenheit)");
		System.out.println("2. Currency Conversion (USD ↔ INR)");
		System.out.print("Enter choice: ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1 -> {
			System.out.print("Enter temperature: ");
			double temp = scanner.nextDouble();
			System.out.print("Convert to (C/F)? ");
			char unit = scanner.next().toUpperCase().charAt(0);

			if (unit == 'C') {
				System.out.println("✅ Fahrenheit to Celsius: " + ((temp - 32) * 5 / 9) + "°C");
			} else if (unit == 'F') {
				System.out.println("✅ Celsius to Fahrenheit: " + ((temp * 9 / 5) + 32) + "°F");
			} else {
				System.out.println("Invalid unit.");
			}
		}
		case 2 -> {
			System.out.print("Enter amount: ");
			double amount = scanner.nextDouble();
			System.out.print("Convert to (USD/INR)? ");
			String currency = scanner.next().toUpperCase();

			double conversionRate = 82.5; // Example USD to INR rate
			if (currency.equals("USD")) {
				System.out.println("✅ INR to USD: $" + (amount / conversionRate));
			} else if (currency.equals("INR")) {
				System.out.println("✅ USD to INR: ₹" + (amount * conversionRate));
			} else {
				System.out.println("Invalid currency.");
			}
		}
		default -> System.out.println("Invalid choice.");
		}
	}
}
