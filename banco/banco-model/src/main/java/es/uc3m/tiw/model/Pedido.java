package es.uc3m.tiw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	private String codigoPedido;
	private String numeroTarjeta;
	private double importe;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	public Pedido(String codigoPedido, String numeroTarjeta, double importe) {
		this.codigoPedido = codigoPedido;
		this.numeroTarjeta= numeroTarjeta;
		this.importe= importe;
	}

	
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", numeroTarjeta="
				+ numeroTarjeta + ", importe=" + importe + "]";
	}

}
