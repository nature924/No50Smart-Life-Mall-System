package com.dao;

import com.entity.ShangpinTuihuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinTuihuoView;

/**
 * 商品退货 Dao 接口
 *
 * @author 
 */
public interface ShangpinTuihuoDao extends BaseMapper<ShangpinTuihuoEntity> {

   List<ShangpinTuihuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
