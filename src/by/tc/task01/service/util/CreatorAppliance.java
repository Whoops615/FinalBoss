package by.tc.task01.service.util;

import java.util.Map;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

public class CreatorAppliance {
	
	private final String NAME_APPLIANCE = "name";

	public Appliance createAppliance(Map<String, Object> parameters) {

		Appliance appliance;

		String nameAppliance = (String) parameters.get(NAME_APPLIANCE);

		switch (nameAppliance) {
		case "Oven":
			appliance = createOven(parameters);
			break;
		case "Laptop":
			appliance = createLaptop(parameters);
			break;
		case "Refrigerator":
			appliance = createRefrigerator(parameters);
			break;
		case "VacuumCleaner":
			appliance = createVacuumCleaner(parameters);
			break;
		case "TabletPC":
			appliance = createTabletPC(parameters);
			break;
		case "Speakers":
			appliance = createSpeakers(parameters);
			break;
		default:
			appliance = null;

		}

		return appliance;
	}

	public Oven createOven(Map<String, Object> parameters) {

		Oven o = new Oven();

		o.setName((String) parameters.get(NAME_APPLIANCE));
		o.setPowerConsumption(Integer.parseInt((String) parameters.get(SearchCriteria.Oven.POWER_CONSUMPTION.name())));
		o.setWeight(Integer.parseInt((String) parameters.get(SearchCriteria.Oven.WEIGHT.name())));
		o.setCapacity(Integer.parseInt((String) parameters.get(SearchCriteria.Oven.CAPACITY.name())));
		o.setDepth(Integer.parseInt((String) parameters.get(SearchCriteria.Oven.DEPTH.name())));
		o.setHeight(Double.parseDouble((String) parameters.get(SearchCriteria.Oven.HEIGHT.name())));
		o.setWidth(Double.parseDouble((String) parameters.get(SearchCriteria.Oven.WIDTH.name())));

		return o;
	}

	public Laptop createLaptop(Map<String, Object> parameters) {

		Laptop l = new Laptop();

		l.setName((String) parameters.get(NAME_APPLIANCE));
		l.setBatteryCapacity(
				Double.parseDouble((String) parameters.get(SearchCriteria.Laptop.BATTERY_CAPACITY.name())));
		l.setOs((String) parameters.get(SearchCriteria.Laptop.OS.name()));
		l.setMemoryRom(Integer.parseInt((String) parameters.get(SearchCriteria.Laptop.MEMORY_ROM.name())));
		l.setSystemMemory(Integer.parseInt((String) parameters.get(SearchCriteria.Laptop.SYSTEM_MEMORY.name())));
		l.setCpu(Double.parseDouble((String) parameters.get(SearchCriteria.Laptop.CPU.name())));
		l.setDisplayInchs(Integer.parseInt((String) parameters.get(SearchCriteria.Laptop.DISPLAY_INCHS.name())));

		return l;
	}

	public Refrigerator createRefrigerator(Map<String, Object> parameters) {

		Refrigerator r = new Refrigerator();

		r.setName((String) parameters.get(NAME_APPLIANCE));
		r.setPowerConsumption(
				Integer.parseInt((String) parameters.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.name())));
		r.setWeight(Integer.parseInt((String) parameters.get(SearchCriteria.Refrigerator.WEIGHT.name())));
		r.setFreezerCapacity(
				Integer.parseInt((String) parameters.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.name())));
		r.setOverallCapacity(
				Double.parseDouble((String) parameters.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.name())));
		r.setHeight(Integer.parseInt((String) parameters.get(SearchCriteria.Refrigerator.HEIGHT.name())));
		r.setWidth(Integer.parseInt((String) parameters.get(SearchCriteria.Refrigerator.WIDTH.name())));

		return r;
	}

	public VacuumCleaner createVacuumCleaner(Map<String, Object> parameters) {

		VacuumCleaner vc = new VacuumCleaner();

		vc.setName((String) parameters.get(NAME_APPLIANCE));
		vc.setPowerConsumption(
				Integer.parseInt((String) parameters.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.name())));
		vc.setFilterType((String) parameters.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.name()));
		vc.setBagType((String) parameters.get(SearchCriteria.VacuumCleaner.BAG_TYPE.name()));
		vc.setWandType((String) parameters.get(SearchCriteria.VacuumCleaner.WAND_TYPE.name()));
		vc.setMotorSpeeadRegulation(
				Integer.parseInt((String) parameters.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.name())));
		vc.setCleaningWidth(
				Integer.parseInt((String) parameters.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.name())));

		return vc;
	}

	public TabletPC createTabletPC(Map<String, Object> parameters) {

		TabletPC t = new TabletPC();

		t.setName((String) parameters.get(NAME_APPLIANCE));
		t.setBatteryCapacyti(
				Integer.parseInt((String) parameters.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.name())));
		t.setDisplayInches(Integer.parseInt((String) parameters.get(SearchCriteria.TabletPC.DISPLAY_INCHES.name())));
		t.setMemoryRom(Integer.parseInt((String) parameters.get(SearchCriteria.TabletPC.MEMORY_ROM.name())));
		t.setFlashMemoryCapasity(
				Integer.parseInt((String) parameters.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.name())));
		t.setColor((String) parameters.get(SearchCriteria.TabletPC.COLOR.name()));

		return t;
	}

	public Speakers createSpeakers(Map<String, Object> parameters) {

		Speakers sp = new Speakers();

		sp.setName((String) parameters.get(NAME_APPLIANCE));
		sp.setPowerConsumption(
				Integer.parseInt((String) parameters.get(SearchCriteria.Speakers.POWER_CONSUMPTION.name())));
		sp.setNumberOfSpeakers(
				Integer.parseInt((String) parameters.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name())));
		sp.setFrequencyRange((String) parameters.get(SearchCriteria.Speakers.FREQUENCY_RANGE.name()));
		sp.setCordLength(Integer.parseInt((String) parameters.get(SearchCriteria.Speakers.CORD_LENGTH.name())));

		return sp;
	}

}
