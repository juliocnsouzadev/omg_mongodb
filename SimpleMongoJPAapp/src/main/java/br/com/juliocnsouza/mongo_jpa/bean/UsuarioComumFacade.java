package br.com.juliocnsouza.mongo_jpa.bean;

import br.com.juliocnsouza.mongo_jpa.UsuarioComum;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * UsuarioComumFacade.java -> Job:
 * @since 10/02/2015
 * @version 1.0
 * @author Julio Cesar Nunes de Souza (julio.souza@mobilitasistemas.com.br)
 */

@Stateless
public class UsuarioComumFacade extends AbstractFacade<UsuarioComum> {
    @PersistenceContext( unitName = "MongoDB_PU" )
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioComumFacade() {
        super( UsuarioComum.class );
    }

}
