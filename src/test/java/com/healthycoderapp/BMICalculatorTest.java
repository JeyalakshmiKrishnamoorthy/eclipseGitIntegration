package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BMICalculatorTest {

	@Test
	void should_ReturnTrue_When_DietRecommended() {
		//given 
		double weight = 89.0;
		double height=1.72;
		
		//when
		boolean recommended= BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertTrue(recommended);
		
	}
	
	@Test
	void should_ReturnFalse_When_DietNotRecommended() {
		//given 
		double weight = 56.0;
		double height=1.72;
		
		//when
		boolean recommended= BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertFalse(recommended);
		
	}
	
	@Test
	void should_ThrowArithmeticException_when_heightIsZero() {
		//given 
		double weight = 56.0;
		double height=0.0;
		
		//when
		Executable executable= ()->BMICalculator.isDietRecommended(weight, height);
		
		//then
		assertThrows(ArithmeticException.class, executable);
		
	}
	
	@Test
	void should_ReturnCoderWithWorstBMI_WhenCoderListNotEmpty() {
		
		//given
		List<Coder> coders = new ArrayList();
		coders.add(new Coder(1.80, 60.0));
		coders.add(new Coder(1.80, 98.0));
		coders.add(new Coder(1.80, 70.0));
		
		
		//when
		Coder codeWorstBMI=BMICalculator.findCoderWithWorstBMI(coders);
	
		
		//then
		assertAll(
		()->assertEquals(1.80, codeWorstBMI.getHeight()),
		()->assertEquals(98.0, codeWorstBMI.getWeight()));
	}

	
	@Test
	void should_ReturnNull_WhenCoderListEmpty() {
		
		//given
		List<Coder> coders = new ArrayList();
		
		//when
		Coder codeWorstBMI=BMICalculator.findCoderWithWorstBMI(coders);
	
		
		//then
		assertNull(codeWorstBMI);
	}
}
