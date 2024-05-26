package event;

public interface GameEventHandler<T> {
	public void handle(T newvalue, T oldValue);
}
