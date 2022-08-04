/**
 *
 * @author Jv Loreti
 */

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Painel extends JPanel implements ActionListener{
    private CaixaEletronico ce;
    //Depósito
    private JLabel lblDeposito;
    private JButton btnDeposito;
    private JLabel lblDez;
    private JTextField txtDez;
    private JLabel lblCinquenta;
    private JTextField txtCinquenta;
    private JLabel lblCem;
    private JTextField txtCem;
    //Saque
    private JLabel lblSaque;
    private JTextField txtSaque;
    private JButton btnSaque;
    
    public Painel(){
        //Define as bordas do painel
        Border bordaExterna = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bordaInterna = BorderFactory.createTitledBorder("Depósito e saque");
        setBorder(BorderFactory.createCompoundBorder(bordaExterna, bordaInterna));
        
        //Define o layout
        super.setLayout(new BorderLayout());
        
        //Inicializa o caixa eletrônico
        ce = new CaixaEletronico();
        
        //Depósito
        lblDeposito = new JLabel("DEPÓSITO");
        lblDez = new JLabel("Qtd. de cédulas de R$ 10: ");
        txtDez = new JTextField(5);
        lblCinquenta = new JLabel("Qtd. de cédulas de R$ 50: ");
        txtCinquenta = new JTextField(5);
        lblCem = new JLabel("Qtd. de cédulas de R$ 100: ");
        txtCem = new JTextField(5);
        btnDeposito = new JButton ("Depositar");
        
        //Saque
        lblSaque = new JLabel("SAQUE (R$):");
        txtSaque = new JTextField(5);
        btnSaque = new JButton ("Sacar");
        
        //Atribui funcionalidade aos botões
        btnDeposito.addActionListener(this);
        btnSaque.addActionListener(this);
        
        //Define o layout p/ o posicionamento dos componentes no painel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //Posicionamentos iniciais
        gc.insets = new Insets (20, 0, 0, 0);
        gc.weightx = 0;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        
        //Posicionamento depósito
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lblDeposito, gc); //lblDeposito
        gc.insets = new Insets (10, 0, 0, 0);
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lblDez, gc); //lblDez
        gc.gridx = 1;
        add(txtDez, gc); //txtDez
        gc.gridx = 0;
        gc.gridy++;
        add(lblCinquenta, gc); //lblCinquenta
        gc.gridx = 1;
        add(txtCinquenta, gc); //txtCinquenta
        gc.gridx = 0;
        gc.gridy++;
        add(lblCem, gc); //lblCem
        gc.gridx = 1;
        add(txtCem, gc); //txtCem
        gc.insets = new Insets (10, 0, 130, 70);
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        add(btnDeposito, gc); //btnDeposito
        
        //Posicionamento saque
        gc.insets = new Insets (-140, -35, 0, 50);
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy++;
        add(lblSaque, gc); //lblSaque
        gc.insets = new Insets (-140, -80, 0, 50);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 1;
        add(txtSaque, gc); //txtSaque
        gc.insets = new Insets (-140, -35, 0, 0);
        gc.gridx = 2;
        add(btnSaque, gc); //btnSaque
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == btnDeposito){
            if(!txtDez.getText().isEmpty() && !txtCinquenta.getText().isEmpty() && !txtCem.getText().isEmpty()){
                int dez = Integer.parseInt(txtDez.getText());
                int cinquenta = Integer.parseInt(txtCinquenta.getText());
                int cem = Integer.parseInt(txtCem.getText());

                ce.depositar(dez, cinquenta, cem);
                
                txtDez.setText("");
                txtCinquenta.setText("");
                txtCem.setText("");
            }
        }else{
            if(event.getSource() == btnSaque){
                if(!txtSaque.getText().isEmpty()){
                    int saque = Integer.parseInt(txtSaque.getText());
                    
                    ce.sacar(saque);
                    
                    txtSaque.setText("");
                }
            }
        }
    }
}
             