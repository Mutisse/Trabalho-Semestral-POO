package Jail_ts2022.model;

/**
 *
 * @author Mutisse
 */
public abstract class Pessoa {

    private String codigo, nome, apelido, genero, numeroDeBI, Nuit, contacto, datadeNascimento, dataDeregistro, dataSaidaRegistro, email, estado;

    public Pessoa() {
    }

    public Pessoa(String codigo, String nome, String apelido, String genero, String numeroDeBI, String Nuit, String contacto, String datadeNascimento, String dataDeregistro, String dataSaidaRegistro, String email, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.apelido = apelido;
        this.genero = genero;
        this.numeroDeBI = numeroDeBI;
        this.Nuit = Nuit;
        this.contacto = contacto;
        this.datadeNascimento = datadeNascimento;
        this.dataDeregistro = dataDeregistro;
        this.dataSaidaRegistro = dataSaidaRegistro;
        this.email = email;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codigo=" + codigo + ", nome=" + nome + ", apelido=" + apelido + ", genero=" + genero + ", numeroDeBI=" + numeroDeBI + ", Nuit=" + Nuit + ", contacto=" + contacto + ", datadeNascimento=" + datadeNascimento + ", dataDeregistro=" + dataDeregistro + ", dataSaidaRegistro=" + dataSaidaRegistro + ", email=" + email + ", estado=" + estado + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumeroDeBI() {
        return numeroDeBI;
    }

    public void setNumeroDeBI(String numeroDeBI) {
        this.numeroDeBI = numeroDeBI;
    }

    public String getNuit() {
        return Nuit;
    }

    public void setNuit(String Nuit) {
        this.Nuit = Nuit;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDatadeNascimento() {
        return datadeNascimento;
    }

    public void setDatadeNascimento(String datadeNascimento) {
        this.datadeNascimento = datadeNascimento;
    }

    public String getDataDeregistro() {
        return dataDeregistro;
    }

    public void setDataDeregistro(String dataDeregistro) {
        this.dataDeregistro = dataDeregistro;
    }

    public String getDataSaidaRegistro() {
        return dataSaidaRegistro;
    }

    public void setDataSaidaRegistro(String dataSaidaRegistro) {
        this.dataSaidaRegistro = dataSaidaRegistro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
