package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;
import by.tc.task01.service.util.CreatorAppliance;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();
	private final CreatorAppliance creatorAppliance = new CreatorAppliance();
	
	private ServiceFactory() {}

	public ApplianceService getApplianceService() {

		return applianceService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public  CreatorAppliance getCreatorAppliance() {
		return creatorAppliance;
	}

}
