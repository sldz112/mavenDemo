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
	@Resource(name="IJdbc")//���װ��
	private IJdbc daojdbc;//����ע��
	
	 
	
	public IJdbc getDaojdbc() {
		return daojdbc;
	}


	public void setDaojdbc(IJdbc daojdbc) {
		this.daojdbc = daojdbc;
	}

	
	//��ȡ������ɾ�Ĳ鷽������
    
    
    @Override
	public boolean addst(Student st) {//����ѧ��������Ƭ�ģ�
    	boolean flag=false;
    	if(daojdbc.addst(st)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean bfadd(Score sc) {//����ѧ���ɼ�ǰ�Ĳ�ѯ
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
	public boolean add(Score sc) {//���ӳɼ�
		boolean flag=false;
		if(daojdbc.add(sc)>0) {
			flag=true;
		}else {
			flag=false;
		}
		
		return flag;
	}

	@Override
	public boolean update(Score sc) {//�ĳɼ�
		boolean flag=false;
		if(daojdbc.update(sc)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}

	@Override
	public boolean del(String scoid) {//ɾ�ɼ�
		boolean flag=false;
		
		if(daojdbc.del(scoid)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
		
	}

	@Override
	public Score FindById(String scoid) {//�鵥���ɼ�
		
		return daojdbc.FindById(scoid);
	}

	@Override
	public List<Score> FindAll() {//�����гɼ�
		// TODO Auto-generated method stub
		return daojdbc.findAll();
	}

	@Override
	public List<Student> FindStAll() {//������ѧ��
		// TODO Auto-generated method stub
		return daojdbc.findStAll();
	}

	@Override
	public List<Lession> FindLeAll() {//�����пγ�
		// TODO Auto-generated method stub
		return daojdbc.findLeAll();
	}
//*************************************************************************
	@Override
	public List<login> findLoAll() {//��ѯ�����û�
		
		return daojdbc.findLoAll();
	}
	@Override
	public boolean doadd(login lo) {//�û�ע��
		boolean flag=false;
		if(lo!=null) {
			List<login> llo=daojdbc.findLoAll();
			if(llo==null) {//����û��б�Ϊ�գ�ֱ��ע��
				if(daojdbc.doadd(lo)>0) {
					flag=true;
				}else {
					flag=false;
				}
			}
			if(llo!=null) {//����û��б�Ϊ�գ���ֹ�˺��ظ�
				for (login login : llo) {//(�û��������ظ�)
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
	public login findunup(login lo) {//�û���¼
		login log=null;
		if(lo!=null) {
			log=daojdbc.findunup(lo);
		}
		return log;
	}

	@Override
	public login useupdate1(login lo) {//�޸�1
		login lou=null;
		if(lo!=null) {
			lou=daojdbc.useupdate1(lo);
		}
		return lou;
	}

	@Override
	public boolean useupdate2(login lo) {//�޸�2
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
	public boolean del2(String uid) {//����ID  ɾ�û�
		boolean flag=false;
		if(daojdbc.del2(uid)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	@Override
	public List<Score> findPageList(int page, int rows) {//��ҳ��ѯ
		int page1=(page-1)*rows;
		return daojdbc.findPageList(page1, rows);
	}
	@Override
	public int maxPage(int rows) {//��ҳ-���ҳ��
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
	public login fogotpw1(login lo) {//��������1
		System.out.println("biz===================:"+lo.getUname());
		
		return daojdbc.fogotpw1(lo);
	}
	@Override
	public login fogotpw2(login lo) {//��������2
		System.out.println("biz==============fogotpw2:"+lo.getUid()+":"+lo.getAns());
		/*login lou=null;
		if(lo.getQues()!=null) {
			lou=doij.fogotpw2(lou);
		}*/
		return daojdbc.fogotpw2(lo);
	}
	@Override
	public boolean fogotpw3(login lo) {//��������3
		boolean flag=false;
		if(daojdbc.fogotpw3(lo)>0){
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}



	

	

}
