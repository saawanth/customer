package com.connectionpool.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool implements Runnable {

	Queue<Connection> ll = new LinkedList<>();

	public ConnectionPool() {
		initializeConnectionPool();
	}

	private synchronized boolean checkIfConnectionPoolIsFull() {
		final int MAX_POOL_SIZE = Connections.getInstance().MAX_CONNECTIONS;
		if (ll.size() < MAX_POOL_SIZE) {
			return false;
		}
		return true;
	}

	private void initializeConnectionPool() {
		while (!checkIfConnectionPoolIsFull()) {
			synchronized (ll) {
				ll.add(createNewConnectionForPool());
			}
		}
	}

	private Connection createNewConnectionForPool() {
		Connections config = Connections.getInstance();
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(config.url, config.name, config.password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Connection getConnectionFromPool() {
		Connection con = null;

		synchronized (ll) {
			if (!(ll.isEmpty())) {
				con = ll.poll();
			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return con;
		}
	}

	public void releaseConnection(Connection con) {
		synchronized (ll) {
			if (con != null) {
				ll.add(con);
			}
		}
	}

	public void run() {
		Connection con = getConnectionFromPool();
		while (ll.isEmpty()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			con = getConnectionFromPool();
		}
		long time = System.currentTimeMillis() + 100;
		while (System.currentTimeMillis() < time) {
			System.out.println(Thread.currentThread().getName() + " is now open, please use it");
		}
		releaseConnection(con);
	}
}
