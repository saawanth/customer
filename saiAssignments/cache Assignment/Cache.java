import java.util.Map;

public interface Cache<K,V>{
	public V get(K key);
	public Map<K,V> getAllAPresent(Iterable<?> keys);
	public void Invalidate(K key);
	public void InvalidateAll();
	public void InvalidateAll(Iterable<K> keys);
	public void put(K key,V value);
	public void putAll(Map<?extends K,?extends V>m);
	public long size();
	

}