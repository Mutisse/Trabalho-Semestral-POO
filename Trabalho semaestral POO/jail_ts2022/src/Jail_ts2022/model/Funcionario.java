package Jail_ts2022.model;

/**
 *
 * @author Mutisse
 */
public class Funcionario extends Pessoa {

    private String senha,id_registroFuncionario;
    private NivelDeAcesso nivelDeAcesso;
    private Provincias provincia;

    public Funcionario() {

    }

    public Funcionario(String senha, String id_registroFuncionario, NivelDeAcesso nivelDeAcesso, Provincias provincia, String codigo, String nome, String apelido, String genero, String numeroDeBI, String Nuit, String contacto, String datadeNascimento, String dataDeregistro, String dataSaidaRegistro, String email, String estado) {
        super(codigo, nome, apelido, genero, numeroDeBI, Nuit, contacto, datadeNascimento, dataDeregistro, dataSaidaRegistro, email, estado);
        this.senha = senha;
        this.id_registroFuncionario = id_registroFuncionario;
        this.nivelDeAcesso = nivelDeAcesso;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "senha=" + senha + ", id_registroFuncionario=" + id_registroFuncionario + ", categoria=" + nivelDeAcesso + ", provincia=" + provincia + '}';
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId_registroFuncionario() {
        return id_registroFuncionario;
    }

    public void setId_registroFuncionario(String id_registroFuncionario) {
        this.id_registroFuncionario = id_registroFuncionario;
    }

    public NivelDeAcesso getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(NivelDeAcesso nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

  

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }


}
