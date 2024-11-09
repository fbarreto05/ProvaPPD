public class Livro {
    private String nome;
    private Pessoa usuario;

    public Livro(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public synchronized void pegar(Pessoa pessoa) throws InterruptedException
    {
        while(!this.usuario.equals(pessoa) && this.usuario != null)
        {
            wait();
        }
        this.usuario = pessoa;
    }

    public synchronized void soltar(Pessoa pessoa) throws InterruptedException
    {
        if(this.usuario.equals(pessoa))
        {
            this.usuario = null;
        }
        notifyAll();
    }
}
