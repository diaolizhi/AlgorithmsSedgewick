
public class Transaction_my implements Comparable<Transaction_my>{
	
	private String who;
	private Date when;
	private double amount;

	public Transaction_my(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	public String who() {
		return this.who;
	}
	
	public Date when() {
		return this.when;
	}

	public double amount() {
		return this.amount;
	}

	@Override
	public String toString() {
		return this.when + " " + this.who + " " + this.amount;
	}

	/**
	 * Ex_1_2_14
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Transaction_my t = (Transaction_my) obj;
		if(t.who != this.who) return false;
		if(t.when != this.when) return false;
		if(t.amount != this.amount) return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((when == null) ? 0 : when.hashCode());
		result = prime * result + ((who == null) ? 0 : who.hashCode());
		return result;
	}

	@Override
	public int compareTo(Transaction_my o) {
		return this.when.compareTo(o.when);
	}
}
