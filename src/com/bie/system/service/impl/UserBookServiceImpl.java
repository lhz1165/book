package com.bie.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.UserBook;
import com.bie.system.service.UserBookService;
import com.bie.utils.BaseDao;

public class UserBookServiceImpl implements UserBookService{

	@Override
	public boolean insertUser(UserBook ub) {
		try{
			if(ub!=null && ub.getBookId()!=null && ub.getUserId() != null){
				//sql语句
				String sql="INSERT INTO user_book(userId,bookId,userBookStatus) VALUES(?,?,?)";
				List<Object> list=new ArrayList<Object>();
				//可以理解位将实体类中get到的信息放到数据库中，因为set设置的信息就是为了查到数据库中
				list.add(ub.getUserId());//将设置好的账号信息保存到集合中
				list.add(ub.getBookId());//将设置好的账号信息保存到集合中
				list.add(ub.getUserBookStatus());//将设置好的账号信息保存到集合中
				
				
				//将封装到集合list中的信息和sql语句传递到DbUtils封装好的 方法中
				//这里sql转化位String语句，list转化位数组类型
				int count=BaseDao.addAndUpdate(sql.toString(), list.toArray());
				//System.out.println(count);//测试返回值是0还是1
				if(count>0){
					return true;//成功返回true
				}else{
					return false;//失败返回false
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
