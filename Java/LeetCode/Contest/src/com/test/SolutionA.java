package com.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class SolutionA
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String content = in.next();
        
        // 初始值
        HashMap<Character, Node> map = new HashMap<>();
        
        // 计算个数
        for (int i = 0; i < content.length(); i++) {
        	char ch = content.charAt(i);
        	
        	Node realNode = map.get(ch);
        	if (null != realNode) {
				realNode.up();
			}else {
				Node newNode = new Node(ch);
				newNode.up();
				map.put(ch, newNode);
			}
		}
        
        // 感觉可以优化呀
        Collection<Node> valueArray = map.values();
        Node[] sizeArray = new Node[valueArray.size()];
        valueArray.toArray(sizeArray);
        
        Arrays.sort(sizeArray, new Comparator<Node>() {
        	@Override
        	public int compare(Node o1, Node o2) {
        		if (null == o1 || null == o2) {
					return -1;
				}
        		
        		// 频率 降序 优先
        		if (o1.size != o2.size) {
					return o2.size - o1.size;
				}
        		return o1.value - o2.value;
        	}
		});
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < sizeArray.length; i++) {
			if (null != sizeArray[i]) {
				
				Node node = sizeArray[i];
				for (int j = 0; j < node.size; j++) {
					sBuilder.append(node.value);
				}
			}
		}
        
        System.out.println(sBuilder.toString());
    }
    
    private static class Node{
    	private char value;
    	private int size;
    	
    	private Node(char value){
    		this.value = value;
    		this.size = 0;
    	}
    	
    	public void up() {
    		size += 1;
    	}
    	
    	@Override
    	public boolean equals(Object obj) {
    		if (obj instanceof Node) {
				return ((Node) obj).value == value;
			}
    		return false;
    	}
    }
}
