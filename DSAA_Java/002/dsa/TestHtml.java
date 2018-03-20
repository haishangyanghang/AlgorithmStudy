/*
 * HTML 文档标记匹配算法Java实现
 * 
 */
package dsa;

import java.util.StringTokenizer;
import dsa.Stack;
import dsa.Stack_Array;
import java.io.*;

//检查Html文档的括号匹配
public class TestHtml {
	//嵌套类，存放HTML标记
	public static class Tag{
		String name; //标记名
		boolean opening;//起始标记
		
		public Tag(){
			//默认构造方法
			name = "";
			opening = false;
		}
		
		//构造方法
		public Tag(String nm,boolean type){
			name = nm;
			opening = type;
		}
		
		//判断是否起始标记
		public boolean isOpening(){
			return opening;
		}
		
		//返回标记名称
		public String getName(){
			return name;
		}
	}//clss Tag is over
	
	//通过缩格显示匹配标记的层次
	private void indent(int level) {
		for(int k = 0; k < level ; k ++ )
			System.out.print("\t|");
	}
	
	//检查每个起始标记符是否对应一个结束标记
	public boolean isHTMLMatched(Tag[] tag){
		int level = 0;//标记的层次
		Stack S = new Stack_Array();//存放标记的栈
		for(int i=0; (i<tag.length) && (tag[i] != null);i++){
			//逐一检查各标记
			if(tag[i].isOpening()){
				S.push(tag[i].getName()); //若遇到起始标记，则将其压入栈
				indent(level ++ );
				System.out.println("\t" +tag[i].getName());
			}
			else{
				//否则，若当前标记为结束标记，则判断
				if(S.isEmpty())
					return false;//若栈空，则不匹配
				if(!((String)S.pop()).equals(tag[i].getName()))
					//若当前标记与弹出的标记不匹配，则报告不匹配
					return false;
				indent( -- level);
				System.out.println("\t" +tag[i].getName());
			}//else
		}//for
		
		//至此，扫描文档结束
		if(S.isEmpty())
			//若此时栈空，则匹配
			return true;
		else 
			return false;
	}//isHTMLMatched
	
	public final static int CAPACITY = 1000;//数组最大容量
	//HTML文档中依次提取标记，依次存入数组
	public Tag[] parseHTML(BufferedReader r) throws IOException{
		String line; //文档中的一行
        boolean inTag = false; //标记：当前是否扫描到标记
        Tag[] tag = new Tag[CAPACITY];//存放标记的数组
        int count = 0;
        while((line=r.readLine())!=null){
        	//依次读入文档的各行
        	
        	//标记的特征为尖括号,将Line按指定标记符拆分
        	StringTokenizer st = new StringTokenizer(line,"<> \t",true);
        	while(st.hasMoreElements()){
        		String token = (String)st.nextToken();
        		if(token.equals("<"))
        				//如果扫描到“<”,说明遇到了下一个标记
        				inTag = true;
        		else if(token.equals(">"))
        			//若果扫描到“>”，说明在标记之外
        			inTag = false;
        		else if(inTag){
        			//若正在扫描一个标记
        			if((token.length() == 0) || (token.charAt(0)!='/'))
        				tag[count ++] = new Tag(token,true);//若是气质标记，加入数组
        			else
        				//否则，加入结束标记
        				tag[count ++] = new Tag(token.substring(1),false);//加入结束标记，跳过'/'
        		}
        	}	
        }
        return tag;//返回标记数组
       
	}
	
	//测试main()方法
	public static void main(String[] args) throws IOException{
		BufferedReader strd = new BufferedReader(new InputStreamReader(System.in));//标准输入
		TestHtml tagChecker = new TestHtml();
		if(tagChecker.isHTMLMatched(tagChecker.parseHTML(strd)))
			System.out.println("读文件符合HTML的标记匹配");
		else {
			System.out.println("该文件不符合HTML的标记匹配");
		}
	}	
}
