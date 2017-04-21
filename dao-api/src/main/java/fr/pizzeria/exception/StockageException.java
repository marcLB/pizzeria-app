package fr.pizzeria.exception;

public class StockageException extends RuntimeException {

	public StockageException(String string) {
		super(string);
	}

	public StockageException(Throwable cause) {
		super(cause);
	}
}
