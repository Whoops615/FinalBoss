package by.tc.task01.service.validation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.entity.criteria.Criteria;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) {

		String nameAppliance = criteria.getGroupSearchName();

		switch (nameAppliance) {
		case "Oven":
			return isCheckOven(criteria.getCriteria());
		case "Laptop":
			return false;
		case "Refrigerator":
			return false;
		case "VacuumCleaner":
			return false;
		case "TabletPC":
			return false;
		case "Speakers":
			return false;
		default:
			return false;

		}

	}

	private static boolean isCheckOven(Map<String, Object> param) {

		for (Entry<String, Object> entry : param.entrySet()) {

			if (!isCheckParameterOven(entry.getKey(), entry.getValue())) {
				return false;
			}
		}

		return true;
	}

	private static boolean isCheckParameterOven(String str, Object o) {

		switch (str) {
		case "POWER_CONSUMPTION":

			if (!isCheckInt(o)) {
				return false;
			}
			int powerConsumption = Integer.parseInt(o.toString());
			if (powerConsumption >= 500 & powerConsumption <= 5000) {
				return true;
			} else {
				return false;
			}
		case "WEIGHT":

			if (!isCheckInt(o)) {
				return false;
			}

			int weight = Integer.parseInt(o.toString());
			if (weight >= 5 & weight <= 50) {
				return true;
			} else {
				return false;
			}
		case "CAPACITY":

			if (!isCheckInt(o)) {
				return false;
			}

			int capacity = Integer.parseInt(o.toString());
			if (capacity >= 20 & capacity <= 60) {
				return true;
			} else {
				return false;
			}
		case "DEPTH":

			if (!isCheckInt(o)) {
				return false;
			}

			int depth = Integer.parseInt(o.toString());
			if (depth >= 40 & depth <= 80) {
				return true;
			} else {
				return false;
			}
		case "HEIGHT":

			if (!isCheckDouble(o)) {
				return false;
			}

			double height = Double.parseDouble(o.toString());
			if (height >= 40 & height <= 50) {
				return true;
			} else {
				return false;
			}

		case "WIDTH":

			if (!isCheckDouble(o)) {
				return false;
			}

			double width = Double.parseDouble(o.toString());
			if (width >= 55 & width <= 73) {
				return true;
			} else {
				return false;
			}

		default:
			return false;

		}

	}

	public static boolean isCheckInt(Object o) {

		Pattern p = Pattern.compile("\\d{1,9}");
		Matcher m = p.matcher(o.toString());
		if (m.matches()) {
			return true;
		}

		return false;
	}

	public static boolean isCheckDouble(Object o) {
		Pattern p = Pattern.compile("\\d+.?\\d+");
		Matcher m = p.matcher(o.toString());
		if (m.matches()) {
			return true;
		}

		return false;
	}

}
