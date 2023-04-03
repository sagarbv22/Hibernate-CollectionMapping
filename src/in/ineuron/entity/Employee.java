package in.ineuron.entity;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.ListIndexBase;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;

	@ElementCollection
	@CollectionTable(name = "friend_list", joinColumns = @JoinColumn(name = "eid", referencedColumnName = "eid"))
	@OrderColumn(name = "friend_no")
	@ListIndexBase(value = 1)
	@Column(name = "friend_name")
	private List<String> friendList;
	
	@ElementCollection
	@CollectionTable(name = "emp_phNo", joinColumns = @JoinColumn(name="eid", referencedColumnName = "eid"))
	@Column(name = "phNo")
	private Set<Long> phNo;

	
	@ElementCollection
	@CollectionTable(name = "bank_acc", joinColumns = @JoinColumn(name="eid",referencedColumnName = "eid"))
	@MapKeyColumn(name = "bank_name", length =10)
	@Column(name = "acc_no")
	private Map<String, Long> bankAcc;


	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public List<String> getFriendList() {
		return friendList;
	}


	public void setFriendList(List<String> friendList) {
		this.friendList = friendList;
	}


	public Set<Long> getPhNo() {
		return phNo;
	}


	public void setPhNo(Set<Long> phNo) {
		this.phNo = phNo;
	}


	public Map<String, Long> getBankAcc() {
		return bankAcc;
	}


	public void setBankAcc(Map<String, Long> bankAcc) {
		this.bankAcc = bankAcc;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", friendList=" + friendList + ", phNo=" + phNo
				+ ", bankAcc=" + bankAcc + "]";
	}

	
	
	
	
}
