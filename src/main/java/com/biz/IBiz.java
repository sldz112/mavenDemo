package com.biz;

import java.util.List;

import com.bean.Lession;
import com.bean.Score;
import com.bean.Student;
import com.bean.login;
/**
 * 
 * ҵ���
 * 
 * 
 * */

public interface IBiz {
public boolean addst(Student st);//����ѧ��������Ƭ�ģ�
public boolean bfadd(Score sc);
public boolean add(Score sc);//��
public boolean update(Score sc);//��
public boolean del(String scoid);//ɾ
public Score FindById(String scoid);//����ͼһ��
public List<Score> FindAll();//����ͼ����
public List<Student> FindStAll();//��ѧ��������
public List<Lession> FindLeAll();//��γ̱�����
//*************************
public boolean doadd(login lo);//�û�ע��
public List<login> findLoAll();//��ѯ�����û�
public login findunup(login lo);//�û���¼����
public login useupdate1(login lo);//�޸�����1������ԭ�û��������룬���ƥ��ɹ������ظ�����¼��ID
public boolean useupdate2(login lo);//�޸�����2������ID�޸�����
public List<Score> FindByNa(String sname);//ͨ��ѧ����������һ������
public boolean updatejur(String uid);//ͨ��ID��Ȩ��
public boolean del2(String uid);//����IDɾ�û�
public login fogotpw1(login lo);//��������1������ԭ�û��������ƥ��ɹ������ظ�����¼��id���ܱ�����
public login fogotpw2(login lo);//��������2�������ܱ��𰸣����ƥ��ɹ������ظ�����¼��id
public boolean fogotpw3(login lo);//��������3������ID�޸�����
/**
 * ��ҳ
 * page:��ǰҳ
 * rows:ÿҳ��¼��
 * */
//�ɼ�չʾҳ���ҳ
public List<Score> findPageList(int page, int rows);//��ҳ-�ɼ���ÿҳչʾ�ļ�¼����
public int maxPage(int rows);//��ҳ-�ɼ�����ҳ��
}
