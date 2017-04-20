package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
 * Bean de suporte que funcionar� como Managed Bean para a p�gina JSF listarCompromissos.xhtml.
 */

@ManagedBean
@ViewScoped
public class ListarCompromissosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
    private CompromissoFacadeLocal compromissoFacadeLocal;
    private Compromisso compromisso;
    private List<Compromisso> compromissos = new ArrayList<>();
            
    //Classe de conjunto de flags de controle
    private Controladores flags;
    
    //Classe de exce��es
    private CompromissoException except;

    // Construtor da classe
    public ListarCompromissosBean() {
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
     * Faz a listagem dos registros
     *
     */
    public String listRegisters() {
    	
    	

        try {
            if (verificaOperacao("listRegisters")) {
            	compromissos.addAll(compromissoFacadeLocal.findAll());
            } else {
            	except = new CompromissoException("Erro ao tentar listar.");
            }
        } catch (Exception e) {
        	except = new CompromissoException("Erro ao tentar listar. ", e);
        }
        return null;
    }
    
    private boolean verificaOperacao(String operacao) {
        // Verifica se o usu�rio pode fazer a opera��o
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