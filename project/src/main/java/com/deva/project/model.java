package com.deva.project;

public class model 
{
int id;
String name;
String desc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
@Override
public String toString() {
	return "model [id=" + id + ", name=" + name + ", desc=" + desc + "]";
}
public void setDesc(String desc) {
	this.desc = desc;
}
}
