package gr.upatras;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaperTest {

	Paper paper = new Paper(1,"name","DESC",99,99,99,99);
	
	@Test
	public void testGetDetails() {
		assertEquals("99 99",paper.getDetails());
	}

	

	@Test
	public void testGetWeight() {
		assertSame(99,paper.getWeight());
	}

	@Test
	public void testSetWeight() {
		paper.setWeight(50);
		assertSame(50,paper.getWeight());
	}

	@Test
	public void testGetPageNum() {
		assertSame(99,paper.getPageNum());
	}

	@Test
	public void testSetPageNum() {
		paper.setPageNum(50);
		assertSame(50,paper.getPageNum());
	}

	
	

	@Test
	public void testGetName() {
		assertSame("name",paper.getName());
	}

	@Test
	public void testSetName() {
		paper.setName("name2");
		assertSame("name2",paper.getName());
	}

	@Test
	public void testGetPrice() {
		assertSame(99,paper.getPrice());
	}

	@Test
	public void testSetPrice() {
		paper.setPrice(5);
		assertSame(5,paper.getPrice());
	}

	@Test
	public void testGetDiscripsion() {
		assertEquals("DESC",paper.getDiscripsion());
	}

	@Test
	public void testSetDiscripsion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBasicInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFullDetails() {
		fail("Not yet implemented");
	}

}
