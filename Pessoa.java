public class Pessoa 
{
    private String nome; 
    private String estado;

    public Pessoa(String nome)
    {
        this.nome = nome;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public String getNome()
    {
        return this.nome;
    }
    public String getEstado()
    {
        return this.estado;
    }
}
