package com.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;
import com.bean.page;

/**
 * 
 * ��ɾ�Ĳ���巽��
 * 
 * **/


/*public class doIJdbc implements IJdbc {
    ResultSet rst=null;
    @Override
	public boolean addst(Student st) {//����ѧ��������Ƭ�ģ�
    	String sql="insert into student(sname,sclazz,spicture) values(?,?,?)";
		int rows=packJdbc.update(sql, new Object[] {
			st.getSname(),
			st.getSclazz(),
			st.getSpicture()
		});
		if(rows>0) {
			return true;
		}
	
	return false;
	}
    
    @Override
	public boolean bfadd(Score sc) {*//**���ӳɼ�֮ǰ���ж�**//*
		String sql="select * from score where studentid=? and lessionid=?";
		rst=packJdbc.query(sql, new Object[] {
				sc.getStudentid(),
				sc.getLessionid()
		});
		try {
			if(rst.next()) {//����ܲ鵽����true
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;//���ܲ鵽����false
	}
	@Override
	public boolean add(Score sc) {//���ӳɼ�
		boolean flag=bfadd(sc);
		if(flag) {
			return false;
		}
			String sql="insert into score(score,studentid,lessionid) values(?,?,?)";
			int rows=packJdbc.update(sql, new Object[] {
				sc.getScore(),
				sc.getStudentid(),
				sc.getLessionid()
			});
			if(rows>0) {
				return true;
			}
		
		return false;
	}

	@Override
	public boolean update(Score sc) {//��
		String sql="update score set score=?,studentid=?,lessionid=? where scoid=?";
		int rows=packJdbc.update(sql, new Object[] {
				sc.getScore(),
				sc.getStudentid(),
				sc.getLessionid(),
				sc.getScoid()
		});
		if(rows>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String scoid) {//ɾ
		String sql="delete from score where scoid=?";
		int rows=packJdbc.update(sql, new Object[] {scoid});
		if(rows>0) {
			return true;
		}
		return false;
	}

	@Override
	public Score FindById(String scoid) {//����ͼ��һ�� ͨ��Id
		String sql="select * from scview where scoid=?";
		rst=packJdbc.query(sql, new Object[] {scoid});
		try {
			if(rst.next()) {
			Score sc=new Score(
					rst.getString(1),
					rst.getString(2),
					rst.getString(3),
					rst.getString(4),
					rst.getString(5),
					rst.getString(6),
					rst.getString(7),
					rst.getString(8)
					);
			return sc;
			};
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Score> findAll() {
		List<Score> lsc=new ArrayList<Score>();
		String sql="select * from scview";
		rst=packJdbc.query(sql, null);
		try {
			while(rst.next()) {
				Score sc=new Score(
				rst.getString(1),
				rst.getString(2),
				rst.getString(3),
				rst.getString(4),
				rst.getString(5),
				rst.getString(6),
				rst.getString(7),
				rst.getString(8)
				);
				lsc.add(sc);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*//**
		 * 
		 * ****************************����չʾҳ�������ظ�����
		 * 
		 * **//*
		
		String strname="";
		for (int i = 0; i < lsc.size(); i++) {
			String str="";
			int x=0;
			if(strname.indexOf(lsc.get(i).getSname())<0) {
			for (int j = (i+1); j < lsc.size(); j++) {
				if(lsc.get(i).getSname().equals(lsc.get(j).getSname())) {
					if(x==0) {
					str+=lsc.get(i).getLname()+","+lsc.get(j).getLname()+",";
					x++;
					}else {
						str+=lsc.get(j).getLname();
					}
					strname+=lsc.get(i).getSname();
				}
				}
			}
			System.out.println(str);	
		}
		
		*//*******************************************************//*
		return lsc;
	}

	@Override
	public List<Student> findStAll() {
		List<Student> lst=new ArrayList<Student>();
		String sql="select * from student";
		rst=packJdbc.query(sql, null);
		try {
			while(rst.next()) {
				Student stu=new Student(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4)
						);
				lst.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lst;
	}

	@Override
	public List<Lession> findLeAll() {
		List<Lession> lle=new ArrayList<Lession>();
		String sql="select * from lession";
		rst=packJdbc.query(sql, null);
		try {
			while(rst.next()) {
				Lession less=new Lession(
						rst.getString(1),
						rst.getString(2)
						);
				lle.add(less);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lle;
	}
//*********************************************************
	@Override
	public List<login> findLoAll() {//��ѯ�����û�
		List<login> lilo=new ArrayList<login>();//����һ����¼��ļ���
		String sql="select * from douser";
		rst=packJdbc.query(sql, null);
		try {
			while(rst.next()) {
				login lo=new login(
				rst.getString(1),
				rst.getString(2),
				rst.getString(3),
				rst.getString(4),
				rst.getString(5),
				rst.getString(6)
				);
				lilo.add(lo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lilo;
	}
	@Override
	
	public boolean doadd(login lo) {//�û�ע��
		List<login> li=findLoAll();
		if(li==null) {//��1���������ѯ���еķ��������صļ���Ϊ�գ���ֱ���������
			String sql="insert into douser(uname,upw,ques,ans) values(?,?,?,?)";
			int rows=packJdbc.update(sql, new Object[] {
					lo.getUname(),
					lo.getUpw(),
					lo.getQues(),
					lo.getAns()
			});
			if(rows>0) {
				return true;
			}
			
		}else {//��2�����粻Ϊ�գ���������ϵ��û���������Ҫ��ӵ��û������бȽϣ����һ��������False,��������ӡ���һ������ִ����ӵķ���
		for (login login : li) {//(�û��������ظ�)
				
				 * String una=login.getUname(); System.out.println(una);
				 
			if(lo.getUname().equals(login.getUname())) {
				return false;
			}
		}
			String sql="insert into douser(uname,upw,ques,ans) values(?,?,?,?)";
			int rows=packJdbc.update(sql, new Object[] {
					lo.getUname(),
					lo.getUpw(),
					lo.getQues(),
					lo.getAns()
			});
			if(rows>0) {
				return true;
			}
		}
		return false;
		
	}

	@Override
	public login findunup(login lo) {//�û���¼
		String sql="SELECT * FROM douser WHERE uname=? AND upw=?";
		rst=packJdbc.query(sql, new Object[] {lo.getUname(),lo.getUpw()});
		
			try {
				if(rst.next()) {
					login lou=new login(
							rst.getString(1),
							rst.getString(2),
							rst.getString(3),
							rst.getString(4),
							rst.getString(5),
							rst.getString(6)
							);
				return lou;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public login useupdate1(login lo) {//�޸�����1������ԭ�û��������룬���ƥ��ɹ������ظ�����¼��uid,
		String sql="SELECT * FROM douser WHERE uname=? AND upw=?";*//**Ҫ��***//*
		rst=packJdbc.query(sql, new Object[] {lo.getUname(),lo.getUpw()});
		
			try {
				if(rst.next()) {
					login lou=new login(
							rst.getString(1),
							rst.getString(2),
							rst.getString(3),
							rst.getString(4),
							rst.getString(5),
							rst.getString(6)
							);
				return lou;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public boolean useupdate2(login lo) {//�޸�����2������ID�޸�����
		String sql="UPDATE douser SET upw=? WHERE uid=?";
		int rows=packJdbc.update(sql, new Object[]{
				lo.getUpw(),
				lo.getUid()
				
		});
		if(rows>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Score> FindByNa(String sname) {//ͨ��ѧ����������һ������ ,��ѯ����ѧ���ɼ�
		
		List<Score> lsc2=new ArrayList<Score>();
		String sql="select * from scview where sname=?";
		rst=packJdbc.query(sql, new Object[]{sname});
		try {
			while(rst.next()){
				Score sc=new Score(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6),
						rst.getString(7),
						rst.getString(8)
						);
						lsc2.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsc2;
	}

	@Override
	public boolean updatejur(String uid) {//ͨ��Id��Ȩ��
		String sql="UPDATE douser SET jur=10 WHERE uid=?";
		int rows=packJdbc.update(sql, new Object[]{uid});
		if(rows>0){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean del2(String uid) {//����IDɾ�û�
		String sql="delete from douser where uid=?";
		int rows=packJdbc.update(sql, new Object[] {uid});
		if(rows>0) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Score> findPageList(int page, int rows) {//��ҳ���ɼ���ÿҳչʾ�ļ�¼�ļ���
		List<Score> lsfy=new ArrayList<Score>();
		          //SELECT * FROM vwstu ORDER BY stuid LIMIT "+(page-1)*rows+","+rows
		String sql="SELECT * FROM scview ORDER BY scoid LIMIT "+(page-1)*rows+","+rows;//��(page-1)*rows��+rows��ÿҳչʾ�ļ�¼�ӵ�(page-1)*rows����¼��ʼ�����չʾrows��
		System.out.println("page"+page);
		System.out.println("rows"+rows);
		rst=packJdbc.query(sql, null);
		try {
			while(rst.next()){
				Score sc=new Score(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6),
						rst.getString(7),
						rst.getString(8)
						);
				lsfy.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
				
				
		return lsfy;
	}

	@Override
	public int maxPage(int rows) {//��ҳ-�ɼ���������ҳ��
		int maxRows=0;//�ܼ�¼��
		int maxPage=0;//��ҳ��
		String sql="select count(*) from scview";
		rst=packJdbc.query(sql, null);
		try {
			if(rst.next()){
				maxRows=rst.getInt(1);
			}
			System.out.println("********************************maxRows:"+maxRows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(maxRows==0){
			maxPage=1;
		}else{
			maxPage=(maxRows%rows==0?maxRows/rows:maxRows/rows+1);
		}
		System.out.println("********************************maxPage3:"+maxPage);
		
		return maxPage;
	}

	@Override
	public login fogotpw1(login lo) {//��������1������ԭ�û��������ƥ��ɹ������ظ�����¼��id���ܱ�����
		System.out.println("dao=============="+lo.getUname());
		String sql="SELECT * FROM douser WHERE uname=?";
		rst=packJdbc.query(sql, new Object[] {lo.getUname()});
		
			try {
				if(rst.next()) {
					login lou=new login(
							rst.getString(1),
							rst.getString(2),
							rst.getString(3),
							rst.getString(4),
							rst.getString(5),
							rst.getString(6)
							);
				return lou;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public login fogotpw2(login lo) {//��������2�������ܱ��𰸣����ƥ��ɹ������ظ�����¼��id
		String sql="SELECT * FROM douser WHERE uid=? AND ans=?";
		System.out.println("====================dao:"+lo.getUid()+lo.getAns());
		rst=packJdbc.query(sql, new Object[] {lo.getUid(),lo.getAns()});
		
			try {
				if(rst.next()) {
					login lou=new login(
							rst.getString(1),
							rst.getString(2),
							rst.getString(3),
							rst.getString(4),
							rst.getString(5),
							rst.getString(6)
							);
				return lou;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public boolean fogotpw3(login lo) {//��������3������ID�޸�����
		String sql="UPDATE douser SET upw=? WHERE uid=?";
		int rows=packJdbc.update(sql, new Object[]{
				lo.getUpw(),
				lo.getUid()
				
		});
		if(rows>0){
			return true;
		}
		return false;
	}*/

	
/* } */
	
   
	

 
