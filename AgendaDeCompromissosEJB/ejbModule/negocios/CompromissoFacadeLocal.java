package negocios;

import entidades.Compromisso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tanise Mello
 */

@Local
public interface CompromissoFacadeLocal {
	
	void create(Compromisso compromisso);

    void edit(Compromisso compromisso);

    void remove(Compromisso compromisso);

    Compromisso find(Object id);

    List<Compromisso> findAll();

    List<Compromisso> findRange(int[] range);

    int count();
}