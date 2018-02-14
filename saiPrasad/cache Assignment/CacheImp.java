import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CacheImp<K,V> implements Cache<K,V>{
		Map<K,V> map=new HashMap<K,V>();

		@Override
		public V get(K key) {
			
			return map.get((key));
		}

		@Override
		public Map<K, V> getAllAPresent(Iterable<?> keys) {
			
			Map.Entry<K,V> me=null;
			Set<Entry<K,V>> set =map.entrySet();
			Iterator<Entry<K,V>> it=set.iterator();
			while(it.hasNext()){
				me=(Entry<K,V>)it.next();
				map.get(me.getKey());
			}
			return map;
		}

		@Override
		public void Invalidate(K key) {
			map.remove(key);
			
			
		}

		@Override
		public void InvalidateAll() {
			map.clear();
			
		}

		@Override
		public void InvalidateAll(Iterable<K> keys) {
			Map.Entry<K,V> mentry=null;
			Set<K> set=map.keySet();
			Iterator<K> it=set.iterator();
			while(it.hasNext()){
				mentry=(Entry<K,V>)it.next();
				map.remove(mentry.getKey());
			}
			
		}

		@Override
		public void put(K key, V value) {
			map.put(key, value);
		}

		@Override
		public void putAll(Map<? extends K, ? extends V> m) {
			map.putAll(m);
			
		}

		@Override
		public long size() {
			int i=map.size();
			return i;
		}
		
	

	public static void main(String[] args) {
		Cache<Integer,String> cache = new CacheImp<Integer,String>();
		cache.put(1,"Anup");
		cache.put(2,"Arun");
		
		cache.put(3,"Ashish");
		cache.Invalidate(3);
		
		System.out.println(cache);
		
		

	}

}
