package negocios;

import java.io.Serializable;

/**
 *
 * @author Tanise Mello
 */

public class Controladores implements Serializable {

    // Indica que a entidade em questão já existe.
    boolean exist;
    
    // Indica que a operação é de inserção.
    boolean insert;
    
    // Indica que a operação é de alteração.
    boolean update;
    
    // Indica que a operação é de pesquisa.
    boolean search;
    
    // Indica que a operação é a de leitura da chave.
    boolean key;
    
    // Indica que a operação é de manutenção dos dados.
    boolean dados;
    
    // Indica que deve aparecer na tela o botão Menu.
    boolean botaoMenu;
    
    // Indica que deve aparecer na tela o botão Voltar.
    boolean botaoVoltar;
    
    // Indica que deve aparecer na tela o botão Pesquisar.
    boolean botaoPesquisar;
    
    // Indica que deve aparecer na tela o botão Salvar.
    boolean botaoSalvar;
    
    // Indica que deve aparecer na tela o botão Excluir.
    boolean botaoExcluir;

    public Controladores() {
    }

    ////////////////////////////////////////////
    /**
     * Utilizado para definir se uma entidade já existe ou não.
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
     * Utilizado para definir se uma operação é de inserção ou não.
     *
     * @return: Boolean
     */
    public boolean isInsert() {
        return insert;
    }

    /**
     * Se insert for true, então a operação será de create.
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
     * Utilizado para definir se uma operação é de alteração ou não.
     *
     * @return: Boolean
     */
    public boolean isUpdate() {
        return update;
    }

    /**
     * Se update for true, então a operação final de merge.
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
     * Utilizado para definir se uma operação é de pesquisa ou não.
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
     * Retorna verdadeiro se a entidade não existir e se não for operacao de pesquisa
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
     * Retorna indicação da renderização do botão Menu.
     *
     * @return Sempre verdadeiro.
     */
    public boolean isBotaoMenu() {
        return true;
    }

    /**
     * Retorna indicação da renderização do botão Voltar.
     * Retorna verdadeiro se a entidade existir ou se for operação de pesquisa.
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
//     * Retorna indicação da renderização do botão Pesquisar
//     * Retorna verdadeiro se a entidade não existir e não for operação de pesquisa
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
     * Retorna indicação da renderização do botão Salvar.
     * Retorna verdadeiro se a entidade existir e se não for operação de pesquisa.
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
     * Retorna indicação da renderização do botão Excluir.
     * Retorna verdadeiro se a entidade existir e se não for operação de pesquisa
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