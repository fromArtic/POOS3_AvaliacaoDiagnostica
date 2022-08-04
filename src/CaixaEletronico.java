/**
 *
 * @author Jv Loreti
 */

public class CaixaEletronico{
    private int notas10;
    private int notas50;
    private int notas100;
    private int saldoDisponivel;
    
    public CaixaEletronico(){
        notas10 = 0;
        notas50 = 0;
        notas100 = 0;
    }
    
    public void depositar(int dez, int cinquenta, int cem){
        notas10+= dez;
        notas50+= cinquenta;
        notas100+= cem;
        saldoDisponivel = 10*notas10 + 50*notas50 + 100*notas100;
        
        System.out.println("\nFUNDOS (R$ " + saldoDisponivel 
                + ")\nCédulas de R$ 10: " + notas10 + "\nCédulas de R$ 50: " + notas50 + "\nCédulas de R$ 100: " + notas100);
    }
    
    public void sacar(int saque){
        if(saque > saldoDisponivel){
            System.out.println("\nSeu saldo disponível é insuficiente para a efetuação do saque da quantia informada.");
        }else{
            int resto = saque, cemRestante = notas100, cinquentaRestante = notas50, dezRestante = notas10;
            int cemRetirado = 0, cinquentaRetirado = 0, dezRetirado = 0;
            while(resto >= 100 && cemRestante > 0){
                resto-= 100;
                cemRestante--;
                cemRetirado++;
            }
            while(resto >= 50 && cinquentaRestante > 0){
                resto-= 50;
                cinquentaRestante--;
                cinquentaRetirado++;
            }
            while(resto >= 10 && dezRestante > 0){
                resto-= 10;
                dezRestante--;
                dezRetirado++;
            }
            if(resto == 0){
                notas10 = dezRestante;
                notas50 = cinquentaRestante;
                notas100 = cemRestante;
                saldoDisponivel-= saque;
                System.out.println("\nSaque realizado (" + dezRetirado + " nota(s) de dez, " + cinquentaRetirado + " nota(s) de cinquenta e " 
                        + cemRetirado + " nota(s) de cem)." + "\nSALDO DISPONÍVEL: R$ " + saldoDisponivel);
            }else{
                System.out.println("\nDevido à indisponibilidade das cédulas correspondentes em sua conta corrente, não foi possível efetuar o "
                        + "saque da quantia informada.");
            }
        }
    }
}
