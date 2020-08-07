/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.lang.Integer.sum;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Empleado;

/**
 *
 * @author USUARIO
 */
@Stateless
@Path("modelo.empleado")
public class EmpleadoFacadeREST extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "empleadoPU")
    private EntityManager em;

    public EmpleadoFacadeREST() {
        super(Empleado.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Empleado entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Empleado entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Empleado find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Empleado> findAll() {
        return super.findAll();
    }

    @POST
    @Path("obtener")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Empleado> buscarEst() {
        return super.findAll();
    }

    @POST
    @Path("Hola")
    public List<Empleado> MENSAJE() {
        return super.findAll();
    }

    @GET
    @Path("holanombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String Holanombre(@QueryParam("nombre") String nombre) {
        return "Bienvenido" + nombre;
    }

    @GET
    @Path("suma")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String result(@QueryParam("a") int a, @QueryParam("b") int b) {
        int resultado = a + b;
        return "El resultado es" + resultado;

    }

    @POST
    @Path("multiplicacion")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String multiplicar(@FormParam("a") int a, @FormParam("b") int b) {
        int result = a * b;
        return "El resultado es" + result;

    }

    @GET
    @Path("mayor")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String mayor(@QueryParam("a") int a, @QueryParam("b") int b) {
        if (a > b) {
            return "El mayor es a";

        } else 
            return "El mayor es b";
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Empleado> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
