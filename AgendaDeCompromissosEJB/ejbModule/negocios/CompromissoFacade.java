package negocios;

import entidades.Compromisso;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tanise Mello
 * Bean de Sessão Stateless e de acesso Local.
 */

@Stateless
@LocalBean
public class CompromissoFacade extends AbstractFacade<Compromisso> implements CompromissoFacadeLocal {
    @PersistenceContext(unitName = "Agenda-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompromissoFacade() {
        super(Compromisso.class);
    }
}