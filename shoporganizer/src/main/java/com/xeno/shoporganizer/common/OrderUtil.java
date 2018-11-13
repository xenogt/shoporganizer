package com.xeno.shoporganizer.common;

import com.xeno.shoporganizer.model.Order;
import com.xeno.shoporganizer.model.Payment;
import com.xeno.shoporganizer.model.PaymentMethod;
import com.xeno.shoporganizer.repository.OrderRepository;
import com.xeno.shoporganizer.repository.PaymentMethodRepository;
import com.xeno.shoporganizer.repository.PaymentRepository;
import com.xeno.shoporganizer.venderdata.model.AmazonReport;

public class OrderUtil {
	
	private static PaymentMethodRepository pmr = new PaymentMethodRepository();
	private static PaymentRepository pr = new PaymentRepository();
	private static OrderRepository or = new OrderRepository();
	
	public static void buildOrderFromAmazonReport(AmazonReport amazonOrder) {
		
		String fromReport = amazonOrder.getPaymentInstrumentType().split(" ")[2];
		
		PaymentMethod pm = pmr.getByKeyValuePair("account_number", fromReport);
		
		Payment payment = new Payment();
		payment.setPaymentMethodID(pm.getPaymentMethodID());
		payment.setPayOnDate(amazonOrder.getOrderDate());
		pr.add(payment);
		
		Order order = new Order();
		order.setOrderNumber(amazonOrder.getOrderID());
		order.setOrderDate(amazonOrder.getOrderDate());
		order.setPaymentID(payment.getPaymentID());
		//TODO need to fetch shop_id from db base on report email == registered_id
		order.setShopID(1);
		or.add(order);
	}
	
}
