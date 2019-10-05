package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ServiceFactory;
import by.tc.task01.service.util.CreatorAppliance;

public class ApplianceDAOImpl implements ApplianceDAO {

	private static final String APPLIANCE_SOURSE = "resources/appliances_db.txt";

	private static final Pattern APPLIANCE_PARAMETERS = Pattern.compile("([A-Z|\u005F]+)=([a-zA-Z|0-9|.|-]+)");

	@Override
	public List<Appliance> find(Criteria criteria) throws DAOException {

		ServiceFactory factory = ServiceFactory.getInstance();
		CreatorAppliance creator = factory.getCreatorAppliance();

		List<Appliance> appliances = new ArrayList<Appliance>();
		List<String> resultRead;
		Map<String, Object> parameters;

		Appliance a;

		try {

			resultRead = readFile(criteria);

			for (String s : resultRead) {

				parameters = getParametersAppliance(s);
				a = creator.createAppliance(parameters);
				appliances.add(a);

			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return appliances;
	}

	private Map<String, Object> getParametersAppliance(String strData) {

		Map<String, Object> parameters = new HashMap<String, Object>();

		Matcher m = APPLIANCE_PARAMETERS.matcher(strData);

		parameters.put("name", strData.split(" ")[0]);

		while (m.find()) {
			String nameParameter = m.group(1);
			Object valueParameter = m.group(2);
			parameters.put(nameParameter, valueParameter);

		}

		return parameters;
	}

	private List<String> readFile(Criteria criteria) throws FileNotFoundException, IOException {

		List<String> result = new ArrayList<String>();
		String readLine;

		List<Pattern> pattern = createPatternOfCriteria(criteria);

		try (BufferedReader b = new BufferedReader(new FileReader(APPLIANCE_SOURSE))) {

			while ((readLine = b.readLine()) != null) {
				if (isCheck(readLine, pattern)) {
					result.add(readLine);
				}
			}
		}

		return result;
	}

	private List<Pattern> createPatternOfCriteria(Criteria criteria) {

		List<Pattern> result = new ArrayList<Pattern>();
		Map<String, Object> c = criteria.getCriteria();

		for (Map.Entry<String, Object> entry : c.entrySet()) {
			Pattern p = Pattern.compile(entry.toString());
			result.add(p);
		}
		result.add(Pattern.compile(criteria.getGroupSearchName()));

		return result;
	}

	private boolean isCheck(String str, List<Pattern> patterns) {

		for (Pattern p : patterns) {

			Matcher m = p.matcher(str);
			if (m.find()) {

			} else {
				return false;
			}
		}

		return true;
	}

}
