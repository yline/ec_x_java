package com.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution
{
    /**
     *  ()() // 1,2,3,4 【相减为奇数】
     * @param s
     * @return
     */
    public boolean isValid(String s)
    {
        List<DataBean> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            if (isPre(s.charAt(i)))
            {
                list.add(new DataBean(s.charAt(i), i));
            }
            else
            {
                DataBean bean = new DataBean(s.charAt(i), i);
                
                int removePosition = -1;
                for (int j = 0; j < list.size(); j++)
                {
                    if (list.get(j).equals(bean))
                    {
                        removePosition = j;
                        break;
                    }
                }
                
                if (-1 == removePosition)
                {
                    return false;
                }
                else
                {
                    list.remove(removePosition);
                }
            }
        }
        
        return list.isEmpty();
    }
    
    private boolean isPre(char c)
    {
        if (c == '(' || c == '[' || c == '{')
        {
            return true;
        }
        
        return false;
    }
    
    private class DataBean
    {
        private Character character;
        
        private int position;
        
        public DataBean(Character character, int position)
        {
            super();
            this.character = character;
            this.position = position;
        }
        
        public Character getCharacter()
        {
            return character;
        }
        
        public int getPosition()
        {
            return position;
        }
        
        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof DataBean)
            {
                DataBean temp = (DataBean)obj;
                
                if ('(' == character)
                {
                    if (')' == temp.getCharacter() && (temp.getPosition() - position) % 2 == 1)
                    {
                        return true;
                    }
                }
                else if ('[' == character)
                {
                    if (']' == temp.getCharacter() && (temp.getPosition() - position) % 2 == 1)
                    {
                        return true;
                    }
                }
                else if ('{' == character)
                {
                    if ('}' == temp.getCharacter() && (temp.getPosition() - position) % 2 == 1)
                    {
                        return true;
                    }
                }
                
                return false;
            }
            
            return false;
        }
    }
    
    /**
     * <pre>
     * 原题
     * Given a string containing just the characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[’ and ‘]’,
     * determine if the input string is valid.
     * The brackets must close in the correct order, “()” and “()[]{}” are all valid
     * but “(]” and “([)]” are not.
     *
     * 题目大意
     * 给定一个只包含(‘, ‘)’, ‘{‘, ‘}’, ‘[’ 和‘]’的字符串，验证它是否是有效的。
     * 括号必须配对，并且要以正确的顺序。
     *
     * 解题思路
     * 用一个栈来对输入的括号串进行处理，如果是左括号就入栈，如果是右括号就与栈顶元素看是否组成一对括号，
     * 组成就弹出，并且处理下一个输入的括号，如果不匹配就直接返回结果。
     * </pre>
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s)
    {
        Deque<Character> stack = new LinkedList<>();
        int index = 0;
        Character top;
        while (index < s.length())
        {
            Character c = s.charAt(index);
            switch (c)
            {
                case '(':
                case '[':
                case '{':
                    stack.addFirst(c);
                    break;
                case ')':
                    
                    if (stack.isEmpty())
                    {
                        return false;
                    }
                    
                    top = stack.getFirst();
                    if (top == '(')
                    {
                        stack.removeFirst();
                    }
                    else if (top == '[' || top == '{')
                    {
                        return false;
                    }
                    else
                    {
                        stack.addFirst(c);
                    }
                    break;
                case ']':
                    
                    if (stack.isEmpty())
                    {
                        return false;
                    }
                    
                    top = stack.getFirst();
                    if (top == '[')
                    {
                        stack.removeFirst();
                    }
                    else if (top == '(' || top == '{')
                    {
                        return false;
                    }
                    else
                    {
                        stack.addFirst(c);
                    }
                    break;
                case '}':
                    
                    if (stack.isEmpty())
                    {
                        return false;
                    }
                    
                    top = stack.getFirst();
                    if (top == '{')
                    {
                        stack.removeFirst();
                    }
                    else if (top == '[' || top == '(')
                    {
                        return false;
                    }
                    else
                    {
                        stack.addFirst(c);
                    }
                    break;
                default:
                    return false;
            }
            
            index++;
        }
        
        return stack.isEmpty();
    }
}
