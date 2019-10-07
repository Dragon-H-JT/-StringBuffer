package digit;

import static java.lang.System.*;

public class MyStingBuffer implements IStingBuffer {
    int capacity = 16;  //数组容量
    int length = 0;      //一共用了多少个字符
    char[] value;   //存放字符数组
    //无参的构造方法,字符数组
    public MyStingBuffer(){
        value = new char[capacity];
    }
    //带参的构造方法
    public MyStingBuffer(String str){
        this();
        if(null==str)
            return;
        if(capacity < str.length()){
            capacity  = value.length*2;
            value = new char[capacity];
        }
        if(capacity>=str.length()) {
           System.arraycopy(str.toCharArray(),0,value,0,str.length());
        }
        length = str.length();
    }

    public void append(String str){
        insert(length,str);
    }

    public void append(char c) {
        insert(length,String.valueOf(c));
    }

    public void delete(int star) {
        delete(star,length);
    }

    public void delete(int star, int end) {
        if(star < 0)
            return ;
        if(star > length)
            return ;
        if(end< 0)
            return ;
        if(end > length)
            return ;
        if(star >= end)
            return ;
        arraycopy(value,end,value,star,length-end);
        length = length-(end-star);
    }

    public void insert(int pos, char b) {
        insert(pos,String.valueOf(b));
    }

    public void insert(int pos, String b) {
        //边界判断
        if (pos < 0)
            return;
        if (pos > length)
            return;
        if(null == b)
            return ;
        //扩容
        while (length+b.length()>capacity){
            capacity = (int)((length+b.length())*1.5f);
            char[] newValue = new char[capacity];
            arraycopy(value,0,newValue,0,length); //复制
            value = newValue;   //引用指向
        }
        char[] cs = b.toCharArray();
        //将已存的数据往后移动
        arraycopy(value,pos,value,pos+cs.length,length-pos);
        //将插入的数据插入到指定位置
        arraycopy(cs,0,value,pos,cs.length);

        length = length+cs.length;
    }
    public void reverse() {
        for(int i = 0; i < length/2; i++){
            char temp = value[i];
            value[i] = value[length-i-1];
            value[length-i-1] = temp;
        }
    }
    public String toString(){
        char[] relvalue = new char[length];
        arraycopy(value,0,relvalue,0,length);
        return new String(relvalue);
    }
    public int length() {
        return length;
    }

    public static void main(String[] args){
        MyStingBuffer sb = new MyStingBuffer("the big");
        out.println(sb);
        sb.delete(0,2);
        out.println(sb);
        sb.insert(5,"hjt");
        out.println(sb);
    }

}
