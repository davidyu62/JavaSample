package org.example.sample;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class QueueManager {
	
	private Queue<Message> queue;
	private TreeMap<Integer,Message> failQueue;
	public Map<String,Message> tmpStoreMap;
	String queueName;
	int maxSize;
	int priority;
	
	public QueueManager(String queueName, int maxSize) {
		queue = new LinkedList<>();
		failQueue = new TreeMap<>();
		tmpStoreMap = new HashMap<>();
		this.queueName = queueName;
		this.maxSize = maxSize;
		priority = 1;
	}
	
	public boolean add(String message) {
		
		if(maxSize == queue.size()) {		// queue�� �� ã�� ���
			return false;
		}else {
			queue.add(new Message(message,"Message"+queue.size()+1,priority++));
			return true;
		}
	}
	
	public Message poll() {
		Message result = null;
		
		if(failQueue.size() > 0) {		// fail case
			int firstKey = failQueue.firstKey();
			result = failQueue.get(firstKey);
			if(result == null) {
				System.out.println("result is null");
			}
			failQueue.remove(firstKey);
			System.out.println(result.toString());
		}else {
			result = queue.poll();
			if(result != null) {
				tmpStoreMap.put(result.getId(), result);
			}
		}
		return (result==null) ? null : result;
	}
	
	public void addFailQueue(Message message) {
		failQueue.put(message.priority, message);
	}
	
	
	public void ackHandler(String messageId) {
		tmpStoreMap.get(messageId);
	}
}
