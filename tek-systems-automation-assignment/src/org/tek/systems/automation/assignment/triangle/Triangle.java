package org.tek.systems.automation.assignment.triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	public List<String> triangle(int noOfRows) {
		List<String> triangle = new ArrayList<String>();
		String row = "";
		try {
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j <= i; j++) {
					row = row.concat("*");
				}
				triangle.add(row);
				row = "";
			}
		} catch (Exception e) {
			System.out.println("Error printing the Triangle");
		}
		return triangle;
	}
}

// for third deliverable

// Initially I implemented code like this for line 11
// for(int i=0;i<=noOfRows;i++)
// When I'm working on test cases I came across issue of adding extra row for triangle at the end
// after debugging the issue changed line 11 to for(int i=0;i<noOfRows;i++)
