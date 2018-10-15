package com.taotao.content.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ContentService {

	TaotaoResult addContent(TbContent content);
	TaotaoResult delContent(Long ids[]);
	List<TbContent> getContentByCid(long cid);
    EasyUIDataGridResult getContentListByCid(long cid, int page, int rows);
}
