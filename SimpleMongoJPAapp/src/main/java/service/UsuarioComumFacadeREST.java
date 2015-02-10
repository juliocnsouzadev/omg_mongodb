package service;

import br.com.juliocnsouza.mongo_jpa.UsuarioComum;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * UsuarioComumFacadeREST.java -> Job:
 * <p>
 * @since 10/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Stateless
@Path( "user" )
public class UsuarioComumFacadeREST extends AbstractFacade<UsuarioComum> {

    @PersistenceContext( unitName = "MongoDB_PU" )
    private EntityManager em;

    public UsuarioComumFacadeREST() {
        super( UsuarioComum.class );
    }

    @GET
    @Path( "create" )
    @Produces( "text/plain" )
    public String create() {
        UsuarioComum us = new UsuarioComum();
        us.setId( new Date().getTime() );
        us.setLogin( "arvere" );
        super.create( us );
        return "foi....";
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
