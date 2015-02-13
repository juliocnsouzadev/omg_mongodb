package br.com.juliocnsouza.mongojpaexemple.service;

import br.com.juliocnsouza.mongojpaexemple.model.Developer;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * DeveloperFacadeREST.java -> Job:
 * <p>
 * @since 13/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */
@Stateless
@Path( "developer" )
public class DeveloperFacadeREST extends AbstractFacade<Developer> {

    @PersistenceContext( unitName = "mongoPU" )
    private EntityManager em;

    public DeveloperFacadeREST() {
        super( Developer.class );
    }

    @GET
    @Path( "createMock" )
    @Produces( {
        "application/json" } )
    public String criar() {
        Developer dev = new Developer();
        dev.setDataNascimento( new Date( 1992 , 11 , 20 ) );
        dev.setNome( "Rafael" );
        dev.setSkills( new HashSet<>( Arrays.asList( "JS" , "AngularJS" , "NodeJS" ,
                                                     "Twitter Bootstrap" , "CSS3" , "Java" ) ) );
        super.create( dev );
        return "{resul:'ok'}";
    }

    @GET
    @Path( "findAll" )
    @Produces( {
        "application/json" } )
    public String encontrar() {

        List<Developer> devs = super.findAll();
        if ( devs != null ) {
            return getJsonDevs( devs );
        }

        return "{resul:'you loose'}";
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private String getJsonDevs( List<Developer> devs ) {
        class SimpleBinder {

            List<Developer> devs;

            public SimpleBinder( List<Developer> devs ) {
                this.devs = devs;
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson( new SimpleBinder( devs ) );
        return json;
    }

}
