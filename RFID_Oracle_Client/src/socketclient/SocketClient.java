package socketclient;

import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

import commobject.SendObject;



public class SocketClient {

	private String sql;
	public String result;                   //���insert/delete/update�����Ľ��
	private Vector<String> v_result;        //���select���Ľ��
	//private String host = "10.10.144.82";
	private String host = "localhost";
	private int port = 1848;
	public Socket socket;
	
    /*
	 * ���췽������sql���Ϊupdate��insert��delete��ʱ���ô˹��췽��
	 */
	public SocketClient(String sql) throws IOException {
		socket = new Socket(host, port);
		this.sql = updateSql(sql);
	}
	
	
	/*
	 * ���췽������sql���Ϊselect��ʱ���ô˹��췽����
	 * ����countSelectFields��ʾselect����в�ѯ�ֶεĸ���
	 * �� select name ��age from user where userid = 222;,���ʱcountSelectFieldsӦΪ2
	 */
	public SocketClient(String sql,int countSelectFields) throws IOException {
		socket = new Socket(host, port);
		this.sql = searchSql(sql,countSelectFields);
		
	}
	
	
	/*
	 * �޸�update����insert��䣬delete���
	 * ��sql���ǰ����ϱ�ʾ�������ڷ������˴���
	 * �޸�ԭ���ڿ�ͷ����"0/"��ʾ������β����"$"��ʾ��
	 * ���������ʽΪ����ͷ��ʾ��"0"+��������+������ʾ��"$"
	 * */
	public String updateSql(String sql){
		String sqlStart ="0/";
		String sqlEnd = "$";
		sql = sqlStart + sql + sqlEnd;
		
		return sql;
		
	}
	
	
	/*
	 * �޸�select���
	 * ��sql���ǰ����ϱ�ʾ�������ڷ������˴���
	 * �޸�ԭ���ڿ�ͷ����"1/"��ʾ����.ѡ������ֶθ���countSelectFields����β����"$"��ʾ��
	 * ���������ʽΪ����ͷ��ʾ��"1"+��������+ѡ������ֶθ���countSelectFields+������ʾ��"$"
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
			s.PacDeliver(socket, buf_sql); //��Ҫ���͵ı�������buf��socket���󣬷��͵����������
            System.out.println("�ͻ��˷��͵���ϢΪ��" + sql);		

			//������Ϣ
			byte[] a = s.PacRecv(socket);// �ͻ��˽��շ������˷��������ݰ�������a��
			setResult(new String(a));
            System.out.println("�ͻ��˽��յ�����ϢresultΪ��" + result);
            constructionVResult(getResult());
		}catch(Exception e){e.printStackTrace();}
	}

	
	/*
	 * ���õ���String ���͵Ľ�� ���ŵ�Vector���͵�V_RESULT��
	 * */
	public void constructionVResult(String result){
		 v_result = new Vector<String>();
		String resultArray[] = result.split("\\/");
		for(int i = 1 ; i<resultArray.length; i ++ ){
			v_result.add(i-1, resultArray[i]);
		}
	}
	
	
	/*
	 * result��getter����
	 * */
	public String getResult() {
		return result;
	}

	/*
	 * result��setter����
	 * */
	public void setResult(String result) {
		this.result = result;
	}
	
	/*
	 * v_result��getter����
	 * */
	public Vector<String> getV_result() {
		return v_result;
	}
	
	/*
	 * v_result��setter����
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
System.out.println("---�����"+c.getV_result());

	}

}
