

import java.util.ArrayList;
import java.util.List;

public class RefactoringFinal {

	// 1a
	public int increaseAndReturnCount() {
		return count++;
	}

	// 1b
	public void findFilledOrders(List<Order> o) {
		for (Order order : orders) {
			if (order.isFilled()) {
				o.add(order);
			}
		}
	}

	// 2a
	public void printStatementFor(Long invoiceId) {
		List<InvoiceRow> invoiceRows = dao.getInvoiceRowsFor(invoiceId);

		printInvoiceRows(invoiceRows);

		// calculate invoice total
		double t = 0;
		for (InvoiceRow invoiceRow : invoiceRows) {
			t += invoiceRow.getAmount();
		}
		printValue(t);
	}

	// 2b
	public String getItemsAsHtml() {
		String retval = "";
		retval += "<ul>";
		retval += "<li>" + item1 + "</li>";
		retval += "<li>" + item2 + "</li>";
		retval += "<li>" + item3 + "</li>";
		retval += "<li>" + item4 + "</li>";
		retval += "</ul>";
		return retval;
	}

	 // 3
    public boolean isSmallOrder() {
    	double orderTotal = order.getTotal();
    	return (orderTotal > 100);
    }

	// 4
	public void printPrice() {

		double basePrice = getBasePrice();
		System.out.println("Hind ilma käibemaksuta: " + basePrice);
		System.out.println("Hind käibemaksuga: " + basePrice * 1.2);
	}

	// 5
	public void isOutOfCanvas(Shape shape) {
		// out of canvas, shape is square
	    if ((shape.x > 1000 || shape.y > 500) && shape.width == shape.height && shape.curvature == 0) {
	        // ...
	    }

	    // ...
	}

	// 6
	public boolean canAccessResource(SessionData sessionData) {

	    return ((sessionData.getCurrentUserName().equals("Admin")
	                || sessionData.getCurrentUserName().equals("Administrator"))
	            && (sessionData.getStatus().equals("preferredStatusX")
	                || sessionData.getStatus().equals("preferredStatusY")));
	}

	// 7
	public void drawLines() {
		Space space = new Space();
		space.drawLine(12, 3, 5, 2, 4, 6);
		space.drawLine(2, 4, 6, 0, 1, 0);
	}

	// 8
	public int calculateWeeklyPay(boolean overtime) {
		int straightTime = Math.min(40, hoursWorked);
		int overTime = Math.max(0, hoursWorked - straightTime);
		int straightPay = straightTime * hourRate;
		double overtimeRate = overtime ? 1.5 * hourRate : 1.0 * hourRate;
		int overtimePay = (int) Math.round(overTime * overtimeRate);
		return straightPay + overtimePay;
	}

	////////////////////////////////////////////////////////////////////////////

	// Abiväljad ja abimeetodid.
	// Need on siin lihtsalt selleks, et kood kompileeruks

	private String item1 = "1";
	private String item2 = "2";
	private String item3 = "3";
	private String item4 = "4";
	private int hoursWorked = 45;
	private int hourRate = 5;
	int count = 0;
	private List<Order> orders = new ArrayList<Order>();
	private Order order = new Order();
	private Dao dao = new SampleDao();
	private double price = 0;

	void justACaller() {
	    increaseAndReturnCount();
	    findFilledOrders(null);
	}

	private void printValue(double total) {
	}

	private void printInvoiceRows(List<InvoiceRow> invoiceRows) {
	}

	class Space {
		public void drawLine(int x1, int y1, int z1, int x2, int y2, int z2) {
		}

	}

	interface Dao {
		List<InvoiceRow> getInvoiceRowsFor(Long invoiceId);
	}

	class SampleDao implements Dao {
		@Override
		public List<InvoiceRow> getInvoiceRowsFor(Long invoiceId) {
			return null;
		}
	}

	class Order {
		public boolean isFilled() {
			return false;
		}
		public double getTotal() {
			return 0;
		}
	}

	class InvoiceRow {
		public double getAmount() {
			return 0;
		}
	}

	class Shape {

        public int y;
        public int x;
        public int curvature;
        public Object height;
        public Object width;
	}

    private double getBasePrice() {
        return price;
    }

    private class SessionData {

        public String getCurrentUserName() {
            return null;
        }

        public String getStatus() {
            return null;
        }

    }

}