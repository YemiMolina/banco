package es.uc3m.tiw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;


@Entity
public class ConciliacionEmpresa{

	@Id
	@GeneratedValue(strategy = AUTO)
	private long idEmpresa;
	private int anyo;
	private int mes;
	private double importe;
	
	
	public ConciliacionEmpresa() {
		// TODO Auto-generated constructor stub
	}


	public ConciliacionEmpresa(long idEmpresa,int anyo
			,int mes,double importe) {
		super();
		
		this.idEmpresa=idEmpresa;
		this.anyo = anyo;
		this.mes = mes;
		this.importe = importe;
	
	}

	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public Long getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	

}
