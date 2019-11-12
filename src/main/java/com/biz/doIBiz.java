package com.biz;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DAO.IJdbc;

import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;

@Service("doIBiz")
@Transactional
public class doIBiz implements IBiz{
	@Resource(name="IJdbc")//组件装配
	private IJdbc daojdbc;//关联注入
	
	 
	
	public IJdbc getDaojdbc() {
		return daojdbc;
	}


	public void setDaojdbc(IJdbc daojdbc) {
		this.daojdbc = daojdbc;
	}

	
	//获取具体增删改查方法对象
    
    
    @Override
	public boolean addst(Student st) {//增加学生（带照片的）
    	boolean flag=false;
    	if(daojdbc.addst(st)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean bfadd(Score sc) {//增加学生成绩前的查询
		boolean flag=false;
		List<Score> lsst=daojdbc.bfadd(sc);
		if(lsst!=null&&lsst.size()!=0) {
			flag=false;
		}else {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean add(Score sc) {//增加成绩
		boolean flag=false;
		if(daojdbc.add(sc)>0) {
			flag=true;
		}else {
			flag=false;
		}
		
		return flag;
	}

	@Override
	public boolean update(Score sc) {//改成绩
		boolean flag=false;
		if(daojdbc.update(sc)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean del(String scoid) {//删成绩
		boolean flag=false;
		
		if(daojdbc.del(scoid)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
		
	}

	@Override
	public Score FindById(String scoid) {//查单个成绩
		
		return daojdbc.FindById(scoid);
	}

	@Override
	public List<Score> FindAll() {//查所有成绩
		// TODO Auto-generated method stub
		return daojdbc.findAll();
	}

	@Override
	public List<Student> FindStAll() {//查所有学生
		// TODO Auto-generated method stub
		return daojdbc.findStAll();
	}

	@Override
	public List<Lession> FindLeAll() {//查所有课程
		// TODO Auto-generated method stub
		return daojdbc.findLeAll();
	}
//*************************************************************************
	@Override
	public List<login> findLoAll() {//查询所有用户
		
		return daojdbc.findLoAll();
	}
	@Override
	public boolean doadd(login lo) {//用户注册
		boolean flag=false;
		if(lo!=null) {
			List<login> llo=daojdbc.findLoAll();
			if(llo==null) {//如果用户列表为空，直接注册
				if(daojdbc.doadd(lo)>0) {
					flag=true;
				}else {
					flag=false;
				}
			}
			if(llo!=null) {//如果用户列表不为空，禁止账号重复
				for (login login : llo) {//(用户名不能重复)
				if(lo.getUname().equals(login.getUname())) {
					return false;
				}
			}
				if(daojdbc.doadd(lo)>0) {
					
					flag=true;
				}else {
					flag=false;
				}	
			}
			
		}
		return flag;
	}

	@Override
	public login findunup(login lo) {//用户登录
		login log=null;
		if(lo!=null) {
			log=daojdbc.findunup(lo);
		}
		return log;
	}

	@Override
	public login useupdate1(login lo) {//修改1
		login lou=null;
		if(lo!=null) {
			lou=daojdbc.useupdate1(lo);
		}
		return lou;
	}

	@Override
	public boolean useupdate2(login lo) {//修改2
		boolean flag=false;
		if(daojdbc.useupdate2(lo)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public List<Score> FindByNa(String sname) {
		// TODO Auto-generated method stub
		return daojdbc.FindByNa(sname);
	}

	@Override
	public boolean updatejur(String uid) {
		boolean flag=false;
		if(daojdbc.updatejur(uid)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean del2(String uid) {//根据ID  删用户
		boolean flag=false;
		if(daojdbc.del2(uid)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	@Override
	public List<Score> findPageList(int page, int rows) {//分页查询
		int page1=(page-1)*rows;
		return daojdbc.findPageList(page1, rows);
	}
	@Override
	public int maxPage(int rows) {//分页-最大页数
		int maxpage=0;
		int maxrows=daojdbc.maxPage(rows);
		if(maxrows==0) {
			maxpage=1;
		}else {
			maxpage=(maxrows%rows==0?maxrows/rows:maxrows/rows+1);
			
		}
		return maxrows;
	}
	@Override
	public login fogotpw1(login lo) {//忘记密码1
		System.out.println("biz===================:"+lo.getUname());
		
		return daojdbc.fogotpw1(lo);
	}
	@Override
	public login fogotpw2(login lo) {//忘记密码2
		System.out.println("biz==============fogotpw2:"+lo.getUid()+":"+lo.getAns());
		/*login lou=null;
		if(lo.getQues()!=null) {
			lou=doij.fogotpw2(lou);
		}*/
		return daojdbc.fogotpw2(lo);
	}
	@Override
	public boolean fogotpw3(login lo) {//忘记密码3
		boolean flag=false;
		if(daojdbc.fogotpw3(lo)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}



	

	

}
