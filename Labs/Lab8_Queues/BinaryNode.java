public class BinaryNode<T> {

		private T data;
		private BinaryNode<T> left = null;
		private BinaryNode<T> right = null;

		BinaryNode(T d) {
				data = d;
		}

		public String toString() {
			return data.toString();
		}

		/** setters and getters */
		public T data() { return data; }
		public void data(T d) { data = d; }

		public BinaryNode<T> right() { return right; }
		public void right(BinaryNode<T> n) { right = n; }
		public BinaryNode<T> left() { return left; }
		public void left(BinaryNode<T> n) { left = n; }
}
