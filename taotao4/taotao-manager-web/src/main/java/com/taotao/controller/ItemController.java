package com.taotao.controller;

import com.taotao.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品管理Controller
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/item/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDescById(@PathVariable Long itemId) {
		TbItemDesc tbItem = itemService.getItemDescById(itemId);
		return TaotaoResult.ok(tbItem);
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult addItem(TbItem item, String desc) {
		TaotaoResult result = itemService.addItem(item, desc);
		return result;
	}

	@RequestMapping(value="/rest/item/update", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateItem(TbItem item, String desc) {
		TaotaoResult result = itemService.updateItem(item, desc);
		System.out.println(desc);
		return result;
	}

	@RequestMapping(value="/rest/item/delete")
	@ResponseBody
	public TaotaoResult addItem(Long[] ids) {
		System.out.println("ids=="+ids);
		List<Long> idList = new ArrayList<>();
		for (Long id : ids) {
			System.out.println("id=="+id);
			idList.add(id);
		}
		TaotaoResult result = itemService.delItem(idList);
		return result;
	}
}
