package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stats")
public class StatBlock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="STAT_ID")
	private int id;
	@Column(name="STRENGTH")
	private int strength;
	@Column(name="DEXTERITY")
	private int dexterity;
	@Column(name="CONSTITUTION")
	private int constitution;
	@Column(name="INTELLIGENCE")
	private int intelligence;
	@Column(name="WISDOM")
	private int wisdom;
	@Column(name="CHARISMA")
	private int charisma;
	
	//Constructors
	public StatBlock(int id, int strength, int dexterity, int constitution, int intelligence, int wisdom,
			int charisma) {
		super();
		this.id = id;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}
	public StatBlock(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
		super();
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}
	public StatBlock() {
		super();
		//  Auto-generated constructor stub
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getConstitution() {
		return constitution;
	}
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getWisdom() {
		return wisdom;
	}
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	public int getCharisma() {
		return charisma;
	}
	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}
	@Override
	public String toString() {
		return "StatBlock [id=" + id + ", strength=" + strength + ", dexterity=" + dexterity + ", constitution="
				+ constitution + ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma
				+ "]";
	}
	
}
