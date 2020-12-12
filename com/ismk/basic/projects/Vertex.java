package com.ismk.basic.projects;

class Vertex {
	Integer value;
    Vertex(Integer value) {
        this.value = value;
    }
    
    //Depends only on value number
    @Override
    public int hashCode() {
        return value;
    }
    
   
 
    @Override
	public String toString() {
		return this.value +"";
	}

	//Compare only vertices
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (this.value.intValue() != other.value.intValue())
            return false;
        return true;
    }

}