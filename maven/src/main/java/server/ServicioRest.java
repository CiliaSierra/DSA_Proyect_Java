package server;

import API.MundoImpl;
import banco.BancoImpl;
import jugador.Objeto;
import jugador.Usuario;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static API.Singleton.getInstance;


@Path("/funciones")
@Singleton //Lo necesitamos para decirle a jerser que use una unica instancia

public class ServicioRest {

    MundoImpl mundoImpl = API.Singleton.getInstance().getMundoImpl();

    //Testing purposes "/Hello"
    @GET
    @Path("/Hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //FUNCIONES de MundoInterfaz
    @POST
    @Path("/userLogin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario login(Usuario u) {
        Usuario us = mundoImpl.login(u);
        return us;
    }

    @POST
    @Path("/crearUsuario")
    public Boolean crearUsuario(Usuario u) {
        return mundoImpl.crearUsuario(u);
    }

    @POST
    @Path("/eliminarUsuario")
    public Boolean eliminarUsuario(String nombre) {
        return mundoImpl.eliminarUsuario(nombre);
    }

    @GET
    @Path("/consultarUsuario")
    public Usuario consultarUsuario(String nombre) {
        return mundoImpl.consultarUsuario(nombre);
    }

    @GET
    @Path("/listaUsuarios")
    @Produces(MediaType.TEXT_PLAIN)
    public List<Usuario> listaUsuarios () {
        return mundoImpl.listaUsuarios();
    }

    @POST
    @Path("/añadirObjetoAUsuario")
    public int añadirObjetoAUsuario(Usuario u, Objeto o, int cantidad) {
        return mundoImpl.añadirObjetoAUsuario(u, o, cantidad);
    }

    @POST
    @Path("/eliminarObjetoDeUsuario")
    public int eliminarObjetoDeUsuario(Usuario u, String nombreObjeto, int cantidad) {
        return mundoImpl.eliminarObjetoDeUsuario(u, nombreObjeto, cantidad);
    }

    @GET
    @Path("/objFromNombre")
    @Produces(MediaType.TEXT_PLAIN)
    public Objeto objFromNombre(Usuario u, String nombreObjeto) {
        return mundoImpl.objFromNombre(u, nombreObjeto);
    }

    //FUNCIONES  de BancoInterfaz
    @POST
    @Path("/{id}/guardarMonedas")
    public Boolean guardarMonedas(@PathParam("id") int monedas, String titular) {
        return getInstance().guardarMonedas(monedas, titular);
    }



}

