package com.sqa.ala;

import com.sqa.ala.helpers.*;

public class NumbersApp {

	public static void main(String[] args) {
		String name = AppBasics.greetUser("Basic App");
		addNumbers();
		AppBasics.farewellUser(name);
	}

	private static void addNumbers() {
		int number1 = AppBasics.requestInt("Can I get a number");
		int number2 = AppBasics.requestInt("Can I get another number");
		int total = number1 + number2;
		System.out.println("Looks like you have a total of " + total);
	}
}
