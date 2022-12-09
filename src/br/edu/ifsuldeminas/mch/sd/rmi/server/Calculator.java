package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {
	private List<String> lastOperations = new ArrayList<String>();
	public Number sum(Number x, Number y) {
		Number result = x.doubleValue() + y.doubleValue();
		log(x, "+", y, result);
		return result;
	}
	public Number sub(Number x, Number y) {
		Number result = x.doubleValue() - y.doubleValue();
		log(x, "-", y, result);
		return result;
	}
	public Number mul(Number x, Number y) {
		Number result = x.doubleValue() * y.doubleValue();
		log(x, "*", y, result);
		return result;
	}
	public Number div(Number x, Number y) {
		Number result = Double.NaN;
		if (y.doubleValue() != 0)
			result = x.doubleValue() / y.doubleValue();
		log(x, "/", y, result);
		return result;
	}

	public Number pow(Number x, Number y) throws RemoteException {
		Number result = Math.pow(x.doubleValue(), y.doubleValue());
		log(x, "^", y, result);
		return result;
	}

	public Number raiz(Number x, Number y) throws RemoteException {
		Number result = Math.pow(x.doubleValue(), 1/y.doubleValue());
		log(y, "√", x, result);
		return result;
	}
	public Number modulo(Number x, Number y) throws RemoteException{
		Number result = x.doubleValue() % y.doubleValue();
		log(x, "%", y, result);
		return result;
	}

	public Number fatorial(Number x) throws RemoteException {
		Number result = x.doubleValue();
		int cont = x.intValue();
		while(cont>1){
			result = result.doubleValue()*(cont-1);
			cont--;
			System.out.println(result);
		}
		return result;
	}
	public String bin(Number x) throws RemoteException{
		String result = Integer.toBinaryString(x.intValue());
		log(x, "binary",result);
		return result;
	}
	public String hex(Number x)throws RemoteException{
		String result = Integer.toHexString(x.intValue());
		log(x, "Hexadecimal",result);
		return result;
	}

	public Number porcentagem(Number x, Number y) throws RemoteException {
		Number result = x.doubleValue() * (y.doubleValue()/100);
		log(y, "% de", x, result);
		return result;
	}

	private void log(Number operatorOne, String operation, String result) {
		String formattedOperation = String.format("%s %s = %s",
				operatorOne.toString(), operation,
				result);
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}

	public Number decimal(Number x) throws RemoteException{
		Number result = Integer.parseInt(x.toString(),2);
		log(x, "Decimal", result.toString());
		return result;
	}

	public List<String> lastOperations(int howMany) {
		if (lastOperations.size() < howMany)
			return lastOperations();
		return new ArrayList<String>(lastOperations.subList(
				lastOperations.size() - howMany, lastOperations.size()));
	}
	public List<String> lastOperations() {
		return lastOperations;
	}
	private void log(Number operatorOne, String operation, Number operatorTwo,
			Number result) {

		String formattedOperation = String.format("%s %s %s = %s",
				operatorOne.toString(), operation, operatorTwo.toString(),
				result.toString());
		lastOperations.add(formattedOperation);
		System.out.printf("%s at %s\n", formattedOperation, new Date());
	}
}