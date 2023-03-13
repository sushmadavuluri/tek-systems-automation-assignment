package org.tek.systems.automation.assignment.triangle;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TriangleTest {

	Triangle triangle;

	@BeforeEach
	void tearUp() {
		triangle = new Triangle();
	}

	@AfterEach
	void tearDown() {
		triangle = null;
	}

	// Test case 1: verify if triangle is printed
	@Test
	void should_print_triangle() {
		List<String> triangleRows = triangle.triangle(5);
		assertEquals(5, triangleRows.size());
	}

	// Test case 2: when invalid input is passed
	@Test
	void should_print_triangle_invaild_input() {
		List<String> triangleRows = triangle.triangle(-1);
		assertEquals(0, triangleRows.size());
	}

	// Test case 3: When user send input as zero
	@Test
	void should_print_triangle_with_0() {
		List<String> triangleRows = triangle.triangle(0);
		assertEquals(0, triangleRows.size());
	}

	// Test case 4: When user send high value input
	@Test
	void should_print_triangle_with_high_value_input() {
		List<String> triangleRows = triangle.triangle(999);
		assertEquals(999, triangleRows.size());
	}

	// Test case 5: Verify if characters of last line equal to input of number of lines
	@Test
	void stars_of_the_last_row_of_triangle_should_equal_to_the_input() {
		List<String> triangleRows = triangle.triangle(10);
		assertEquals(10, triangleRows.get(triangleRows.size() - 1).length());
	}

	// Test case 6: When random line is picked up verifying if number of characters equal to row number
	@Test
	void if_row_number_is_equal_to_the_number_of_characters_in_the_row() {
		int noOfRows = 25;
		List<String> triangleRows = triangle.triangle(noOfRows);
		Random rand = new Random();
		int int_random = rand.nextInt(noOfRows) + 1;
		assertEquals(int_random, triangleRows.get(int_random - 1).length());
	}

	// Test case 7: Verify if characters of previous and next line is always lesser and grater than the any given line
	// except the last and first line of the triangle
	@Test
	void check_the_previous_and_after_lines_of_a_triangle_to_make_sure_no_of_characters_of_those_lines_are_correct() {
		List<String> triangleRows = triangle.triangle(15);
		int noOfCharactersInLine9 = triangleRows.get(9 - 1).length();
		int noOfCharactersInLine10 = triangleRows.get(10 - 1).length();
		int noOfCharactersInLine11 = triangleRows.get(11 - 1).length();
		assertEquals(9, noOfCharactersInLine9);
		assertEquals(11, noOfCharactersInLine11);

		assertTrue(noOfCharactersInLine9 < noOfCharactersInLine10);
		assertTrue(noOfCharactersInLine11 > noOfCharactersInLine10);
	}

	// Test case 8: Verify if length of the characters is linearly increasing
	@Test
	void check_all_the_rows_of_a_triangle_and_see_if_size_is_linearly_increasing() {
		List<String> triangleRows = triangle.triangle(55);
		for (int i = 1; i < triangleRows.size() - 1; i++) {
			assertEquals(i, triangleRows.get(i - 1).length());
		}
	}
}