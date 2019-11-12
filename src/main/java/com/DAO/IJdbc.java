package com.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;
import com.bean.page;
@Service("IJdbc")
public interface IJdbc {//������ɾ�Ĳ�ӿ�
 public int addst(Student st);//����ѧ��������Ƭ�ģ�	
 public List<Score> bfadd(Score sc);/**���ӳɼ�֮ǰ���ж�***/
 public int add(Score sc);//��
 public int update(Score sc);//��
 public int del(String scoid);//����ID  ɾ
 public Score FindById(String scoid);//����ID�飬����һ������
 public List<Score> findAll();//����ͼ���У�����һ������
 public List<Student> findStAll();//������ѧ��������
 public List<Lession> findLeAll();//�����пγ̱�����
 //*************************
 public int doadd(login lo);//�û�ע��
 public List<login> findLoAll();//��ѯ�����û�
 public login findunup(login lo);//�û���¼����
 public login useupdate1(login lo);//�޸�����1������ԭ�û��������룬���ƥ��ɹ������ظ�����¼��ID
 public int useupdate2(login lo);//�޸�����2������ID�޸�����
 public List<Score> FindByNa(String sname);//ͨ��ѧ����������һ������
 public int updatejur(String uid);//ͨ��ID��Ȩ��
 public int del2(String uid);//����ID  ɾ�û�
 public login fogotpw1(login lo);//��������1������ԭ�û��������ƥ��ɹ������ظ�����¼��id���ܱ�����
 public login fogotpw2(login lo);//��������2�������ܱ��𰸣����ƥ��ɹ������ظ�����¼��id
 public int fogotpw3(login lo);//��������3������ID�޸�����
 /**
  * ��ҳ
  * page:��ǰҳ
  * rows:ÿҳ��¼��
  * */
 //�ɼ�չʾҳ���ҳ
 public List<Score> findPageList(@Param("page") int page, @Param("rows") int rows);//��ҳ-�ɼ���ÿҳչʾ�ļ�¼����
 public int maxPage(int rows);//��ҳ-�ɼ�����ҳ��
 
 
 
 
 
 
 
}
