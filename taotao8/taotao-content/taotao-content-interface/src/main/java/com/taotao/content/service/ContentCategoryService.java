package com.taotao.content.service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

	List<EasyUITreeNode> getContentCategoryList(long parentId);
	TaotaoResult addContentCategory(Long parentId, String name);
	TaotaoResult updateContentCategory(Long id, String name);
	TaotaoResult delContentCategory(Long id);
}
