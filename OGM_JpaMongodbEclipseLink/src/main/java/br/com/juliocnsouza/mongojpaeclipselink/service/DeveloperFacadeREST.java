package br.com.juliocnsouza.mongojpaeclipselink.service;

import br.com.juliocnsouza.mongojpaeclipselink.model.CoffeeTast;
import br.com.juliocnsouza.mongojpaeclipselink.model.Developer;
import br.com.juliocnsouza.mongojpaeclipselink.model.Project;
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
        //dev.setId( "" + new Random().nextInt( 1000 ) );
        dev.setDataNascimento( new Date() );
        dev.setNome( "Rafael Bruno" );
        dev.setSkills( new HashSet<>( Arrays.asList( "Java" , "JS" , "AngularJS" ) ) );
        dev.setCoffeeTast( new CoffeeTast( "Cappuccino" , Boolean.TRUE ) );
        Project project = new Project( "project 1" );
        dev.setProject( project );
        dev.setProjects( new HashSet<>( Arrays.asList( project ) ) );
        String json = new Gson().toJson( dev );
        System.out.println( "Json: " + json );

        super.edit( dev );
        return "{resul:'ok'}";

    }

    @GET
    @Path( "findAll" )
    @Produces( {
        "application/json" } )
    public String encontrar() {
        try {
            List<Developer> devs = super.findAll();
            if ( devs != null ) {
                return getJsonDevs( devs );
            }
        }
        catch ( Exception e ) {
            return "{resul:'you loose: " + e.getMessage() + "'}";
        }

        return "{resul:'you loose'}";

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    private String getJsonDevs( List<Developer> devs ) {

        Gson gson = new Gson();
        String json = gson.toJson( new SimpleBinder( devs ) , SimpleBinder.class );
        return json;
    }

    class SimpleBinder {

        List<Developer> devs;

        public SimpleBinder( List<Developer> devs ) {
            this.devs = devs;
        }
    }

}
