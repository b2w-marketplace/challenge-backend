package br.com.challengebackend.challengebackend.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dimension {
    
	@Id
	private Long code; 
	private double weight; 
    private double height; 
    private double width;
    private double length;

    @Override
    public int hashCode() {
    	final int prime = 31;
    	int result = 1;
    	result = prime * result + ((code == null) ? 0 : code.hashCode());
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
    	Dimension other = (Dimension) obj;
    	if (code == null) {
    		if (other.code != null)
    			return false;
    	} else if (!code.equals(other.code))
    		return false;
    	return true;
    }

	/*public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}*/

	public double getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
}
