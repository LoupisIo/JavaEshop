/**
 * 
 */
package gr.upatras;

/**
 * @author loupis.io
 *
 */
public class NoteBook extends Item {
	
	public int sections;
	public int pageNum;
	
	public NoteBook(int id, String name, String description, double price, int stock, int sections, int pageNum){
		super(id, name, description, price, stock,"Notebook");
		this.sections = sections;
		this.pageNum = pageNum;
	}
	
	public String getDetails() {
        return sections + " " + pageNum;
    }

	public int getSections() {
		return sections;
	}

	public void setSections(int sections) {
		this.sections = sections;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
