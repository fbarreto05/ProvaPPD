public class Escritor extends Pessoa implements Runnable
{
    private Livro livro;
    private int numeroDeEscrituras;
    private int numeroDeDescansos;
    public final static int MAX_DESCANSOS = 1000;

    public void escrever() throws InterruptedException
    {
        this.setEstado("Pegando o livro");
        this.livro.pegar(this);

        this.setEstado("Escrevendo");
        this.escrevendo();

        this.setEstado("Soltando o livro");
        this.livro.soltar(this);
    }

    private void escrevendo()
    {
        this.numeroDeEscrituras = this.numeroDeEscrituras + 1;
        try 
        {
            Thread.sleep(1);
        } 
        catch (InterruptedException e) 
        {

        }
    }

    public void descansar() throws InterruptedException
    {
        this.setEstado("Descansando");
        this.descansando();
    }

    private void descansando()
    {
        this.numeroDeDescansos = this.numeroDeDescansos + 1;
        try 
        {
            Thread.sleep(1);
        } 
        catch (InterruptedException e) 
        {

        }
    }

    @Override
    public void run() 
    {
        try 
        {
            while (this.numeroDeDescansos < MAX_DESCANSOS) 
            {
                this.descansar();
                this.escrever();
            }

            this.setEstado("Finalizado");
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }
    }
}