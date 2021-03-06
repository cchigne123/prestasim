package pe.edu.upc.prestasim.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PaymentRanks {

	private int id_payment_rank;
	private String name;
	private Double max_value;

	public int getId_payment_rank() {
		return id_payment_rank;
	}
	public void setId_payment_rank(int idPaymentRank) {
		this.id_payment_rank = idPaymentRank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMax_value() {
		return max_value;
	}
	public void setMax_value(Double maxValue) {
		this.max_value = maxValue;
	}

}
