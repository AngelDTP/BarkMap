package com.BarkMap.BarkMap.Models;

import java.util.HashSet;
import java.util.Set;

public enum Role {
	GESTIONNAIRE("ROLE_GESTIONNAIRE"),
	UTILISATEUR("ROLE_UTILISATEUR"),
	;

	private final String string;
	private final Set<Role> managedRoles = new HashSet<>();

	static{
		GESTIONNAIRE.managedRoles.add(UTILISATEUR);
	}

	Role(String string){
		this.string = string;
	}

	@Override
	public String toString(){
		return string;
	}

}
