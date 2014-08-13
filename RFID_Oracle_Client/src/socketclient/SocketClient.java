package socketclient;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import commobject.SendObject;



public class SocketClient {

	private String sql;
	public String result;                   //存放insert/delete/update等语句的结果
	private Vector<String> v_result;        //存放select语句的结果
	//private String host = "10.10.144.82";
	private String host = "localhost";
	private int port = 1848;
	public Socket socket;
	
    /*
	 * 构造方法，当sql语句为update，insert，delete型时采用此构造方法
	 */
	public SocketClient(String sql) throws IOException {
		socket = new Socket(host, port);
		this.sql = updateSql(sql);
	}
	
	
	/*
	 * 构造方法，当sql语句为select型时采用此构造方法，
	 * 其中countSelectFields表示select语句中查询字段的个数
	 * 如 select name ，age from user where userid = 222;,则此时countSelectFields应为2
	 */
	public SocketClient(String sql,int countSelectFields) throws IOException {
		socket = new Socket(host, port);
		this.sql = searchSql(sql,countSelectFields);
		
	}
	
	
	/*
	 * 修改update语句或，insert语句，delete语句
	 * 在sql语句前后加上标示符，便于服务器端处理
	 * 修改原则：在开头加上"0/"标示符，结尾加上"$"标示符
	 * 即：传输格式为：开头标示符"0"+传输内容+结束标示符"$"
	 * */
	public String updateSql(String sql){
		String sqlStart ="0/";
		String sqlEnd = "$";
		sql = sqlStart + sql + sqlEnd;
		
		return sql;
		
	}
	
	
	/*
	 * 修改select语句
	 * 在sql语句前后加上标示符，便于服务器端处理
	 * 修改原则：在开头加上"1/"标示符，.选择语句字段个数countSelectFields，结尾加上"$"标示符
	 * 即：传输格式为：开头标示符"1"+传输内容+选择语句字段个数countSelectFields+结束标示符"$"
	 * */
	public String searchSql(String sql,int countSelectFields){
		String sqlStart ="1/";
		String sqlEnd = "$";
		sql = sqlStart + sql + "/"+String.valueOf(countSelectFields)+ sqlEnd;
		return sql;
		
	}
	
	
	public void send() {
		try {
			byte[] buf_sql = sql.getBytes();
			SendObject s = new SendObject();
			s.PacDeliver(socket, buf_sql); //将要发送的比特数组buf经socket对象，发送到基础输出流
            System.out.println("客户端发送的信息为：" + sql);		

			//接收信息
			byte[] a = s.PacRecv(socket);// 客户端接收服务器端发来的数据包，放在a中
			setResult(new String(a));
            System.out.println("客户端接收到的信息result为：" + result);
            constructionVResult(getResult());
		}catch(Exception e){e.printStackTrace();}
	}

	
	/*
	 * 将得到的String 类型的结果 ，放到Vector类型的V_RESULT里
	 * */
	public void constructionVResult(String result){
		 v_result = new Vector<String>();
		String resultArray[] = result.split("\\/");
		for(int i = 1 ; i<resultArray.length; i ++ ){
			v_result.add(i-1, resultArray[i]);
		}
	}
	
	
	/*
	 * result的getter方法
	 * */
	public String getResult() {
		return result;
	}

	/*
	 * result的setter方法
	 * */
	public void setResult(String result) {
		this.result = result;
	}
	
	/*
	 * v_result的getter方法
	 * */
	public Vector<String> getV_result() {
		return v_result;
	}
	
	/*
	 * v_result的setter方法
	 * */
	public void setV_result(Vector<String> vResult) {
		v_result = vResult;
	}

	
	public static void main(String[] args) throws IOException, Exception {
		
		String sql = "insert into superusers(user_Id,user_name,pwd)values (11852,2,2)";
//		SocketClient c = new SocketClient(sql);
		//String sql = "select user_name,pwd from users where user_Id = '1221101'";
	//	String sql = "select user_Id from superusers";
		SocketClient c = new SocketClient(sql,1);
		c.send();
System.out.println("---结果："+c.getV_result());

	}

}
