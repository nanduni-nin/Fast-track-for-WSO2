<%@ page import="org.apache.axis2.context.ConfigurationContext"%>
<%@ page import="org.wso2.carbon.CarbonConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil"%>
<%@ page import="org.wso2.carbon.utils.ServerConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage"%>
<%@ page import="org.wso2.carbon.order.mgt.ui.OrderManagerClient"%>
<%@ page import="org.wso2.carbon.order.mgt.data.xsd.Item"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"
	prefix="carbon"%>
<%
	String serverURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
        ConfigurationContext configContext =
                (ConfigurationContext) config.getServletContext().getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
        String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);
 
        OrderManagerClient client;
        Item[] items;
 
        try {
            client = new OrderManagerClient(configContext, serverURL, cookie);
            items = client.getItems();
        } catch (Exception e) {
            CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>
<script type="text/javascript">
	location.href = "../admin/error.jsp";
</script>
<%
	return;
	}
%>

<div id="middle">
	<h2>Item Management</h2>

	<div id="workArea">
		<table class="styledLeft" id="moduleTable">
			<thead>
				<tr>
					<th width="20%">ID</th>
					<th width="40%">Item Name</th>
					<th width="40%">Item Price</th>
				
				</tr>
			</thead>
			<tbody>
				<%
					for (Item item : items) {
				%>
				<tr>
					<td><%=item.getItemId()%></td>
					<td><%=item.getName()%></td>
					<td><%=item.getPrice()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>