package negocios;

import java.io.Serializable;

/**
 *
 * @author Tanise Mello
 */

public class Controladores implements Serializable {

    // Indica que a entidade em quest�o j� existe.
    boolean exist;
    
    // Indica que a opera��o � de inser��o.
    boolean insert;
    
    // Indica que a opera��o � de altera��o.
    boolean update;
    
    // Indica que a opera��o � de pesquisa.
    boolean search;
    
    // Indica que a opera��o � a de leitura da chave.
    boolean key;
    
    // Indica que a opera��o � de manuten��o dos dados.
    boolean dados;
    
    // Indica que deve aparecer na tela o bot�o Menu.
    boolean botaoMenu;
    
    // Indica que deve aparecer na tela o bot�o Voltar.
    boolean botaoVoltar;
    
    // Indica que deve aparecer na tela o bot�o Pesquisar.
    boolean botaoPesquisar;
    
    // Indica que deve aparecer na tela o bot�o Salvar.
    boolean botaoSalvar;
    
    // Indica que deve aparecer na tela o bot�o Excluir.
    boolean botaoExcluir;

    public Controladores() {
    }

    ////////////////////////////////////////////
    /**
     * Utilizado para definir se uma entidade j� existe ou n�o.
     * Se exist for true, mostra a parte dos dados e desabilita a parte da chave.
     * Se exist for false, mostra apenas a parte da chave e reseta o insert e o update para false.
     *
     * @return Boolean
     */
    public boolean getExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;

        if (!this.exist) {
            this.insert = false;
            this.update = false;
        }
    }
    
    /**
     * Utilizado para definir se uma opera��o � de inser��o ou n�o.
     *
     * @return: Boolean
     */
    public boolean isInsert() {
        return insert;
    }

    /**
     * Se insert for true, ent�o a opera��o ser� de create.
     * Seta automaticamente o update para false e o exist para true.
     *
     * @param insert
     */
    public void setInsert(boolean insert) {
        if (insert) {
            this.update = false;
            this.exist = true;
        }

        this.insert = insert;
    }

    /**
     * Utilizado para definir se uma opera��o � de altera��o ou n�o.
     *
     * @return: Boolean
     */
    public boolean isUpdate() {
        return update;
    }

    /**
     * Se update for true, ent�o a opera��o final de merge.
     * Seta automaticamente o insert para false e o exist para true.
     *
     * @param update
     */
    public void setUpdate(boolean update) {
        if (update) {
            this.insert = false;
            this.exist = true;
        }

        this.update = update;
    }

    /**
     * Utilizado para definir se uma opera��o � de pesquisa ou n�o.
     *
     * @return Boolean
     */
    public boolean isSearch() {
        return search;
    }

    public void setSearch() {
        this.exist = false;
        this.update = false;
        this.insert = false;
        this.search = true;
    }

    /**
     * Reseta a operacao de pesquisa e volta o estado de exist, update e insert para falso.
     *
     * @return void
     */
    public void unsetSearch() {
        exist = false;
        update = false;
        insert = false;
        search = false;
    }

    /**
     * Retorna verdadeiro se a entidade n�o existir e se n�o for operacao de pesquisa
     * 
     * @return boolean
     */
    public boolean isKey() {
        if (!exist && !search) {
            return true;
        }
        return false;
    }

    /**
     * Retorna verdadeiro se a entidade existir
     *
     * @return boolean
     */
    public boolean isDados() {
        this.dados = exist;
        return dados;
    }

    /**
     * Retorna indica��o da renderiza��o do bot�o Menu.
     *
     * @return Sempre verdadeiro.
     */
    public boolean isBotaoMenu() {
        return true;
    }

    /**
     * Retorna indica��o da renderiza��o do bot�o Voltar.
     * Retorna verdadeiro se a entidade existir ou se for opera��o de pesquisa.
     *
     * @return boolean
     */
    public boolean isBotaoVoltar() {
        if (exist || search) {
            return true;
        }
        return false;
    }

//    /**
//     * Retorna indica��o da renderiza��o do bot�o Pesquisar
//     * Retorna verdadeiro se a entidade n�o existir e n�o for opera��o de pesquisa
//     *
//     * @return boolean
//     */
//    public boolean isBotaoPesquisar() {
//        if (!exist && !search) {
//            return true;
//        }
//        return false;
//    }

    /**
     * Retorna indica��o da renderiza��o do bot�o Salvar.
     * Retorna verdadeiro se a entidade existir e se n�o for opera��o de pesquisa.
     *
     * @return boolean
     */
    public boolean isBotaoSalvar() {
        if (exist && !search) {
            return true;
        }
        return false;
    }

    /**
     * Retorna indica��o da renderiza��o do bot�o Excluir.
     * Retorna verdadeiro se a entidade existir e se n�o for opera��o de pesquisa
     *
     * @return boolean
     */
    public boolean isBotaoExcluir() {
        if (update && !search) {
            return true;
        }
        return false;
    }
}