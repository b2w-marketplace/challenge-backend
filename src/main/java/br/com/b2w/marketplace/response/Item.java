package br.com.b2w.marketplace.response;

import org.springframework.util.ObjectUtils;

/**
 * @author Felipe
 *
 */
public class Item {

	private String name;

	private String code;

	private String date;

	private Dimension dimension;

	public Item(String name, String code, String date, Dimension dimension) {
		this.name = name;
		this.code = code;
		this.date = date;
		
		if (ObjectUtils.isEmpty(dimension)) {
			dimension = new Dimension(0.0, 0.0, 0.0, 0.0);
		}
		
		this.dimension = dimension;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getDate() {
		return date;
	}

	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(code);
		builder.append(", date=");
		builder.append(date);
		builder.append(", dimension=");
		builder.append(dimension);
		builder.append("]");
		return builder.toString();
	}

}
