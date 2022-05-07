/**
 * 
 */
package gr.upatras;

/**
 * @author loupis.io
 *
 */
public class Paper extends Item {
	
	public int weight;
	public int pageNum;
	
	public Paper(int id, String name, String description, double price, int stock, int weight, int pageNum) {
		super(id, name, description, price, stock,"Paper");
		this.weight = weight;
		this.pageNum = pageNum;
		
	}
	
	public String getDetails() {
        return weight + " " + pageNum;
    }

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	

}
