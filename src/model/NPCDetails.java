package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="npc_details")
public class NPCDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DETAIL_ID")
	private int id;
	@Column(name="CREATED_DATE")
	private LocalDate createdDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="NPC_ID")
	private NPC npc;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="STATBLOCK_ID")
	private StatBlock statblock;
	
	//constructors
	public NPCDetails() {
		super();
		//  Auto-generated constructor stub
	}
	public NPCDetails(int id, LocalDate createdDate, NPC npc, StatBlock statblock) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.npc = npc;
		this.statblock = statblock;
	}
	public NPCDetails(LocalDate createdDate, NPC npc, StatBlock statblock) {
		super();
		this.createdDate = createdDate;
		this.npc = npc;
		this.statblock = statblock;
	}
	public NPCDetails(LocalDate createdDate, NPC npc) {
		super();
		this.createdDate = createdDate;
		this.npc = npc;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public NPC getNpc() {
		return npc;
	}
	public void setNpc(NPC npc) {
		this.npc = npc;
	}
	public StatBlock getStatblock() {
		return statblock;
	}
	public void setStatblock(StatBlock statblock) {
		this.statblock = statblock;
	}
	@Override
	public String toString() {
		return "NPCDetails [id=" + id + ", createdDate=" + createdDate + ", npc=" + npc + ", statblock=" + statblock
				+ "]";
	}
	
}
