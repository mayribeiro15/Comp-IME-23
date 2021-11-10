package reservasaereas;

public class Passageiro {
    private int id;
    private int numeroFidelidade;
    private String categoriaFidelidade;
    private String nome;
    private String email;
    private String cpf;
    private String sexo;
    private String passaporte;
    private String dataNascimento;
    private int idVoo;
    
    public Passageiro() {}
    
    public Passageiro(int numeroFidelidade, String categoriaFidelidade, String nome, String email, String cpf, String sexo, String passaporte, String dataNascimento, int idVoo) {
    	this.numeroFidelidade = numeroFidelidade;
    	this.categoriaFidelidade = categoriaFidelidade;
    	this.nome = nome;
    	this.email = email;
    	this.cpf = cpf;
    	this.sexo = sexo;
    	this.passaporte = passaporte;
    	this.dataNascimento = dataNascimento;
    	this.idVoo = idVoo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public int getNumeroFidelidade() {
        return numeroFidelidade;
    }

    public void setNumeroFidelidade(int numeroFidelidade) {
        this.numeroFidelidade = numeroFidelidade;
    }

    public String getCategoriaFidelidade() {
        return categoriaFidelidade;
    }

    public void setCategoriaFidelidade(String categoriaFidelidade) {
        this.categoriaFidelidade = categoriaFidelidade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
    	this.cpf = cpf;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getPassaporte() {
        return passaporte;
    }
    
    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
    
    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
