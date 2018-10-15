package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ItemCatService {

	List<EasyUITreeNode> getItemCatList(long parentId);

	TaotaoResult getItemCatById(long cid);
}
