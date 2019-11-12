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
 * 增删改查具体方法
 * 
 * **/


/*public class doIJdbc implements IJdbc {
    ResultSet rst=null;
    @Override
	public boolean addst(Student st) {//增加学生（带照片的）
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
	public boolean bfadd(Score sc) {*//**增加成绩之前的判定**//*
		String sql="select * from score where studentid=? and lessionid=?";
		rst=packJdbc.query(sql, new Object[] {
				sc.getStudentid(),
				sc.getLessionid()
		});
		try {
			if(rst.next()) {//如果能查到返回true
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;//不能查到返回false
	}
	@Override
	public boolean add(Score sc) {//增加成绩
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
	public boolean update(Score sc) {//改
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
	public boolean del(String scoid) {//删
		String sql="delete from score where scoid=?";
		int rows=packJdbc.update(sql, new Object[] {scoid});
		if(rows>0) {
			return true;
		}
		return false;
	}

	@Override
	public Score FindById(String scoid) {//查视图中一个 通过Id
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
		 * ****************************处理展示页面姓名重复问题
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
	public List<login> findLoAll() {//查询所有用户
		List<login> lilo=new ArrayList<login>();//定义一个登录类的集合
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
	
	public boolean doadd(login lo) {//用户注册
		List<login> li=findLoAll();
		if(li==null) {//（1）、如果查询所有的方法，返回的集合为空，则直接添加数据
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
			
		}else {//（2）、如不为空，则遍历集合的用户名与现在要添加的用户名进行比较，如果一样，返回False,不允许添加。不一样，则执行添加的方法
		for (login login : li) {//(用户名不能重复)
				
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
	public login findunup(login lo) {//用户登录
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
	public login useupdate1(login lo) {//修改密码1，输入原用户名，密码，如果匹配成功，返回该条记录的uid,
		String sql="SELECT * FROM douser WHERE uname=? AND upw=?";*//**要改***//*
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
	public boolean useupdate2(login lo) {//修改密码2，根据ID修改密码
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
	public List<Score> FindByNa(String sname) {//通过学生姓名查找一个集合 ,查询单个学生成绩
		
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
	public boolean updatejur(String uid) {//通过Id改权限
		String sql="UPDATE douser SET jur=10 WHERE uid=?";
		int rows=packJdbc.update(sql, new Object[]{uid});
		if(rows>0){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean del2(String uid) {//根据ID删用户
		String sql="delete from douser where uid=?";
		int rows=packJdbc.update(sql, new Object[] {uid});
		if(rows>0) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Score> findPageList(int page, int rows) {//分页—成绩：每页展示的记录的集合
		List<Score> lsfy=new ArrayList<Score>();
		          //SELECT * FROM vwstu ORDER BY stuid LIMIT "+(page-1)*rows+","+rows
		String sql="SELECT * FROM scview ORDER BY scoid LIMIT "+(page-1)*rows+","+rows;//【(page-1)*rows，+rows】每页展示的记录从第(page-1)*rows条记录开始，最多展示rows条
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
	public int maxPage(int rows) {//分页-成绩：返回总页数
		int maxRows=0;//总记录数
		int maxPage=0;//总页数
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
	public login fogotpw1(login lo) {//忘记密码1，输入原用户名，如果匹配成功，返回该条记录的id和密保问题
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
	public login fogotpw2(login lo) {//忘记密码2，输入密保答案，如果匹配成功，返回该条记录的id
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
	public boolean fogotpw3(login lo) {//忘记密码3，根据ID修改密码
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
	
   
	

 
