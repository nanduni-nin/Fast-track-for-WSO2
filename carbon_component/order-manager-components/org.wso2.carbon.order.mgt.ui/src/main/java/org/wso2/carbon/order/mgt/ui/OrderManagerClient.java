package org.wso2.carbon.order.mgt.ui;
/**
 * OrderManagerClient works as an interface between Order Processor back-end 
 * and the front-end
 */

import java.rmi.RemoteException;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.wso2.carbon.order.mgt.data.xsd.Item;
import org.wso2.carbon.order.mgt.stub.OrderManagerStub;

public class OrderManagerClient {

	private OrderManagerStub stub;

	public OrderManagerClient(ConfigurationContext configCtx,
			String backendServerURL, String cookie) throws Exception {
		String serviceURL = backendServerURL + "OrderManager";
		stub = new OrderManagerStub(configCtx, serviceURL);
		ServiceClient client = stub._getServiceClient();
		Options options = client.getOptions();
		options.setManageSession(true);
		options.setProperty(
				org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
				cookie);

	}

	/***
	 * 
	 * @return: a list of items in the order processor database
	 * @throws Exception
	 */
	public Item[] getItems() throws Exception {
		try {
			return stub.getItems();
		} catch (RemoteException e) {
			String msg = "Cannot get the list of orders"
					+ " . message: "+e.getMessage();
			throw new Exception(msg, e);
		}
	}
}
