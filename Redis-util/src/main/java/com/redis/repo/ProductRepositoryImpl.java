package com.redis.repo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Repository;

import com.redis.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static final String KEY = "Product";
	private final RedisTemplate<String, Product> redisTemplate;
	private HashOperations hashOps;
	private ZSetOperations zOps;
	private HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

	private BeanUtilsHashMapper beanUtilsMapper = new BeanUtilsHashMapper(Product.class);

	@Autowired
	private ProductRepositoryImpl(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOps = redisTemplate.opsForHash();
		zOps=redisTemplate.opsForZSet();
	}

	@Override
	public void saveProduct(Product product) {
		hashOps.put(KEY, product.getName(), product);
	}

	@Override
	public Product find(String name) {
		return (Product) redisTemplate.opsForHash().get(KEY, name);

	}

	@Override
	public List<Object> findAll() {

		Set<Object> hashKeys = hashOps.keys(KEY);

		return hashOps.multiGet(KEY, hashKeys);
	}

	@Override
	public Set<Object> findKeySet() {
		Set<Object> keyset = hashOps.keys(KEY);
		return keyset;
	}

	@Override
	public Map allEntries() {
		Map entrySet = hashOps.entries(KEY);
		return entrySet;
	}

	@Override
	public boolean hasKey(String hashKey) {
		boolean bool = hashOps.hasKey(KEY, hashKey);
		return bool;
	}

	@Override
	public long findSize() {
		long size = hashOps.size(KEY);
		return size;
	}

	@Override
	public List<Product> findValues() {
		List<Product> values = hashOps.values(KEY);
		return values;
	}

	@Override
	public void remove(String name) {
		hashOps.delete(KEY, name);

	}

	// @Override
	// public Map<byte[], byte[]> insert(Map<byte[], byte[]> mappedHash) {
	// hashOps.put(KEY,"justin",mappedHash);
	// return mappedHash;
	//
	// }

	@Override
	public Product findMapObject(String name) {
		Map<byte[], byte[]> loadedHash = (Map<byte[], byte[]>) hashOps.get(KEY, name);
		return (Product) mapper.fromHash(loadedHash);
	}

	@Override
	public void saveProduct1(Product product) {
		hashOps.put(KEY, product.getName(), mapper.toHash(product));
	}

	@Override
	public void clear() {
		redisTemplate.delete(KEY);
	}

	@Override
	public void sortedSet(Product product) {

		zOps.add(KEY, product, product.getQuantity());
	}

	@Override
	public Set<Product> zGet() {
		
		return zOps.rangeWithScores(KEY, 0, -1);
	}

	@Override
	public long zcard() {
		
		return zOps.zCard(KEY);
	}

	@Override
	public Set zget(int score) {
		
		return zOps.rangeByScore(KEY, score, score);
	}

	@Override
	public Set zrange(int min, int max) {
		
		return zOps.range(KEY,min, max);
	}

	@Override
	public Set zrangescore(int min, int max) {
		
		return zOps.rangeByScore(KEY, min, max);
	}
}
