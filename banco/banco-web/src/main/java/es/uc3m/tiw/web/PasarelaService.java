package es.uc3m.tiw.web;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.ejb.SessionBean;


@Path("pasarela")
@Stateless
public class PasarelaService {

	@Context
	private UriInfo context;
	
	
	@EJB(name="pedidos")
	private SessionBean bean;
	
	public PasarelaService() {

	}

	/**
	 * Se pasan los datos por GET y los parametros se muestran en un XML La URL
	 * sera:
	 * http://localhost:8080/banco-web/resources/pasarela/pagoNormal/12.5/A34567891234567891/ORDER2015121009200020PM/xml
	 * http://localhost:8080/banco-web/resources/pasarela/pagoNormal/14/B6789123456723456712/ORDER2015121108200030AM/xml
	 * @param importe
	 * @param numeroTarjeta
	 * @param codigoPedido
	 * @return XML
	 */

	@GET
	@Path("pagoNormal/{importe}/{tarjeta}/{codigoPedido}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getPagoNormal(@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido,
			@PathParam("importe") double importe) {

		String retorno = "";

		retorno = bean.pagoNormal(numeroTarjeta, codigoPedido, importe);

		return retorno;

	}
	

	// CONCILIACION 
	@GET
	@Path("conciliacionProfesor/{anyo}/{mes}/{importe}/{idProfesor}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getConciliacionProfesor(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe,
			@PathParam("idProfesor") long idProfesor)
			 {

		
		String retorno = "";

		retorno = bean.conciliacionProfesor(anyo,mes, importe,idProfesor);

		return retorno;
		
	
	}

	@GET
	@Path("conciliacionEmpresa/{anyo}/{mes}/{importe}/{idEmpresa}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getConciliacionEmpresa(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe, @PathParam("idEmpresa") long idEmpresa) {
		String retorno = "";

		retorno = bean.conciliacionEmpresa(idEmpresa,anyo,mes, importe);

		return retorno;

}
}
