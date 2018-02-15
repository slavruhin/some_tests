package geometric.share.base;

public interface Movable<T> {
	void bewegen(T x, T y);
	T getPositionX();
	T getPositionY();
	String Position();
}
