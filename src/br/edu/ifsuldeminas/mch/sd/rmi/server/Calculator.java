package br.edu.ifsuldeminas.mch.sd.rmi.server;
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