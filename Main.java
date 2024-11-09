import java.util.ArrayList;
import java.util.List;

public class Main 
{    
    public static void main(String ... args)
    {
        final int NUMERO_DE_ESCRITORES = 1;
        final int NUMERO_DE_LEITORES = 1;

        final List<Escritor> escritores = new ArrayList<Escritor>();
        final List<Leitor> leitores = new ArrayList<Leitor>();

        for(int i = 0; i < NUMERO_DE_ESCRITORES; i++)
        {
            String nome = "E " + new Integer(i + 1).toString();
            Escritor escritor = new Escritor(nome);
            
            escritores.add(escritor);
            new Thread(escritor).start();
        }

        for(int i = 0; i < NUMERO_DE_LEITORES; i++)
        {
            String nome = "L " + new Integer(i + 1).toString();
            Leitor leitor = new Leitor(nome);

            leitores.add(leitor);
            new Thread(leitor).start();
        }

        boolean haThreadsRodando;

        do 
        {

            haThreadsRodando = false;

            System.out.println("ESCRITORES:\n");
            for (Escritor e: escritores) {

                String mensagem = e.getNome() + ": " + e.getEstado();
                mensagem += " | Descansos = " + e.getNumeroDescansos();
                mensagem += " | Escrituras: " + e.getNumeroEscrituras();

                System.out.println(mensagem);

                haThreadsRodando |= e.getEstado() != "Finalizado";
            }
            
            System.out.println("\nLEITORES:\n");
            for (Leitor l: leitores) {

                String mensagem = l.getNome() + ": " + l.getEstado();
                mensagem += " | Descansos = " + l.getNumeroDescansos();
                mensagem += " | Escrituras: " + l.getNumeroLeituras();

                System.out.println(mensagem);

                haThreadsRodando |= l.getEstado() != "Finalizado";
            }

            System.out.println("------------------------------------------------\n\n");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
        
            }

        } while(haThreadsRodando);
    }
}
