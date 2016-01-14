h1. magento-j
"magento-j" is a Java connector for Magento's rest API

The goal its build a java interface to access the Magento API and exchange data.

h2. Usage:

bc. MagentoCredentials creds = MagentoCredentials.createWithTokenCustomRestApi(SHOP_URL, CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_SECRET, CUSTOM_REST_API);
*CUSTOM_REST_API parameter is optional. It is to be used only when you have custom rest api end point.
MagentoClient client = new MagentoClient(creds);

h3. Customer

bc.CustomerService customerService = client.getService(CustomerService.class);
List<Customer> customers = customerService.getCustomers(); //can pass the page, limit parameters
System.out.println("orders = " + new Gson().toJson(customers));

h3. Order

bc.OrderService orderService = client.getService(OrderService.class);
List<Order> orders = orderService.getOrders(); //can pass the parameter List<Long> orderIds
System.out.println("orders = " + new Gson().toJson(orders));

