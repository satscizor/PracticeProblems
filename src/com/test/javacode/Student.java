package com.test.javacode;

public class Student implements Comparable<Student> {
 private Integer id;
 private String name;
 private String standard;

 public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStandard() {
	return standard;
}
public void setStandard(String standard) {
	this.standard = standard;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((standard == null) ? 0 : standard.hashCode());
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
	Student other = (Student) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (standard == null) {
		if (other.standard != null)
			return false;
	} else if (!standard.equals(other.standard))
		return false;
	return true;
}

	@Override
	public int compareTo(Student st) {
		if(st.getId().equals(getId()))
			return 0;
		else if(st.getId()>getId()) {
			return 1;
		}
		else
			return -1;
	}
 


}
