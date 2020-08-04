package ru.job4j.tracker.profession;
/**
 * Класс Ingineer, наследуемый от класса Profession
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 05.05.2019.
 */
 public class Engineer extends Profession {
	 private String buildHome;
	 private String directionInConstruction;
	 public Engineer() { }
	 public Engineer(String name, String profession) {
		 this.name = name;
		 this.profession = directionInConstruction;
	 }
	 public String buildHome() {
		 return buildHome;
	 }
 }