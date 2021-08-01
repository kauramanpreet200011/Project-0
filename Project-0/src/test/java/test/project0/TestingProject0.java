package test.project0;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.project0.CustImpl1;

class TestingProject0 {
	@AfterEach
	void afterEach() {
		System.out.println("after each");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("after all");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("before each");
	}
	
	@BeforeAll
	 static void beforeAll() {
		System.out.println("before all");
	}
	
	@Test
	void testOne() {
		 System.out.println("======TEST ONE EXECUTED======="); 
		Assertions.assertEquals( true , CustImpl1.login1(10002,"kn"));
	}
}
