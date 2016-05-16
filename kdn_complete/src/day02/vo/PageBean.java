package day02.vo;

public class PageBean {

	private String key;
	private String word;
	private int pageNo;
	private int total;
	private int interval=10;
	private int start, end;

	public PageBean(String key, String word, int pageNo, int interval) {
		this.key = key;
		this.word = word;
		this.pageNo = pageNo;
		this.interval = interval;
	}
	public PageBean(String key, String word, int pageNo) {
		this.key = key;
		this.word = word;
		this.pageNo = pageNo;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		if(pageNo>1){
			return start =  (pageNo -1) * interval + 1;
		}else{
			return   1;
		}
	}

	public int getEnd() {
		return getStart()+interval - 1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [key=");
		builder.append(key);
		builder.append(", word=");
		builder.append(word);
		builder.append(", pageNo=");
		builder.append(pageNo);
		builder.append(", total=");
		builder.append(total);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
	}
	
}





