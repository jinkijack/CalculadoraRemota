package br.edu.ifsuldeminas.mch.sd.rmi.client;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;
public class Client {
	public static void main(String[] args) {
		try {
			Operations calc = (Operations) Naming
					.lookup("rmi://localhost/CalculatorService");
			System.out.println(calc.sum(100, 5));
			System.out.println(calc.sub(1040, 5));
			System.out.println(calc.mul(10, 200));
			System.out.println(calc.div(10.5, 0.1));
			System.out.println("--------------------------------");
			System.out.println(calc.pow(10,2));
			System.out.println(calc.raiz(81,3));
			System.out.println(calc.modulo(10,3));
			System.out.println(calc.fatorial(4));
			System.out.println(calc.bin(91));
			System.out.println(calc.decimal(1011011));
			System.out.println(calc.hex(91));
			System.out.println(calc.porcentagem(1000,10));
			List<String> lastOperations =
					calc.lastOperations(2);
			for (String operation : lastOperations)
				System.out.printf("Operacao: %s\n", operation);
		} catch (MalformedURLException murle) {
			System.out.println("Erro na URL de acesso ao servic ̧o.");
		} catch (NotBoundException nbe) {
			System.out.println("Erro ao se ligar ao stub remoto. Nome de servic ̧o invalido.");
		}catch (ConnectException re) {
			System.out.println("Erro ao se conectar. Servidor n ̃ao iniciado.");
		}
		catch (RemoteException re) {
			System.out.println("Erro na chamada remota.");
			re.printStackTrace();
		}
	}
}