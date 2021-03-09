import java.util.Comparator;

public class Orderings {

	public static Comparator<Olympian> orderById = new Comparator<Olympian>() {
		@Override
		public int compare(Olympian o1, Olympian o2) {
			return o1.id() - o2.id();
		}
	};

	public static Comparator<Object> queryByCountry = new Comparator<Object>() {
		@Override
		public int compare(Object key, Object person) {
			if (!(key instanceof String) || (!(person instanceof Olympian))) {
				throw new IllegalArgumentException("Not instance of.");
			}
			Olympian olympian = (Olympian) person;
			String country = (String) key;
			return country.compareTo(olympian.country());
		}
	};
}
