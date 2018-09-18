package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.taotao.pojo.TbItemDescExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

import javax.sound.midi.Soundbank;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p>
 *
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(long itemId) {
        //缓存中没有查询数据库
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息,获取第page页，rows条内容，默认查询总数count
        PageHelper.startPage(page, rows);
        //执行查询,紧跟着的第一个select方法会被分页
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //取查询结果,用PageInfo对结果进行包装
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        //返回结果
        return result;
    }

    @Override
    public TaotaoResult addItem(TbItem item, String desc) {
        //生成商品id
        final long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        itemMapper.insert(item);
        //创建一个商品描述表对应的pojo
        TbItemDesc itemDesc = new TbItemDesc();
        //补全pojo的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        itemDesc.setCreated(new Date());
        //向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //返回结果
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult updateItem(TbItem item, String desc) {
        TbItemExample tbItemExample = new TbItemExample();
        itemMapper.updateByPrimaryKeySelective(item);
        System.out.println(desc);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult delItem(List<Long> itemIdList) {
        TbItemDescExample tbItemDescExample = new TbItemDescExample();
        TbItemDescExample.Criteria criteria = tbItemDescExample.createCriteria();
        criteria.andItemIdIn(itemIdList);
        System.out.println("删除itemDesc返回值=" + itemDescMapper.deleteByExample(tbItemDescExample));
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria2 = tbItemExample.createCriteria();
        criteria2.andIdIn(itemIdList);
        System.out.println("删除item返回值=" + itemMapper.deleteByExample(tbItemExample));
        return TaotaoResult.ok();
    }

    @Override
    public TbItemDesc getItemDescById(long itemId) {

        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        return itemDesc;
    }

}
