package com.test.object;

/**
 * 类名
 * @author YLine
 *
 * 2016年12月19日 上午1:14:36
 */
public class ClassName
{
    private int number;
    
    private String name;
    
    private DataBean bean;
    
    public ClassName()
    {
    }
    
    public ClassName(int number, String name, DataBean bean)
    {
        super();
        this.number = number;
        this.name = name;
        this.bean = bean;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public DataBean getBean()
    {
        return bean;
    }
    
    public void setBean(DataBean bean)
    {
        this.bean = bean;
    }
    
    @Override
    public String toString()
    {
        // return super.toString();
        return "ClassName [number=" + number + ", name=" + name + ", bean=" + bean + "]";
    }
    
    private class DataBean
    {
        private int id;
        
        private String age;
        
        public int getId()
        {
            return id;
        }
        
        public void setId(int id)
        {
            this.id = id;
        }
        
        public String getAge()
        {
            return age;
        }
        
        public void setAge(String age)
        {
            this.age = age;
        }
    }
}
