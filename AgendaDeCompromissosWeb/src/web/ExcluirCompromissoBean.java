package web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Compromisso;
import negocios.CompromissoException;
import negocios.CompromissoFacadeLocal;
import negocios.Controladores;

/**
 *
 * @author Tanise Mello
 * Bean de suporte que funcionar� como Managed Bean para a p�gina JSF excluirCompromisso.xhtml.
 */

@ManagedBean
@ViewScoped
public class ExcluirCompromissoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
    private CompromissoFacadeLocal compromissoFacadeLocal;
    private Compromisso compromisso;
        
    //Classe de conjunto de flags de controle
    private Controladores flags;
    
    //Classe de exce��es
    private CompromissoException except;

    // Construtor da classe
    public ExcluirCompromissoBean() {
    }

    public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public Controladores getFlags() {
        if (flags == null) {
            flags = new Controladores();
        }
        return flags;
    }

    public void setFlags(Controladores flags) {
        this.flags = flags;
    }

    /**
     * Faz a remo��o dos registros
     *
     */
    public String delete() {
        // Se o processamento � de inser��o, n�o exclui.
        if (flags.isInsert()) {
            return null;
        }

        try {
            if (verificaOperacao("delete")) {
            	compromissoFacadeLocal.remove(compromisso);
                novaEntidade();
            } else {
            	except = new CompromissoException("Erro ao tentar deletar.");
            }
        } catch (Exception e) {
        	except = new CompromissoException("Erro ao tentar deletar. ", e);
        }
        return null;
    }
 
    private boolean verificaOperacao(String operacao) {
        return true;
    }
    
    /*
     * Cria nova entidade, zerando as flags de controle, indicando que a entidade n�o existe e que o formul�rio n�o � de pesquisa.
     */
    public String novaEntidade() {
        compromisso = new Compromisso();
        flags.setExist(false);
        flags.unsetSearch();
        return null;
    }
}