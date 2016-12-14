import java.util.ArrayList;
import java.util.List;

public class RefactoringFinal {

	private static final double VAT = 1.2;

	// 1a
	public int increaseAndReturnCount() {
		return count++;
	}

	// 1b
	public void addFilledOrders(List<Order> o) {
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
		printValue(invoiceTotal(invoiceRows));
	}

	private double invoiceTotal(List<InvoiceRow> invoiceRows) {
		double t = 0;
		for (InvoiceRow invoiceRow : invoiceRows) {
			t += invoiceRow.getAmount();
		}
		return t;
	}

	// 2b
	public String getItemsAsHtml(String tag1, String tag2, String... items) {
		return htmlTag(tag1, htmlTag(tag2, items));
	}

	private String htmlTag(String tag2, String[] items) {
		String retval = "";
		for (String item : items) {
			retval += htmlTag(tag2, item);
		}
		return retval;
	}

	private String htmlTag(String tag, String item) {
		return "<" + tag + ">" + item + "</" + tag + ">";
	}

	// 3
	public boolean isSmallOrder() {
		return order.getTotal() > 100;
	}

	// 4
	public void printPrice() {
		System.out.println("Hind ilma käibemaksuta: " + getBasePrice());
		System.out.println("Hind käibemaksuga: " + getBasePrice() * VAT);
	}

	// 5
	public void isOutOfCanvas(Shape shape) {
		// out of canvas, shape is square
		boolean onCanvas = shape.x > 1000 || shape.y > 500;
		boolean isSquar = shape.width == shape.height && shape.curvature == 0;
		if (onCanvas && isSquar) {
			// ...
		}

		// ...
	}

	// 6
	public boolean canAccessResource(SessionData sessionData) {
		return isAdmin(sessionData) && isStatusCorrect(sessionData);
	}

	private boolean isStatusCorrect(SessionData sessionData) {
		return sessionData.getStatus().equals("preferredStatusX")
				|| sessionData.getStatus().equals("preferredStatusY");
	}

	private boolean isAdmin(SessionData sessionData) {
		return sessionData.getCurrentUserName().equals("Admin")
				|| sessionData.getCurrentUserName().equals("Administrator");
	}

	public static class Point {
		int x, y, z;

		/**
		 * @param x
		 * @param y
		 * @param z
		 */
		public Point(int x, int y, int z) {

			this.x = x;
			this.y = y;
			this.z = z;
		}

		public Point() {

		}
	}

	// 7
	public void drawLines() {
		Space space = new Space();
		Point point1 = new Point(12, 3, 5);
		Point point2 = new Point(2, 4, 6);
		Point point3 = new Point(0, 1, 0);
		space.drawLine(point1, point2);
		space.drawLine(point2, point3);
	}

	// 8
	public int calculateWeeklyPay(boolean overtime) {
		if (overtime) {
			return getStraightPay() + getOvertimePay();
		}
		return getStraightPay();
	}

	private int getOvertimePay() {
		return (int) Math.round(getOverTime() * getOvertimeRate());
	}

	private double getOvertimeRate() {
		return 1.5 * hourRate;
	}

	private int getStraightPay() {
		return getStraightTime() * hourRate;
	}

	private int getOverTime() {
		return Math.max(0, hoursWorked - getStraightTime());
	}

	private int getStraightTime() {
		return Math.min(40, hoursWorked);
	}

	// //////////////////////////////////////////////////////////////////////////

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
		getCount();
		addFilledOrders(null);
	}

	private void printValue(double total) {
	}

	private void printInvoiceRows(List<InvoiceRow> invoiceRows) {
	}

	class Space {
		public void drawLine(int x1, int y1, int z1, int x2, int y2, int z2) {
		}

		public void drawLine(Point point, Point point2) {
			// TODO Auto-generated method stub

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