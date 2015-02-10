package service;

import java.util.Set;
import javax.ws.rs.core.Application;


/**
 * ApplicationConfig.java -> Job:
 * @since 10/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */

@javax.ws.rs.ApplicationPath( "webresources" )
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses( resources );
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(
                                         Set<Class<?>> resources) {
        resources.add( service.UsuarioComumFacadeREST.class );
    }

}
