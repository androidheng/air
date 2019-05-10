package com.airmonitor.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.airmonitor.mapper.TbUserMapper;
import com.airmonitor.pojo.TbUser;
import com.airmonitor.pojo.TbUserExample;
import com.airmonitor.pojo.TbUserExample.Criteria;
import com.airmonitor.service.UserService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbUser> findAll() {
		return userMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbUser> page=   (Page<TbUser>) userMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbUser user) {
		userMapper.insert(user);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbUser user){
		userMapper.updateByPrimaryKeySelective(user);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbUser findOne(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbUser user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbUserExample example=new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(0);
		if(user!=null){			
			if(user.getUsername()!=null) {
				criteria.andUsernameLike("%"+user.getUsername()+"%");
			}	
		}
		Page<TbUser> page= (Page<TbUser>)userMapper.selectByExample(example);	
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public TbUser findUser(TbUser user) {
			TbUserExample example=new TbUserExample();
			Criteria criteria = example.createCriteria();
			
			if(user!=null){			
				if(user.getId()!=null) {
					criteria.andIdEqualTo(user.getId());
				}
				if(user.getUsername()!=null) {
					criteria.andUsernameEqualTo(user.getUsername());
				}
				if(user.getPassword()!=null) {
					criteria.andPasswordEqualTo(user.getPassword());
				}
				if(user.getType()!=null) {
					criteria.andTypeEqualTo(user.getType());
				}
				if(user.getCid()!=null){
					criteria.andCidEqualTo(user.getCid());
				}
			}
			
			List<TbUser> list = userMapper.selectByExample(example);
			if(list.size()>0)
				return list.get(0);
			return null;
		}
	
}
