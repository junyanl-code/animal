/**
 * User.java
 * com.oracle.JDBC.ATMDemo.pojo
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2019年2月25日 		a
 *
 * Copyright (c) 2019, TNT All Rights Reserved.
*/

package neau.cekong.pojo;

import java.math.BigDecimal;

/**
 * ClassName:User Function: TODO ADD FUNCTION Reason: TODO ADD REASON
 *
 * @author a
 * @version
 * @since Ver 1.1
 * @Date 2019年2月25日 下午4:04:03
 *
 * @see
 */
public class User {
	private int uid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	private String uname;
	private String password;
	private BigDecimal balance;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
