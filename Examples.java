import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;

public class Examples {
	ShootingRound five = new ShootingRound(5);
	ShootingRound four = new ShootingRound(4);
	ShootingRound three = new ShootingRound(3);
	ShootingRound two = new ShootingRound(2);
	ShootingRound one = new ShootingRound(1);
	
	LinkedList <ShootingRound> GoodList = new LinkedList <ShootingRound> ();
	ShootingResult example = new ShootingResult (GoodList);
	
	SkiingResult Pizza = new SkiingResult (50.0, 3, example);
	SkiingResult Fries = new SkiingResult (30.0, 1, example);
	SkiingResult Pries = new SkiingResult (40.0, 2, example);
	SkiingResult Help = new SkiingResult (100.0, 8, example);
	
	//team roster 1
	Athlete Joe = new Athlete (example, Pizza, "Joe");
	Athlete Bob = new Athlete (example, Pizza, "Bob");
	Athlete Sam = new Athlete (example, Fries, "Sam");
	Athlete Ken = new Athlete (example, Fries, "Ken");
	
	//team roster 2
	Athlete Joe2 = new Athlete (example, Pizza, "Joe");
	Athlete Bob2 = new Athlete (example, Fries, "Bob");
	Athlete Sam2 = new Athlete (example, Fries, "Sam");
	Athlete Ken2 = new Athlete (example, Fries, "Ken");
	
	LinkedList <Athlete> listOfAth = new LinkedList <Athlete>();
	LinkedList <Athlete> listOfAth2 = new LinkedList <Athlete>();
	
	
	Competition tester = new Competition (3, listOfAth);
	Competition tester2 = new Competition (3, listOfAth2);
	
	LinkedList <String> listOfString = new LinkedList <String> ();
	
	MassStartResult minus18points = new MassStartResult(100, 2);
	MassStartResult love = new MassStartResult(420, 22);
	
	public Examples(){}
	
	@Test
	//makes sure the method sums the targets hit correctly 
	public void test1() {
		GoodList.addFirst(five);
		GoodList.addFirst(four);
		GoodList.addFirst(four);
		assertEquals(example.pointsEarned(), 13, .01);
	}
	
	@Test
	//makes sure the method sums the targets hit correctly 
	public void test1ver2() {
		GoodList.addFirst(five);
		GoodList.addFirst(three);
		GoodList.addFirst(four);
		assertEquals(example.pointsEarned(), 12, .01);
	}
	
	@Test
	//makes sure the method produces the round with the highest targets hit
	public void test2() {
		GoodList.addFirst(five);
		GoodList.addFirst(four);
		GoodList.addFirst(four);
		assertEquals(example.bestRound(), five);
	}
	@Test
	//makes sure the method produces the right response when there are two of the best rounds
	public void test3() {
		GoodList.addFirst(three);
		GoodList.addFirst(three);
		GoodList.addFirst(two);
		assertEquals(example.bestRound(), three);
	}

	@Test
	//tests to make sure the method produces a list in the right order 
	public void test4() {
		GoodList.add(three);
		GoodList.add(two);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfString.add("Joe");
		listOfString.add("Bob");
		listOfString.add("Sam");
		listOfString.add("Ken");
		assertEquals(tester.shootingDNF(), listOfString);
	}
	@Test
	//tests to make sure the method produces an empty list if false
	public void test5() {
		GoodList.add(three);
		GoodList.add(two);
		GoodList.add(two);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		assertEquals(tester.shootingDNF(), listOfString);
	}
	@Test
	//tests to make sure the method produces the points earned of the ski result of the desired athlete
	public void test6() {
		GoodList.add(three);
		GoodList.add(two);
		GoodList.add(two);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		assertEquals(tester.skiingScoreForAthlete("Joe"), Joe.skiires.pointsEarned(), .01);
	}
	//testing again
	@Test
	public void test6ver2() {
		GoodList.add(three);
		GoodList.add(two);
		GoodList.add(two);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		assertEquals(tester.skiingScoreForAthlete("Bob"), Bob.skiires.pointsEarned(), .01);
	}
	@Test
	//tests to make sure the method produces the ski result of the desired athlete
	public void test7() {
		GoodList.add(five);
		GoodList.add(four);
		GoodList.add(four);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfAth2.add(Joe2);
		listOfAth2.add(Bob2);
		listOfAth2.add(Sam2);
		listOfAth2.add(Ken2);
		assertEquals (tester.anySkiingImprovement(tester2), true);
	}
	
	@Test
	//tests to make sure the method produces false if the athletes are the same
	public void test8() {
		GoodList.add(five);
		GoodList.add(four);
		GoodList.add(four);
		listOfAth.add(Joe);
		listOfAth.add(Bob);
		listOfAth.add(Sam);
		listOfAth.add(Ken);
		listOfAth2.add(Joe);
		listOfAth2.add(Bob);
		listOfAth2.add(Sam);
		listOfAth2.add(Ken);
		assertEquals (tester.anySkiingImprovement(tester2), false);
	}
	@Test
	//makes sure the method produces the better skiier if the better skiier is this
	public void test9() {
		assertEquals(Sam.betterSkiier(Joe), Sam);
	}
	
	@Test
	//makes sure the method produces the better skiier if the better skiier is this
	public void test10() {
		assertEquals(Bob.betterSkiier(Sam), Sam);
	}
	
	@Test
	//makes sure the method produces true if he has a better skiing or shooting score
	public void test11() {
		assertEquals(Sam.hasBeaten(Joe), true);
	}
	@Test
	//makes sure the method produces false if the (this) athlete does not have a better skiing or shooting score
	// than the other athlete
	public void test12() {
		assertEquals(Joe.hasBeaten(Sam), false);
	}
	
	@Test
	//makes sure the penalties are added correctly
	public void test13() {
		GoodList.addFirst(five);
		GoodList.addFirst(three);
		GoodList.addFirst(four);
		assertEquals(Fries.addShootingPenalties(example), 190, .1);
	}
	@Test
	//makes sure the penalties are added correctly
	public void test14() {
		GoodList.addFirst(five);
		GoodList.addFirst(three);
		GoodList.addFirst(four);
		assertEquals(Pries.addShootingPenalties(example), 200, .1);
	}
	@Test
	//tests 1st place
	public void test15() {
		GoodList.addFirst(five);
		GoodList.addFirst(three);
		GoodList.addFirst(four);
		assertEquals(Fries.pointsEarned(), 180, .1);
	}
@Test
	//tests 2nd place
	public void test16() {
		GoodList.addFirst(five);
		GoodList.addFirst(three);
		GoodList.addFirst(four);
		assertEquals(Pries.pointsEarned(), 193, .1);
	}
	@Test
	//tests 3rd place
		public void test17() {
			GoodList.addFirst(five);
			GoodList.addFirst(three);
			GoodList.addFirst(four);
			assertEquals(Pizza.pointsEarned(), 207, .1);
		}
	
	@Test
	//tests anything but 1st, 2nd, 3rd
		public void test18() {
			GoodList.addFirst(five);
			GoodList.addFirst(three);
			GoodList.addFirst(four);
			assertEquals(Help.pointsEarned(), 260, .1);
		}
	
	@Test
	//tests that it returns time
		public void test19() {
			assertEquals(minus18points.pointsEarned(), 100, .1);
		}
	
	@Test
	//tests that it returns time
		public void test20() {
			assertEquals(love.pointsEarned(), 420, .1);
		}
}
