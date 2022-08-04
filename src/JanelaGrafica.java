/**
 *
 * @author Jv Loreti
 */

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JanelaGrafica extends JFrame{
    private Painel painel;

    public JanelaGrafica(){
        criarComponentes();
        configurarJanelaGrafica(); 
    }
    
    private void criarComponentes(){
        painel = new Painel();
        super.add(painel);
    }
    
    private void configurarJanelaGrafica(){
        //Define o título da janela
        super.setTitle("Caixa eletrônico");
        //Define as dimensões
        super.setSize(400, 400);
        //Centraliza a janela ao iniciar
        setLocationRelativeTo(null);
        //Exibe a janela
        super.setVisible(true);
        //Encerra a operação ao fechar a janela
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
