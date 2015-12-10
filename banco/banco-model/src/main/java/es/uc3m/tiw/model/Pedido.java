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
	private String codigoOperacion;
	private String codigoVale;

	public Pedido() {
		super();
	}
	
	
	
	public Pedido(String codigoPedido, String numeroTarjeta, double importe,
			String codigoOperacion, String codigoVale) {
		super();
		this.codigoPedido = codigoPedido;
		this.numeroTarjeta = numeroTarjeta;
		this.importe = importe;
		this.codigoOperacion = codigoOperacion;
		this.codigoVale = codigoVale;
	}



	public Pedido(String codigoPedido, String numeroTarjeta, double importe,
			String codigoOperacion) {
		super();
		this.codigoPedido = codigoPedido;
		this.numeroTarjeta = numeroTarjeta;
		this.importe = importe;
		this.codigoOperacion = codigoOperacion;
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



	public String getCodigoOperacion() {
		return codigoOperacion;
	}



	public void setCodigoOperacion(String codigoOperacion) {
		this.codigoOperacion = codigoOperacion;
	}



	public String getCodigoVale() {
		return codigoVale;
	}



	public void setCodigoVale(String codigoVale) {
		this.codigoVale = codigoVale;
	}



	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", numeroTarjeta="
				+ numeroTarjeta + ", importe=" + importe + "]";
	}
	 
	

}
