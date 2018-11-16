package org.zerock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="t_member_auth")
public class MemberAuth {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ano;
	private String auth;
	
	
	public MemberAuth(String auth) {
		this.auth = auth;
	}

}
