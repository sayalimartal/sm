package com.cg.organization;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;

import com.cg.organization.address.Address;

public class Organization {
	
	private String name;
	private Address address;
	private double marketValue;
	private LocalDate established;
	private int employeeCount;
	HashSet<String> globalPresence = new HashSet<>();
	ArrayList<String> boardMembers = new ArrayList<>(); 
	HashMap<String,String> projectManagers = new HashMap<>();
	
	private Properties proxyServers;
	
	public Organization() {
		
	}
	
	public Organization(String name, Address address, double marketValue, String established, int employeeCount) {
		super();
		this.name = name;
		this.address = address;
		this.marketValue = marketValue;
		String[] estdDate=established.split("/");
		this.established = LocalDate.of(Integer.parseInt(estdDate[2]), Integer.parseInt(estdDate[1]), Integer.parseInt(estdDate[0]));
		this.employeeCount = employeeCount;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public double getMarketValue() {
		return marketValue;
	}


	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}


	public LocalDate getEstablished() {
		return established;
	}


	public void setEstablished(LocalDate established) {
		this.established = established;
	}


	public int getEmployeeCount() {
		return employeeCount;
	}


	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}


	public HashSet<String> getGlobalPresence() {
		return globalPresence;
	}


	public void setGlobalPresence(HashSet<String> globalPresence) {
		this.globalPresence = globalPresence;
	}


	public ArrayList<String> getBoardMembers() {
		return boardMembers;
	}


	public void setBoardMembers(ArrayList<String> boardMembers) {
		this.boardMembers = boardMembers;
	}


	public HashMap<String, String> getProjectManagers() {
		return projectManagers;
	}


	public void setProjectManagers(HashMap<String, String> projectManagers) {
		this.projectManagers = projectManagers;
	}
	


	public Properties getProxyServers() {
		return proxyServers;
	}

	public void setProxyServers(Properties proxyServers) {
		this.proxyServers = proxyServers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((boardMembers == null) ? 0 : boardMembers.hashCode());
		result = prime * result + employeeCount;
		result = prime * result + ((established == null) ? 0 : established.hashCode());
		result = prime * result + ((globalPresence == null) ? 0 : globalPresence.hashCode());
		long temp;
		temp = Double.doubleToLongBits(marketValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectManagers == null) ? 0 : projectManagers.hashCode());
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
		Organization other = (Organization) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (boardMembers == null) {
			if (other.boardMembers != null)
				return false;
		} else if (!boardMembers.equals(other.boardMembers))
			return false;
		if (employeeCount != other.employeeCount)
			return false;
		if (established == null) {
			if (other.established != null)
				return false;
		} else if (!established.equals(other.established))
			return false;
		if (globalPresence == null) {
			if (other.globalPresence != null)
				return false;
		} else if (!globalPresence.equals(other.globalPresence))
			return false;
		if (Double.doubleToLongBits(marketValue) != Double.doubleToLongBits(other.marketValue))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectManagers == null) {
			if (other.projectManagers != null)
				return false;
		} else if (!projectManagers.equals(other.projectManagers))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Organization [name=" + name + ", address=" + address + ", marketValue=" + marketValue + ", established="
				+ established + ", employeeCount=" + employeeCount + ", globalPresence=" + globalPresence
				+ ", boardMembers=" + boardMembers + ", projectManagers=" + projectManagers + ", proxyServers="
				+ proxyServers + "]";
	}
	
	
	

}
