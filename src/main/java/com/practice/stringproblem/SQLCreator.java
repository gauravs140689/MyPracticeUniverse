package com.practice.stringproblem;

public class SQLCreator {

	public static void main(String[] args) {
		String[] columns = { "ID", "Name", "Father_Name" };
		int ageLimit = 25;
		String table = "Employee";
		String q = createQuery(columns, ageLimit, table);

		System.out.println(q);
		// select ID,Name,Father_Name from Employee where age>25
	}

	private static String createQuery(String[] columns, int ageLimit, String tableName) {
		StringBuilder query = new StringBuilder();

		query.append("select ");
		boolean isFirst = true;
		for (String col : columns) {
			if (isFirst) {
				isFirst=false;
			} else {
				query.append(",");
			}
			query.append(col);
			

		}
		query.append(" from "+tableName + " where age > " + ageLimit);

		return query.toString();
	}

}
