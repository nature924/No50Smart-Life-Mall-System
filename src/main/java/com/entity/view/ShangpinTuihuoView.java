package com.entity.view;

import com.entity.ShangpinTuihuoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品退货
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shangpin_tuihuo")
public class ShangpinTuihuoView extends ShangpinTuihuoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 退货状态的值
		*/
		private String shangpinTuihuoValue;
		/**
		* 审核状态的值
		*/
		private String shangpinTuihuoYesnoValue;



		//级联表 shangpin_order
			/**
			* 订单号
			*/
			private String shangpinOrderUuidNumber;
			/**
			* 商品订单 的 用户
			*/
			private Integer shangpinOrderYonghuId;
			/**
			* 购买数量
			*/
			private Integer buyNumber;
			/**
			* 实付价格
			*/
			private Double shangpinOrderTruePrice;
			/**
			* 快递公司
			*/
			private String shangpinOrderCourierName;
			/**
			* 订单快递单号
			*/
			private String shangpinOrderCourierNumber;
			/**
			* 订单类型
			*/
			private Integer shangpinOrderTypes;
				/**
				* 订单类型的值
				*/
				private String shangpinOrderValue;
			/**
			* 支付类型
			*/
			private Integer shangpinOrderPaymentTypes;
				/**
				* 支付类型的值
				*/
				private String shangpinOrderPaymentValue;

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

	public ShangpinTuihuoView() {

	}

	public ShangpinTuihuoView(ShangpinTuihuoEntity shangpinTuihuoEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinTuihuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 退货状态的值
			*/
			public String getShangpinTuihuoValue() {
				return shangpinTuihuoValue;
			}
			/**
			* 设置： 退货状态的值
			*/
			public void setShangpinTuihuoValue(String shangpinTuihuoValue) {
				this.shangpinTuihuoValue = shangpinTuihuoValue;
			}
			/**
			* 获取： 审核状态的值
			*/
			public String getShangpinTuihuoYesnoValue() {
				return shangpinTuihuoYesnoValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setShangpinTuihuoYesnoValue(String shangpinTuihuoYesnoValue) {
				this.shangpinTuihuoYesnoValue = shangpinTuihuoYesnoValue;
			}




























				//级联表的get和set shangpin_order

					/**
					* 获取： 订单号
					*/
					public String getShangpinOrderUuidNumber() {
						return shangpinOrderUuidNumber;
					}
					/**
					* 设置： 订单号
					*/
					public void setShangpinOrderUuidNumber(String shangpinOrderUuidNumber) {
						this.shangpinOrderUuidNumber = shangpinOrderUuidNumber;
					}



					/**
					* 获取：商品订单 的 用户
					*/
					public Integer getShangpinOrderYonghuId() {
						return shangpinOrderYonghuId;
					}
					/**
					* 设置：商品订单 的 用户
					*/
					public void setShangpinOrderYonghuId(Integer shangpinOrderYonghuId) {
						this.shangpinOrderYonghuId = shangpinOrderYonghuId;
					}


					/**
					* 获取： 购买数量
					*/
					public Integer getBuyNumber() {
						return buyNumber;
					}
					/**
					* 设置： 购买数量
					*/
					public void setBuyNumber(Integer buyNumber) {
						this.buyNumber = buyNumber;
					}

					/**
					* 获取： 实付价格
					*/
					public Double getShangpinOrderTruePrice() {
						return shangpinOrderTruePrice;
					}
					/**
					* 设置： 实付价格
					*/
					public void setShangpinOrderTruePrice(Double shangpinOrderTruePrice) {
						this.shangpinOrderTruePrice = shangpinOrderTruePrice;
					}

					/**
					* 获取： 快递公司
					*/
					public String getShangpinOrderCourierName() {
						return shangpinOrderCourierName;
					}
					/**
					* 设置： 快递公司
					*/
					public void setShangpinOrderCourierName(String shangpinOrderCourierName) {
						this.shangpinOrderCourierName = shangpinOrderCourierName;
					}

					/**
					* 获取： 订单快递单号
					*/
					public String getShangpinOrderCourierNumber() {
						return shangpinOrderCourierNumber;
					}
					/**
					* 设置： 订单快递单号
					*/
					public void setShangpinOrderCourierNumber(String shangpinOrderCourierNumber) {
						this.shangpinOrderCourierNumber = shangpinOrderCourierNumber;
					}

					/**
					* 获取： 订单类型
					*/
					public Integer getShangpinOrderTypes() {
						return shangpinOrderTypes;
					}
					/**
					* 设置： 订单类型
					*/
					public void setShangpinOrderTypes(Integer shangpinOrderTypes) {
						this.shangpinOrderTypes = shangpinOrderTypes;
					}


						/**
						* 获取： 订单类型的值
						*/
						public String getShangpinOrderValue() {
							return shangpinOrderValue;
						}
						/**
						* 设置： 订单类型的值
						*/
						public void setShangpinOrderValue(String shangpinOrderValue) {
							this.shangpinOrderValue = shangpinOrderValue;
						}

					/**
					* 获取： 支付类型
					*/
					public Integer getShangpinOrderPaymentTypes() {
						return shangpinOrderPaymentTypes;
					}
					/**
					* 设置： 支付类型
					*/
					public void setShangpinOrderPaymentTypes(Integer shangpinOrderPaymentTypes) {
						this.shangpinOrderPaymentTypes = shangpinOrderPaymentTypes;
					}


						/**
						* 获取： 支付类型的值
						*/
						public String getShangpinOrderPaymentValue() {
							return shangpinOrderPaymentValue;
						}
						/**
						* 设置： 支付类型的值
						*/
						public void setShangpinOrderPaymentValue(String shangpinOrderPaymentValue) {
							this.shangpinOrderPaymentValue = shangpinOrderPaymentValue;
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
