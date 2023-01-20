public class ProdutoFormRequest {
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "{" +
            " descricao='" + getDescricao() + "'" +
            ", nome='" + getNome() + "'" +
            ", preco='" + getPreco() + "'" +
            ", sku='" + getSku() + "'" +
            "}";
    }

}
