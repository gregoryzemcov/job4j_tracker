package ru.job4j.tracker.profession;
/**
 * Класс Student, наследуемый от класса Teacher.
 * @author Gregory Zemtsov (griffondark@gmail.com).
 * @version $Id$.
 * @since 06.05.2019.
 */
 public class Student extends Teacher {
 	private String name;
 	private String group;
 	private String data;
 	private String teach;
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTeach() {
		return teach;
	}
	public void setTeach(String teach) {
		this.teach = teach;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}