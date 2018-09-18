package com.taotao.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public TaotaoResult addContent(TbContent content) {
		//补全pojo的属性
		content.setCreated( new Date());
		content.setUpdated(new Date());
		//插入到内容表
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContentByCid(long cid) {

		//缓存中没有命中，需要查询数据库
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		//返回结果
		return list;
	}

	@Override
	public EasyUIDataGridResult getContentListByCid(long cid, int page, int rows) {
		// 设置分页信息，获取地page页，rows条内容，默认查询总数count
		PageHelper.startPage(page,rows);
		// 执行查询，紧跟着的第一个select方法会被分页
		TbContentExample tbContentExample = new TbContentExample();
		TbContentExample.Criteria criteria = tbContentExample.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> tbContentList = contentMapper.selectByExampleWithBLOBs(tbContentExample);
		// 去查询结果，用PageInfo对结果进行包装
		PageInfo<TbContent> pageInfo = new PageInfo<>(tbContentList);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(tbContentList);
		result.setTotal(pageInfo.getTotal());
		// 返回结果
		return result;
	}
}
