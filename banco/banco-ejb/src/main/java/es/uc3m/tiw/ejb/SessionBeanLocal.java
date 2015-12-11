package es.uc3m.tiw.ejb;

import javax.ejb.Local;

@Local
public interface SessionBeanLocal {
	
	
	public abstract String pagoNormal(String numeroTarjeta, String codigoPedido, double importe);
	public abstract String conciliacionProfesor(int mes,int anyo,double importe,long idProfesor);
	public abstract String conciliacionEmpresa(int anyo,int mes,double importe);

}
