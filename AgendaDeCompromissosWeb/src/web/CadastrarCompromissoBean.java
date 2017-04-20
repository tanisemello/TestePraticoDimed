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
 * Bean de suporte que funcionar� como Managed Bean para a p�gina JSF cadastrarCompromisso.xhtml.
 */

@ManagedBean
@ViewScoped
public class CadastrarCompromissoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
    private CompromissoFacadeLocal compromissoFacadeLocal;
    private Compromisso compromisso;
        
    //Classe de conjunto de flags de controle
    private Controladores flags;
    
    //Classe de exce��es
    private CompromissoException except;

    // Construtor da classe
    public CadastrarCompromissoBean() {
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
     * Faz a grava��o dos registros
     *
     */
    public String save() {
        try {
            if (flags.isInsert()) {
                if (verificaOperacao("insert")) {
                	compromissoFacadeLocal.create(compromisso);
                } else {
                	except = new CompromissoException("Erro ao tentar salvar.");
                    return null;
                }
            }
            return novaEntidade();
        } catch (Exception e) {
        	except = new CompromissoException("Erro ao tentar salvar. ", e);
            return null;
        }
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