package aufgaben.collection.auto;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Auto {
	int baujahr;
	String modell;

	public Auto(String modell, int baujahr) {
		this.baujahr = baujahr;
		this.modell = modell;
	}
	
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	public void setModell(String modell) {
		this.modell = modell;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(baujahr).append(modell).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if( ! (obj instanceof Auto) )
			return false;
		Auto ref = (Auto)obj;
		return modell.equals(ref.modell) && baujahr == ref.baujahr;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ". Modell: " + modell + ", Baujahr " + baujahr;
	}
}
