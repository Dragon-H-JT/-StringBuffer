package digit;

public interface IStingBuffer {
    public void append(String str); //追加字符串
    public void append(char c);     //追加字符
    public void insert(int pos,char b);     //指定位置插入字符
    public void insert(int pos,String b);      //指定位置插入字符串
    public void delete(int star);  //从开始位置删除剩下的
    public void delete(int star,int end);   //删除开始到结束-1(左闭右开)
    public void  reverse();     //反转
    public int length();     //返回长度
}
