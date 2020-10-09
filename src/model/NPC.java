package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="npcs")
public class NPC {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="RACE")
	private String race;
	
	@Column(name="AGE")
	private int age;
	
	//constructors
	public NPC() {
		super();
		//  Auto-generated constructor stub
	}
	public NPC(String name, String race, int age) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String Describe() {
		String output = getName() + " is a " + getAge() + " Y/O " + getRace();
		return output;
	}
	@Override
	public String toString() {
		return "NPC [id=" + id + ", name=" + name + ", race=" + race + ", age=" + age + "]";
	}
	
	
}
