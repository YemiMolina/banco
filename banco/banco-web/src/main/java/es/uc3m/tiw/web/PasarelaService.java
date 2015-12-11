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
	 * http://localhost:8080/banco-web/resources/pasarela/pagoNormal/14/tarjeta/B6789123456723456712/ORDER2015121108200030AM/xml
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
	
	/**
	 * Se pasan los datos por GET y los parametros se muestran en un XML La URL
	 * sera:
	 * http://localhost:8080/banco-web/resources/pasarela/pagoNormal/12.5/A34567891234567891/ORDER2015121009200020PM/VALE/xml
	 * http://localhost:8080/banco-web/resources/pasarela/pagoNormal/14/tarjeta/B6789123456723456712/ORDER2015121108200030AM/VALE/xml
	 * @param importe
	 * @param numeroTarjeta
	 * @param codigoPedido
	 * @param codigoVale
	 * @return XML
	 */
	
	@GET
	@Path("pagoVale/{importe}/{tarjeta}/{codigoPedido}/{codigoVale}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getPagoVale(@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido,
			@PathParam("importe") double importe,
			@PathParam("codigoVale") String codigoVale) {

		String retorno = "";

		retorno = bean.pagoVale(numeroTarjeta, codigoPedido, importe,
				codigoVale);

		return retorno;

	}

	// CONCILIACION 
	@GET
	@Path("conciliacionProfesor/{anyo}/{mes}/{importe}/{idProfesor}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getConciliacionProfesor(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe,
			@PathParam("idProfesor") Long idProfesor)
			 {

		
		String retorno = "";

		retorno = bean.conciliacionProfesor(anyo,mes, importe,idProfesor);

		return retorno;
		
	
	}

	@GET
	@Path("conciliacionEmpresa/{anyo}/{mes}/{importe}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getConciliacionEmpresa(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe) {
		String retorno = "";

		retorno = bean.conciliacionEmpresa(anyo,mes, importe);

		return retorno;

}
}
