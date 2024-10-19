package com.entity.view;

import com.entity.ShangpinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangpin_liuyan")
public class ShangpinLiuyanView extends ShangpinLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shangpin
			/**
			* 商品名称
			*/
			private String shangpinName;
			/**
			* 商品编号
			*/
			private String shangpinUuidNumber;
			/**
			* 商品照片
			*/
			private String shangpinPhoto;
			/**
			* 商品类型
			*/
			private Integer shangpinTypes;
				/**
				* 商品类型的值
				*/
				private String shangpinValue;
			/**
			* 商品库存
			*/
			private Integer shangpinKucunNumber;
			/**
			* 购买获得积分
			*/
			private Integer shangpinPrice;
			/**
			* 商品原价
			*/
			private Double shangpinOldMoney;
			/**
			* 现价
			*/
			private Double shangpinNewMoney;
			/**
			* 点击次数
			*/
			private Integer shangpinClicknum;
			/**
			* 商品介绍
			*/
			private String shangpinContent;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer shangpinDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public ShangpinLiuyanView() {

	}

	public ShangpinLiuyanView(ShangpinLiuyanEntity shangpinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set shangpin

					/**
					* 获取： 商品名称
					*/
					public String getShangpinName() {
						return shangpinName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setShangpinName(String shangpinName) {
						this.shangpinName = shangpinName;
					}

					/**
					* 获取： 商品编号
					*/
					public String getShangpinUuidNumber() {
						return shangpinUuidNumber;
					}
					/**
					* 设置： 商品编号
					*/
					public void setShangpinUuidNumber(String shangpinUuidNumber) {
						this.shangpinUuidNumber = shangpinUuidNumber;
					}

					/**
					* 获取： 商品照片
					*/
					public String getShangpinPhoto() {
						return shangpinPhoto;
					}
					/**
					* 设置： 商品照片
					*/
					public void setShangpinPhoto(String shangpinPhoto) {
						this.shangpinPhoto = shangpinPhoto;
					}

					/**
					* 获取： 商品类型
					*/
					public Integer getShangpinTypes() {
						return shangpinTypes;
					}
					/**
					* 设置： 商品类型
					*/
					public void setShangpinTypes(Integer shangpinTypes) {
						this.shangpinTypes = shangpinTypes;
					}


						/**
						* 获取： 商品类型的值
						*/
						public String getShangpinValue() {
							return shangpinValue;
						}
						/**
						* 设置： 商品类型的值
						*/
						public void setShangpinValue(String shangpinValue) {
							this.shangpinValue = shangpinValue;
						}

					/**
					* 获取： 商品库存
					*/
					public Integer getShangpinKucunNumber() {
						return shangpinKucunNumber;
					}
					/**
					* 设置： 商品库存
					*/
					public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
						this.shangpinKucunNumber = shangpinKucunNumber;
					}

					/**
					* 获取： 购买获得积分
					*/
					public Integer getShangpinPrice() {
						return shangpinPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setShangpinPrice(Integer shangpinPrice) {
						this.shangpinPrice = shangpinPrice;
					}

					/**
					* 获取： 商品原价
					*/
					public Double getShangpinOldMoney() {
						return shangpinOldMoney;
					}
					/**
					* 设置： 商品原价
					*/
					public void setShangpinOldMoney(Double shangpinOldMoney) {
						this.shangpinOldMoney = shangpinOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getShangpinNewMoney() {
						return shangpinNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setShangpinNewMoney(Double shangpinNewMoney) {
						this.shangpinNewMoney = shangpinNewMoney;
					}

					/**
					* 获取： 点击次数
					*/
					public Integer getShangpinClicknum() {
						return shangpinClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setShangpinClicknum(Integer shangpinClicknum) {
						this.shangpinClicknum = shangpinClicknum;
					}

					/**
					* 获取： 商品介绍
					*/
					public String getShangpinContent() {
						return shangpinContent;
					}
					/**
					* 设置： 商品介绍
					*/
					public void setShangpinContent(String shangpinContent) {
						this.shangpinContent = shangpinContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getShangpinDelete() {
						return shangpinDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShangpinDelete(Integer shangpinDelete) {
						this.shangpinDelete = shangpinDelete;
					}



















				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}

					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}

					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}



}
