package entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*; /////////////////////
import javax.validation.constraints.*; /////////////////////

/**
 *
 * @author Tanise Mello
 * Classe de entidade persistente do banco de dados, da tabela Compromissos.
 */

@Entity
@Table(name = "COMPROMISSOS")
@NamedQueries({
    @NamedQuery(name = "Compromisso.findAll", query = "SELECT c FROM Compromisso c")
})
public class Compromisso implements Serializable {
	
	@Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
	
	@Basic(optional = false) /////////////////////
    @NotNull
    @Size(min = 1, max = 100, message="Nome do compromisso deve ter entre 1 e 100 caracteres.")
    @Column(name = "NOME")
    private String nome;
		 
    @Basic(optional = false)
    @NotNull
    @Future
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO")
    @Temporal(TemporalType.TIME)
    private Date horario;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100, message="Nome do local deve ter entre 1 e 100 caracteres.")
    @Column(name = "LOCAL")
    private String local;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    
    public Compromisso() {
	}

    public Compromisso(Integer codigo) {
		this.codigo = codigo;
	}
    
    public Compromisso(Integer codigo, String nome, Date data, Date horario, String local) {
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.local = local;
	}
    
    public Compromisso(Integer codigo, String nome, Date data, Date horario, String local, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.horario = horario;
		this.local = local;
		this.descricao = descricao;
	}
    
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Compromisso)) {
            return false;
        }
        Compromisso other = (Compromisso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Compromisso[ codigo = " + codigo + " ]";
    }
}